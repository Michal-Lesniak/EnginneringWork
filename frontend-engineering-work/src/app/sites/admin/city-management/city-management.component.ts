import { Component, OnInit } from '@angular/core';
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
  cities: City[] = [];
  cityForm!: FormGroup;

  constructor(private cityService:CityService, private formBuilder:FormBuilder){}

  ngOnInit(): void {
    this.cityForm = this.formBuilder.group({
      name: ['', Validators.required],
    })
    this.getAllCities();
  }

  getAllCities(){
    this.cityService.getAllCitiesRequest().subscribe((response: any) => {
      this.cities = response;
    })
  }

  deleteCity(city: City) {
    this.cityService.deleteCityRequest(city.id!).subscribe(() =>
      this.cities = this.cities.filter(val => val !== city
      ))
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
    })
  }
}
