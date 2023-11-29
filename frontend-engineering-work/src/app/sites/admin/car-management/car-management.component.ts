import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Car } from 'src/app/models/car';
import { CarModel } from 'src/app/models/car-model';
import { Engine } from 'src/app/models/engine';
import { CarService } from 'src/app/services/car.service';

@Component({
  selector: 'app-car-management',
  templateUrl: './car-management.component.html',
  styleUrls: ['./car-management.component.scss']
})
export class CarManagementComponent {
  cars!: Car[]; // Lista samochodów
  carForm!: FormGroup; // Formularz dla samochodu
  isFormVisible: boolean = false;
  isCarEdited: boolean = false;
  displayedColumns: string[] = ['brand', 'model', 'productionYear', 'topSpeed', 'power', 'rentPrizePerDay', 'actions'];

  constructor(private formBuilder: FormBuilder, private carService:CarService) {}

  ngOnInit(): void {
    this.getAllCars();
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

  openForm() {
    this.isFormVisible = true;
  }

  closeForm() {
    this.isFormVisible = false;
    this.isCarEdited = false;
  }


  getAllCars(){
    this.carService.getCarsRequest().subscribe((response: any) => {
      this.cars = response;
    })
  }

  addNewCar(newCar:Car) {
    this.carService.addCarRequest(newCar).subscribe((response:any) => {
      const car = response;
      this.cars = [...this.cars, car];
    })
  }

  editCar(editedCar:Car){
    this.carService.editCarRequest(editedCar).subscribe((response:any) => {
      const car = response;
      this.cars = [ ...this.cars.filter(obj => obj.id !== editedCar.id), car];
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
    ))
  }

  showImagesCar(car:Car) {
    throw new Error('Method not implemented.');
  }

  addImage(car:Car) {
    throw new Error('Method not implemented.');
  }

}

