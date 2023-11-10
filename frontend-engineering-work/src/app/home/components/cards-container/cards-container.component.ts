import { Component } from '@angular/core';

interface Car {
  title: string;
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
  cars: Car[] = [
    { title: 'Car 1', imageUrl: '../assets/911.jpeg', maxSpeed: 220, pricePerDay: 100 },
    { title: 'Car 2', imageUrl: '../assets/BMW-M3-Competition-8-600x338.jpg', maxSpeed: 240, pricePerDay: 150 },
    { title: 'Car 3', imageUrl: '../assets/bmw-m5.jpeg', maxSpeed: 280, pricePerDay: 2000 },
    { title: 'Car 4', imageUrl: '../assets/ferrari.jpg', maxSpeed: 340, pricePerDay: 2500 },
    { title: 'Car 5', imageUrl: '../assets/merc-G-classa.jpeg', maxSpeed: 180, pricePerDay: 500 },
    { title: 'Car 6', imageUrl: '../assets/LAMBORGHINI-URUS-8-1-600x338.jpeg', maxSpeed: 275, pricePerDay: 1500 },
    { title: 'Car 7', imageUrl: '../assets/porsche-taycan.jpeg', maxSpeed: 310, pricePerDay: 1900 },
    { title: 'Car 8', imageUrl: '../assets/rsq7.jpg', maxSpeed: 240, pricePerDay: 1150 },
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
}
