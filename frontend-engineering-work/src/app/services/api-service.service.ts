import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class ApiServiceService {

  constructor(private http:HttpClient) { }

  apiurl='http://localhost:8080/api/v1';
  securityapiurl='http://localhost:8080/api/v1/security';

  registerUser(newUserData: any){
    return this.http.post(this.securityapiurl + "/register" , newUserData )
  }

  loginUser(loginData: any){
    return this.http.post(this.securityapiurl+'/login', loginData);
  }

  getCars(){
    return this.http.get(this.apiurl+'/cars');
  }
}
