import { Component, OnInit } from '@angular/core';
import { AuthService } from './services/auth.service';
import { ApiServiceService } from './services/api-service.service';
import {  Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{

  isAdmin: boolean = false;
  isLogged: boolean = false;

  constructor(private authService:AuthService, private apiService:ApiServiceService, private router:Router){}

  title = 'MajkiRent';

  ngOnInit(): void {
    this.authService.isLoggedIn$.subscribe(val => this.isLogged = val);
  }

  logout(){
    this.authService.logoutUser().subscribe(() => {
      this.router.navigate(['home']);
    });
  }

}
