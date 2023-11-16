import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ApiServiceService {

  constructor(private http:HttpClient) { }

  apiurl='http://localhost:8080/api/v1/security';

  RegisterUser(newUserData: any){
    return this.http.post(this.apiurl + "/register" , newUserData )
  }

  LoginUser(loginData: any){
    return this.http.post(this.apiurl+'/login', loginData);
  }
}
