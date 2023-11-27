import { Component } from '@angular/core';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent {
  selectedComponent: string = 'car'; // domyślny wyświetlany komponent

  constructor() {}

  selectComponent(component: string) {
    this.selectedComponent = component;
  }
}
