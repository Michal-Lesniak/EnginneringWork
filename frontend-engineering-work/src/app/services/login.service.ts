import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }

  securityapiurl='http://localhost:8080/api/v1/security';

  registerUser(newUserData: any){
    return this.http.post(this.securityapiurl + "/register" , newUserData )
  }

  loginUser(loginData: any){
    return this.http.post(this.securityapiurl+'/login', loginData);
  }
}
