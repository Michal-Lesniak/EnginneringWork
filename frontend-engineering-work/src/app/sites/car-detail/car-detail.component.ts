import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CarDetailView } from 'src/app/models/car-detail-view';
import { City } from 'src/app/models/city';
import { Reservation } from 'src/app/models/reservation';
import { AuthService } from 'src/app/services/auth.service';
import { CarService } from 'src/app/services/car.service';
import { CityService } from 'src/app/services/city.service';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-car-detail',
  templateUrl: './car-detail.component.html',
  styleUrls: ['./car-detail.component.scss']
})
export class CarDetailComponent implements OnInit{

  isLogged!: boolean;
  carId: number;
  carData!:CarDetailView;
  cities!: City[];
  userId!: number;

  constructor(private authService:AuthService,
    private carService:CarService,
    private router:Router,
    private cityService:CityService,
    private reservationService: ReservationService){
    this.authService.isLoggedIn$.subscribe(val => this.isLogged = val);
    this.carId = (this.router.getCurrentNavigation()!.extras.state!['carId']);
    this.userId = authService.user_id;
  }

  ngOnInit(): void {
    this.carService.getCarDetailsRequest(this.carId).subscribe((response:any) => {
      this.carData = response;
      this.carData.bookedDays = response.bookedDays.map((dateString:any) => new Date(dateString))
    })
    this.cityService.getAllCitiesRequest().subscribe((response:any) => {
      this.cities = response;
    })
  }

  addReservation(formData: any) {
    const reservation: Reservation = { ...formData, rentDate: formData.dateRange.rentDate, arrivalDate: formData.dateRange.arrivalDate, userId: this.userId, carId: this.carId};
    this.reservationService.addReservationRequest(reservation).subscribe();
  }
}
