
import { Component, OnInit } from '@angular/core';
import { UserProfile } from 'src/app/models/user-profile';
import { ReservationService } from 'src/app/services/reservation.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.scss']
})

export class MyProfileComponent implements OnInit{

  userProfile!: UserProfile;
  editedUserProfile!: UserProfile;
  isEditMode: boolean = false;

  constructor(private userService: UserService, private reservationService: ReservationService){}

  ngOnInit(): void {
    this.userService.getUserProfileDataRequest().subscribe((response:any) => {
      this.userProfile = response;
    });
  }

  cancelEdit() {
      this.isEditMode = false;
  }
  saveProfile() {
    this.userService.editUserProfileRequest(this.editedUserProfile).subscribe((response:any) =>{
      console.log(response);
      this.userProfile = response;
      this.isEditMode = false;
    });
  }

  editProfile() {
    this.editedUserProfile = this.userProfile;
    this.isEditMode = true;
  }

  changePassword() {
    throw new Error('Method not implemented.');
  }
}
