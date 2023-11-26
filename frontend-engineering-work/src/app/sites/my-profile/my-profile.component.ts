import { JsonPipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.scss']
})
export class MyProfileComponent implements OnInit{

  rentals: any;
  user: User | null= null;

  constructor(private authService: AuthService){

  }

  ngOnInit(): void {
    this.authService.getUserProfileData().subscribe((response:any) => {
      console.log(response);
      this.user = response;
    });
  }

  editProfile() {
  throw new Error('Method not implemented.');
  }
  changePassword() {
  throw new Error('Method not implemented.');
  }

}
