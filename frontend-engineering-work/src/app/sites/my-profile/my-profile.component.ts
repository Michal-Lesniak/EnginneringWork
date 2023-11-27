
import { Component, OnInit } from '@angular/core';
import { Reservation } from 'src/app/models/reservation';
import { User } from 'src/app/models/user';
import { ReservationService } from 'src/app/services/reservation.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.scss']
})

export class MyProfileComponent implements OnInit{

  reservation: Reservation[] = [];
  user: User | null= null;
  isEditMode: boolean = false;

  constructor(private userService: UserService, private reservationService: ReservationService){}

  ngOnInit(): void {
    this.userService.getUserProfileData().subscribe((response:any) => {
      this.user = response;
    });
    this.reservationService.getReservationByUserEmail().subscribe((response:any) => {
      this.reservation = response;
    });
  }

  cancelEdit() {
    // implement functionality
      this.isEditMode = false;
  }
  saveProfile() {
    // implement functionality
    this.isEditMode = false;
  }

  editProfile() {
    // implement functionality
    this.isEditMode = true;
  }

  changePassword() {
    throw new Error('Method not implemented.');
  }
}
