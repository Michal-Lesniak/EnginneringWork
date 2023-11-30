import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { City } from 'src/app/models/city';
import { CityService } from 'src/app/services/city.service';

@Component({
  selector: 'app-city-management',
  templateUrl: './city-management.component.html',
  styleUrls: ['./city-management.component.scss']
})
export class CityManagementComponent implements OnInit {
  displayedColumns: string[] = ['position', 'city', 'delete'];
  @Input() cities: City[] = [];
  @Output() citiesChange = new EventEmitter<City[]>();
  cityForm!: FormGroup;

  constructor(private cityService:CityService, private formBuilder:FormBuilder){}

  ngOnInit(): void {
    this.cityForm = this.formBuilder.group({
      name: ['', Validators.required],
    })
  }

  deleteCity(city: City) {
    this.cityService.deleteCityRequest(city.id!).subscribe(() =>
      this.cities = this.cities.filter(obj => obj !== city
      ));
      this.citiesChange.emit(this.cities);
  }

  submitForm() {
    if (this.cityForm.valid) {
      const newCar: City = {
        ...this.cityForm.value
      };
      this.addCity(newCar);
      this.cityForm.reset();
    }
  }

  addCity(newCity:City) {
    this.cityService.addCityRequest(newCity).subscribe((response:any) => {
      const city = response;
      this.cities = [...this.cities, city];
      this.citiesChange.emit(this.cities);
    })
  }
}
