import { Component, OnInit } from '@angular/core';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{

  isAdmin: boolean = false;
  isLogged: boolean = false;

  constructor(private authService:AuthService){}

  title = 'frontend-engineering-work';

  ngOnInit(): void {
    this.authService.isLoggedIn$.subscribe(val => this.isLogged = val);
  }
}
