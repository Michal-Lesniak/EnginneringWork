import { Component } from '@angular/core';
import { Car } from 'src/app/models/car';
import { City } from 'src/app/models/city';
import { Reservation } from 'src/app/models/reservation';
import { User } from 'src/app/models/user';
import { CarService } from 'src/app/services/car.service';
import { CityService } from 'src/app/services/city.service';
import { ReservationService } from 'src/app/services/reservation.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent {
  selectedComponent: string = 'car'; // domyślny wyświetlany komponent
  users!: User[];
  reservations!: Reservation[];
  cars!: Car[];
  cities!: City[];

  constructor(private userService:UserService,
          private carService:CarService,
          private reservationService:ReservationService,
          private cityService:CityService) {
    this.getUsers();
    this.getCars();
    this.getCities();
    this.getAllReservations();
  }

  getUsers(){
    this.userService.getUsersRequest().subscribe((response:any) => {
      this.users = response;
    })
  }

  getAllReservations(){
    this.reservationService.getReservationsRequest().subscribe((response: any) => {
    this.reservations = response;
    })
  }

  getCars(){
    this.carService.getCarsRequest().subscribe((response:any) => {
      this.cars = response;
    });
  }

  getCities(){
    this.cityService.getAllCitiesRequest().subscribe((response:any) => {
      this.cities = response;
    })
  }
  selectComponent(component: string) {
    this.selectedComponent = component;
  }
}
