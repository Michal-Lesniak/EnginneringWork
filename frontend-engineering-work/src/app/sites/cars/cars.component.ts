import { Component, OnInit } from '@angular/core';
import { CarService } from 'src/app/services/car.service';

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.scss']
})
export class CarsComponent implements OnInit{

  // cars: Car[] = [];

  constructor(private carService:CarService){

  }

  ngOnInit(): void {
    // this.apiService.getCars().subscribe((response: any ) => {
    //   console.log(response);
    //   this.cars = response;
    // });
  }


  cars = [
    {
      name: 'Lamborghini Huracán EVO',
      imageUrl: '../assets/LAMBORGHINI-URUS-8-1-600x338.jpeg',
      price: '1500',
      acceleration: '2,9 s do 100 km/h',
      gearbox: 'Auto',
      power: '640 KM / 600 Nm',
      seats: '2'
    },
    {
      name: 'Lamborghini Huracán EVO',
      imageUrl: '../assets/rsq7.jpg',
      price: '1500',
      acceleration: '2,9 s do 100 km/h',
      gearbox: 'Auto',
      power: '640 KM / 600 Nm',
      seats: '2'
    },
    {
      name: 'Lamborghini Huracán EVO',
      imageUrl: '../assets/rsq7.jpg',
      price: '1500',
      acceleration: '2,9 s do 100 km/h',
      gearbox: 'Auto',
      power: '640 KM / 600 Nm',
      seats: '2'
    },
    {
      name: 'Lamborghini Huracán EVO',
      imageUrl: '../assets/LAMBORGHINI-URUS-8-1-600x338.jpeg',
      price: '1500',
      acceleration: '2,9 s do 100 km/h',
      gearbox: 'Auto',
      power: '640 KM / 600 Nm',
      seats: '2'
    },
    {
      name: 'Lamborghini Huracán EVO',
      imageUrl: '../assets/rsq7.jpg',
      price: '1500',
      acceleration: '2,9 s do 100 km/h',
      gearbox: 'Auto',
      power: '640 KM / 600 Nm',
      seats: '2'
    },
    {
      name: 'Lamborghini Huracán EVO',
      imageUrl: '../assets/rsq7.jpg',
      price: '1500',
      acceleration: '2,9 s do 100 km/h',
      gearbox: 'Auto',
      power: '640 KM / 600 Nm',
      seats: '2'
    },
  ];
}
