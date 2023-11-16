import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, tap } from 'rxjs';
import { ApiServiceService } from './api-service.service';




@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private _isLoggedIn$ = new BehaviorSubject<boolean>(false);
  isLoggedIn$ = this._isLoggedIn$.asObservable();
  private readonly ACCESS_TOKEN_NAME = 'access_token';
  private readonly REFRESH_TOKEN_NAME = 'refresh_token';

  get access_token():any {
    return localStorage.getItem(this.ACCESS_TOKEN_NAME);
  }

  get refresh_token():any {
    return localStorage.getItem(this.REFRESH_TOKEN_NAME);  
  }

  constructor(private apiService:ApiServiceService) {
    const access_token = localStorage.getItem(this.ACCESS_TOKEN_NAME);
    const refresh_token = localStorage.getItem(this.REFRESH_TOKEN_NAME);
    this._isLoggedIn$.next(!!access_token);

  }

  login(loginData: any){
    return this.apiService.LoginUser(loginData).pipe(tap((response: any) => {
      this._isLoggedIn$.next(true);
      sessionStorage.setItem("access_token", response.access_token);
      sessionStorage.setItem("refresh_token", response.refresh_token);
    } ));
  }

}
