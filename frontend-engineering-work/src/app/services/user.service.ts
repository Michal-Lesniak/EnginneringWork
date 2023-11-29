import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { UserProfile } from '../models/user-profile';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  apiurl = 'http://localhost:8080/api/v1';

  constructor(private http:HttpClient, private authService:AuthService) {}

  getUserProfileDataRequest(){
    return this.http.post(this.apiurl + "/users/getByEmail", this.authService.user?.email, { headers: new HttpHeaders({
      'Authorization':'Bearer ' + this.authService.access_token,
    })});
  }

  editUserProfileRequest(user:UserProfile){
    return this.http.put(this.apiurl + `/users/${user.id}`, user, { headers: new HttpHeaders({
      'Authorization':'Bearer ' + this.authService.access_token,
    })})
  }

  getUsersRequest(){
    return this.http.get(this.apiurl + "/users", { headers: new HttpHeaders({
      'Authorization':'Bearer ' + this.authService.access_token,
    })})
  }

  deleteUserRequest(id: number){
    return this.http.delete(this.apiurl + `/users/${id}`, { headers: new HttpHeaders({
      'Authorization':'Bearer ' + this.authService.access_token,
    })})
  }

}
