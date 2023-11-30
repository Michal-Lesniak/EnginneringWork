import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Car } from 'src/app/models/car';
import { CarService } from 'src/app/services/car.service';
import { ImageCarServiceService } from 'src/app/services/image-car-service.service';

@Component({
  selector: 'app-car-management',
  templateUrl: './car-management.component.html',
  styleUrls: ['./car-management.component.scss']
})
export class CarManagementComponent implements OnInit {
  @Input() cars!: Car[];
  @Output() carsChange = new EventEmitter<Car[]>();
  carForm!: FormGroup;
  isFormVisible: boolean = false;
  isCarEdited: boolean = false;
  displayedColumns: string[] = ['brand', 'model', 'productionYear', 'topSpeed', 'power', 'rentPrizePerDay', 'actions'];

  constructor(private formBuilder: FormBuilder, private carService:CarService, private imageCarService:ImageCarServiceService ) {}

  ngOnInit(): void {
    this.carForm = this.formBuilder.group({
      id: [''],
      brand: ['', Validators.required],
      rentPrizePerDay: ['', [Validators.required, Validators.min(0)]],
      productionYear: ['', [Validators.required, Validators.min(1900)]],
      model: this.formBuilder.group({
        name: ['', Validators.required],
        type: ['', Validators.required],
        seats: ['', Validators.required],
        drive: ['', Validators.required],
        transmission: ['', Validators.required],
        topSpeed: ['', Validators.required],
        fuelConsumption: ['', Validators.required],
        engine: this.formBuilder.group({
          engineCapacity: ['', [Validators.required, Validators.min(0)]],
          power: ['', [Validators.required, Validators.min(0)]],
          torque: ['', [Validators.required, Validators.min(0)]],
          fuel: ['', Validators.required],
        })
      })
    });
  }

  submitForm() {
    if (this.carForm.valid) {
      const car: Car = {
        ...this.carForm.value
      };
      if(this.isCarEdited){
        this.editCar(car);
      }else{
        this.addNewCar(car);
      }
      this.carForm.reset();
      this.closeForm();
    }
  }

  onFileSelected(carId:number ,event:any) {

    const file:File = event.target.files[0];

    if (file) {
        const formData = new FormData();

        formData.append("file", file);
        formData.append("carId", carId.toString());

        const upload$ = this.imageCarService.uploadImageRequest(formData);

        upload$.subscribe();
    }
}

  openForm() {
    this.isFormVisible = true;
  }

  closeForm() {
    this.isFormVisible = false;
    this.isCarEdited = false;
  }

  addNewCar(newCar:Car) {
    this.carService.addCarRequest(newCar).subscribe((response:any) => {
      const car = response;
      this.cars = [...this.cars, car];
      this.carsChange.emit(this.cars);
    })
  }

  editCar(editedCar:Car){
    this.carService.editCarRequest(editedCar).subscribe((response:any) => {
      const car = response;
      this.cars = [ ...this.cars.filter(obj => obj.id !== editedCar.id), car];
      this.carsChange.emit(this.cars);
    })
  }

  editCarAction(car: Car) {
    this.carForm.patchValue(car);
    this.isFormVisible = true;
    this.isCarEdited = true;
  }

  deleteCar(car:Car) {
    this.carService.deleteCarRequest(car.id!).subscribe(() =>
    this.cars = this.cars.filter(obj => obj !== car
    ));
    this.carsChange.emit(this.cars);
  }

  showImagesCar(car:Car) {
    throw new Error('Method not implemented.');
  }
}

