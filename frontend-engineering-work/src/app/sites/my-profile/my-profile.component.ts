
import { Component, OnInit } from '@angular/core';
import { Reservation } from 'src/app/models/Reservation';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.scss']
})
export class MyProfileComponent implements OnInit{

  reservation: Reservation[] = [];
  user: User | null= null;
  isEditMode: boolean = false;

  constructor(private authService: AuthService){

  }

  ngOnInit(): void {
    this.authService.getUserProfileData().subscribe((response:any) => {
      this.user = response;
    });
    this.authService.getReservationByUserEmail().subscribe((response:any) => {
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
