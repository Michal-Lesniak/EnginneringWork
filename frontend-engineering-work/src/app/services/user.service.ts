import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  apiurl = 'http://localhost:8080/api/v1';

  constructor(private http:HttpClient, private authService:AuthService) {}

  getUserProfileData(){
    return this.http.post(this.apiurl + "/users/getByEmail", this.authService.user?.email, { headers: new HttpHeaders({
      'Authorization': 'Bearer ' + this.authService.access_token,
    })});
  }
}
