import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/user';



@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http:HttpClient) {

  }
  apiurl='http://localhost:8080/api/v1/security';

  RegisterUser(newUserData: any){
    return this.http.post(this.apiurl + "/register" , newUserData )
  }

  LoginUser(loginData: any){
    return this.http.post(this.apiurl+'/login', loginData);
  }
}
