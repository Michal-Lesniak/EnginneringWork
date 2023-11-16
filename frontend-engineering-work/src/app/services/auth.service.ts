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

  constructor(private apiService:ApiServiceService) {
    const access_token = localStorage.getItem("access_token");
    const refresh_token = localStorage.getItem("refresh_token");
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
