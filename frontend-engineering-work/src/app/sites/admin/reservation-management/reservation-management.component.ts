import { Component, EventEmitter, Input, Output } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { NewReservationComponent } from './new-reservation/new-reservation.component';
import { Reservation } from 'src/app/models/reservation';
import { ReservationService } from 'src/app/services/reservation.service';
import { CarService } from 'src/app/services/car.service';
import { UserService } from 'src/app/services/user.service';
import { CityService } from 'src/app/services/city.service';
import { Car } from 'src/app/models/car';
import { User } from 'src/app/models/user';
import { City } from 'src/app/models/city';;


@Component({
  selector: 'app-reservation-management',
  templateUrl: './reservation-management.component.html',
  styleUrls: ['./reservation-management.component.scss']
})
export class ReservationManagementComponent {
  displayedColumns: string[] = ['user', 'car', 'rentDate', 'arrivalDate', 'rentCity', 'arrivalCity', 'actions'];
  @Input() reservations!: Reservation[];
  @Output() reservationsChange = new EventEmitter<Reservation[]>();
  @Input() cars!: Car[];
  @Input() users!: User[];
  @Input() cities!: City[]

  constructor(private dialog: MatDialog,
     private reservationService:ReservationService) { }


  deleteReservation(reservation:Reservation) {
    this.reservationService.deleteReservationRequest(reservation.id!).subscribe(() =>
    this.reservations = this.reservations.filter(obj => obj !== reservation
    ))
  }

  public openDialog(reservation: Reservation | null): void {
    const newReservationRef = this.dialog.open(NewReservationComponent, {
      data: {
        reservations: this.reservations,
        reservation: reservation,
        cities: this.cities,
        cars: this.cars,
        users: this.users
       },
      backdropClass: 'backdropDialog',
    });

    newReservationRef.afterClosed().subscribe(reservations => {
      this.reservations = [...reservations];
      this.reservationsChange.emit(this.reservations);
    });
  }

  editReservationAction(reservation: Reservation) {
    this.openDialog(reservation);
  }

  getUserNameById(id:number): string {
    const user = this.users.find(user => user.id === id);
    return user?.person.name + " " + user?.person.surname;
  }

  getCarNameById(id:number): string {
    const car = this.cars.find(car => car.id === id);
    return car?.brand + " " + car?.model.name;
  }

  getCityNameById(id:number): string {
    const city = this.cities.find(city => city.id === id);
    return city!.name;
  }
}
