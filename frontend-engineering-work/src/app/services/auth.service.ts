import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, tap } from 'rxjs';
import { ApiServiceService } from './api-service.service';
import { accessSync } from 'fs';
import { UserSecurity } from '../models/user-security';




@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private _isLoggedIn$ = new BehaviorSubject<boolean>(false);
  isLoggedIn$ = this._isLoggedIn$.asObservable();
  user: UserSecurity | null;

  private readonly ACCESS_TOKEN_NAME = 'access_token';
  private readonly REFRESH_TOKEN_NAME = 'refresh_token';

  get access_token():any {
    return localStorage.getItem(this.ACCESS_TOKEN_NAME);
  }

  get refresh_token():any {
    return localStorage.getItem(this.REFRESH_TOKEN_NAME);
  }

  constructor(private apiService:ApiServiceService, private http:HttpClient) {
    this._isLoggedIn$.next(!!this.access_token);
    this.user = this.getUser(this.access_token);
  }

  hasRole(role: string): boolean {
    return this.user?.roles.includes(role) ?? false;
  }


  login(loginData: any){
    return this.apiService.loginUser(loginData).pipe(tap((response: any) => {
      this._isLoggedIn$.next(true);
      localStorage.setItem(this.ACCESS_TOKEN_NAME, response.access_token);
      localStorage.setItem(this.REFRESH_TOKEN_NAME, response.refresh_token);
    } ));
  }

  logoutUser(){
    return this.http.post("http://localhost:8080/api/v1/auth/logout", null, { headers: new HttpHeaders({
      'Authorization': 'Bearer ' + this.access_token,
    })});
  }

  private getUser(token: string): UserSecurity | null {
    if (!token) {
      return null
    }
    return JSON.parse(atob(token.split('.')[1])) as UserSecurity;
  }

}
