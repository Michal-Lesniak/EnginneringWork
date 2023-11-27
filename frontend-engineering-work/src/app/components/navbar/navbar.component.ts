import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
  isLogged: boolean = false;

  constructor(public authService:AuthService, private router:Router){}

  title = 'MajkiRent';

  ngOnInit(): void {
    this.authService.isLoggedIn$.subscribe(val => this.isLogged = val);
  }

  logout(){
    this.authService.logoutUser().subscribe(() => {
      this.router.navigate(['home']).then(() => {
        window.location.reload();
      });
    });
  }

}
