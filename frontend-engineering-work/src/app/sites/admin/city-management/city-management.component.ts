import { Component } from '@angular/core';

@Component({
  selector: 'app-city-management',
  templateUrl: './city-management.component.html',
  styleUrls: ['./city-management.component.scss']
})
export class CityManagementComponent {
  displayedColumns: string[] = ['position', 'city', 'delete'];
  cities = [
    { city: 'Warszawa' },
    { city: 'Kraków' },
    // inne miasta
  ];
  newCity: any;

  deleteCity(city: any) {
    // logika usuwania miasta
  }

  addCity() {
    // logika dodawania nowego miasta
  }
}
