import { Component, OnInit } from '@angular/core';
import { Car } from 'src/app/models/car';
import { ApiServiceService } from 'src/app/services/api-service.service';

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.scss']
})
export class CarsComponent implements OnInit{

  constructor(private apiService:ApiServiceService){
    this.apiService.getCars().subscribe((response: any ) => {
      console.log(response);
    });
  }

  ngOnInit(): void {

  }


  // cars = [
  //   {
  //     name: 'Lamborghini Huracán EVO',
  //     imageUrl: '../assets/LAMBORGHINI-URUS-8-1-600x338.jpeg',
  //     price: '1500',
  //     acceleration: '2,9 s do 100 km/h',
  //     gearbox: 'Auto',
  //     power: '640 KM / 600 Nm',
  //     seats: '2'
  //   },
  //   {
  //     name: 'Lamborghini Huracán EVO',
  //     imageUrl: '../assets/rsq7.jpg',
  //     price: '1500',
  //     acceleration: '2,9 s do 100 km/h',
  //     gearbox: 'Auto',
  //     power: '640 KM / 600 Nm',
  //     seats: '2'
  //   },
  //   {
  //     name: 'Lamborghini Huracán EVO',
  //     imageUrl: '../assets/rsq7.jpg',
  //     price: '1500',
  //     acceleration: '2,9 s do 100 km/h',
  //     gearbox: 'Auto',
  //     power: '640 KM / 600 Nm',
  //     seats: '2'
  //   },
  //   {
  //     name: 'Lamborghini Huracán EVO',
  //     imageUrl: '../assets/LAMBORGHINI-URUS-8-1-600x338.jpeg',
  //     price: '1500',
  //     acceleration: '2,9 s do 100 km/h',
  //     gearbox: 'Auto',
  //     power: '640 KM / 600 Nm',
  //     seats: '2'
  //   },
  //   {
  //     name: 'Lamborghini Huracán EVO',
  //     imageUrl: '../assets/rsq7.jpg',
  //     price: '1500',
  //     acceleration: '2,9 s do 100 km/h',
  //     gearbox: 'Auto',
  //     power: '640 KM / 600 Nm',
  //     seats: '2'
  //   },
  //   {
  //     name: 'Lamborghini Huracán EVO',
  //     imageUrl: '../assets/rsq7.jpg',
  //     price: '1500',
  //     acceleration: '2,9 s do 100 km/h',
  //     gearbox: 'Auto',
  //     power: '640 KM / 600 Nm',
  //     seats: '2'
  //   },
  // ];
}
