import { Component, OnInit } from '@angular/core';
import { CardsContainerComponent } from 'src/app/components/cards-container/cards-container.component';

interface Car {
  brand: string;
  model: string;
  description: string;
  image: string;
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  constructor() { }

  ngOnInit(): void {
  }
}
