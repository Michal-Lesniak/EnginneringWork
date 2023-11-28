import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Car } from 'src/app/models/car';
import { CarModel } from 'src/app/models/car-model';
import { Engine } from 'src/app/models/engine';

@Component({
  selector: 'app-car-management',
  templateUrl: './car-management.component.html',
  styleUrls: ['./car-management.component.scss']
})
export class CarManagementComponent {

  cars: Car[] = cars; // Lista samochodów
  carForm!: FormGroup; // Formularz dla samochodu
  isCarEdited: boolean = false;
  displayedColumns: string[] = ['brand', 'model', 'productionYear', 'topSpeed', 'power', 'rentPrizePerDay', 'actions'];

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    this.carForm = this.formBuilder.group({
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
      const newCar: Car = {
        ...this.carForm.value
      };
      this.cars.push(newCar);
      this.carForm.reset();
    }
  }

  addNewCar() {
    this.isCarEdited = true;
  }

  editCar(car: Car) {
    // Logika edycji samochodu
  }

  deleteCar(carId: number) {
    this.cars = this.cars.filter(c => c.id !== carId);
    // Logika usuwania samochodu z serwisu
  }


}


const engine1: Engine = {
  id: 1,
  engineCapacity: 2000,
  power: 150,
  torque: 200,
  fuel: 'Petrol'
};

const engine2: Engine = {
  id: 2,
  engineCapacity: 3000,
  power: 250,
  torque: 300,
  fuel: 'Diesel'
};

const carModel1: CarModel = {
  id: 1,
  name: 'Model S',
  engine: engine1,
  type: 'Sedan',
  seats: '5',
  drive: 'RWD',
  transmission: 'Automatic',
  topSpeed: '250km/h',
  fuelConsumption: '8l/100km'
};

const carModel2: CarModel = {
  id: 2,
  name: 'Model X',
  engine: engine2,
  type: 'SUV',
  seats: '7',
  drive: 'AWD',
  transmission: 'Automatic',
  topSpeed: '220km/h',
  fuelConsumption: '10l/100km'
};

const cars: Car[] = [
  {
    id: 1,
    brand: 'Tesla',
    rentPrizePerDay: 500,
    model: carModel1,
    productionYear: 2020
  },
  {
    id: 2,
    brand: 'Tesla',
    rentPrizePerDay: 700,
    model: carModel2,
    productionYear: 2021
  }
];

