import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Car } from 'src/app/models/car';
import { City } from 'src/app/models/city';
import { Reservation } from 'src/app/models/reservation';
import { User } from 'src/app/models/user';
import { CarService } from 'src/app/services/car.service';
import { CityService } from 'src/app/services/city.service';
import { ReservationService } from 'src/app/services/reservation.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-new-reservation',
  templateUrl: './new-reservation.component.html',
  styleUrls: ['./new-reservation.component.scss']
})
export class NewReservationComponent implements OnInit{
  rentForm: FormGroup;

  constructor(
    public dialogRef: MatDialogRef<NewReservationComponent>,
    @Inject(MAT_DIALOG_DATA) public data: {
      reservations: Reservation[],
      reservation: Reservation | null,
      cars: Car[],
      users: User[],
      cities: City[],
    },
    private fb: FormBuilder,
    private reservationService:ReservationService,
    private userService: UserService,
    private carService: CarService,
    private cityService: CityService) {
    this.rentForm = this.fb.group({
      id: [null],
      carId: [null, Validators.required],
      rentDate: [null, Validators.required],
      arrivalDate: [null, Validators.required],
      userId: [null, Validators.required],
      rentCityId: ['', Validators.required],
      arrivalCityId: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    if(this.data.reservation){
      this.rentForm.patchValue(this.data.reservation);
    }
  }


  submitForm() {
    if (this.rentForm.valid) {
      const reservation: Reservation = {
        ...this.rentForm.value
      };
      if(this.data.reservation != null){
        this.editReservation(reservation);
      }else{
        this.addNewReservation(reservation);
      }
      this.rentForm.reset();
    }
  }

  addNewReservation(newReservation:Reservation) {
    this.reservationService.addReservationRequest(newReservation).subscribe((response:any) => {
      const reservation = response;
      this.data.reservations = [...this.data.reservations, reservation];
      this.dialogRef.close(this.data.reservations);
    })
  }

  editReservation(editedReservation:Reservation){
    this.reservationService.editReservationRequest(editedReservation).subscribe((response:any) => {
      const reservation = response;
      this.data.reservations = [ ...this.data.reservations.filter(obj => obj.id !== editedReservation.id), reservation];
      this.dialogRef.close(this.data.reservations);
    })
  }
}
