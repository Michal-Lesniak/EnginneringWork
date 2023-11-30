import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CarPreview } from 'src/app/models/car-preview';
import { ImageCar } from 'src/app/models/image-car';
import { CarService } from 'src/app/services/car.service';

interface Car {
  name: string;
  imageUrl: string;
  maxSpeed: number;
  pricePerDay: number;
}

@Component({
  selector: 'app-cards-container',
  templateUrl: './cards-container.component.html',
  styleUrls: ['./cards-container.component.scss']
})

export class CardsContainerComponent implements OnInit{
  cars: CarPreview[] = [];
  firstCardIndex = 0;

  constructor(private router:Router, private carService:CarService){}

  ngOnInit(): void {
    this.carService.getCarsListRequest().subscribe((response: any ) => {
      console.log(response);
      this.cars = response.slice(0,8);
      this.cars.forEach(car => {
        if(car.imageCarList.length === 0){
          const imageCar: ImageCar = {filePath: '../assets/default.jpg', fileName: 'default'};
          car.imageCarList.push(imageCar);
        }
      })
    });
  }

  showNext() {
    if (this.firstCardIndex < this.cars.length - 4) {
      this.firstCardIndex++;
    }
  }

  showPrev() {
    if (this.firstCardIndex > 0) {
      this.firstCardIndex--;
    }
  }

  navigateToDetails(car: any) {
    this.router.navigate([`cars/${car.name.replace(/ /g, '-')}`], {state: { carId: car.id}});
  }

  convertPath(path:string): string{
    const parts = path.split('\\');
    const assetsIndex = parts.indexOf('assets');
    return ['..'].concat(parts.slice(assetsIndex)).join('\\');
  }
}
