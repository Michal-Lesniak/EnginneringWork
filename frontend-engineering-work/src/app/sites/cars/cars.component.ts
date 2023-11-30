import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CarPreview } from 'src/app/models/car-preview';
import { ImageCar } from 'src/app/models/image-car';
import { CarService } from 'src/app/services/car.service';

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.scss']
})
export class CarsComponent implements OnInit{
  cars: CarPreview[] = [];

  constructor(private carService:CarService, private router: Router){

  }

  ngOnInit(): void {
    this.carService.getCarsListRequest().subscribe((response: any ) => {
      console.log(response);
      this.cars = response;
      this.cars.forEach(car => {
        if(car.imageCarList.length === 0){
          const imageCar: ImageCar = {filePath: '../assets/default.jpg', fileName: 'default'};
          car.imageCarList.push(imageCar);
        }
      })
    });
  }

  navigateToDetails(car: any) {
    this.router.navigate([`/cars/${car.name.replace(/ /g, '-')}`], { state: { carId: car.id}});
  }

  convertPath(path:string): string{
    const parts = path.split('\\');
    const assetsIndex = parts.indexOf('assets');
    return ['..'].concat(parts.slice(assetsIndex)).join('\\');
  }
}
