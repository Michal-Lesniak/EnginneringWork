import { Component } from '@angular/core';
import { Router } from '@angular/router';

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

export class CardsContainerComponent {

  constructor(private router:Router){}

  cars: any[] = [
    { id: 3, name: 'Car 1', imageUrl: '../assets/911.jpeg', maxSpeed: 220, pricePerDay: 100 },
    { name: 'Car 2', imageUrl: '../assets/BMW-M3-Competition-8-600x338.jpg', maxSpeed: 240, pricePerDay: 150 },
    { name: 'Car 3', imageUrl: '../assets/bmw-m5.jpeg', maxSpeed: 280, pricePerDay: 2000 },
    { name: 'Car 4', imageUrl: '../assets/ferrari.jpg', maxSpeed: 340, pricePerDay: 2500 },
    { name: 'Car 5', imageUrl: '../assets/merc-G-classa.jpeg', maxSpeed: 180, pricePerDay: 500 },
    { name: 'Car 6', imageUrl: '../assets/LAMBORGHINI-URUS-8-1-600x338.jpeg', maxSpeed: 275, pricePerDay: 1500 },
    { name: 'Car 7', imageUrl: '../assets/porsche-taycan.jpeg', maxSpeed: 310, pricePerDay: 1900 },
    { name: 'Car 8', imageUrl: '../assets/rsq7.jpg', maxSpeed: 240, pricePerDay: 1150 },
  ];

  // The index of the first visible card
  firstCardIndex = 0;

  showNext() {
    // Increase index to show next set of cards
    if (this.firstCardIndex < this.cars.length - 4) {
      this.firstCardIndex++;
    }
  }

  showPrev() {
    // Decrease index to show previous set of cards
    if (this.firstCardIndex > 0) {
      this.firstCardIndex--;
    }
  }

  navigateToDetails(car: any) {
    this.router.navigate([`cars/${car.name.replace(/ /g, '-')}`], {state: { carId: car.id}});
  }
}
