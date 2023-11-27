import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, tap } from 'rxjs';
import { UserSecurity } from '../models/user-security';
import { TokenData } from '../models/token-data';
import { LoginService } from './login.service';




@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private _isLoggedIn$ = new BehaviorSubject<boolean>(false);
  // private _accessToken$ = new BehaviorSubject<string>("");
  // private _userEmail$ = new BehaviorSubject<string>("");
  isLoggedIn$ = this._isLoggedIn$.asObservable();
  // accessToken$ = this._accessToken$.asObservable();
  // userEmail$ = this._userEmail$.asObservable();
  user: UserSecurity | null;

  private readonly ACCESS_TOKEN_NAME = 'access_token';
  private readonly REFRESH_TOKEN_NAME = 'refresh_token';

  get access_token():any {
    return localStorage.getItem(this.ACCESS_TOKEN_NAME);
  }

  get refresh_token():any {
    return localStorage.getItem(this.REFRESH_TOKEN_NAME);
  }

  constructor(private loginService:LoginService, private http:HttpClient) {
    this._isLoggedIn$.next(!!this.access_token);
    // this._accessToken$.next(this.access_token);
    this.user = this.getUser(this.access_token);
    // this._userEmail$.next(this.user!.email);
  }

  hasRole(role: string): boolean {
    return this.user?.roles.includes(role) || false;
  }

  login(loginData: any){
    return this.loginService.loginUser(loginData).pipe(tap((response: any) => {
      this._isLoggedIn$.next(true);
      // this._accessToken$.next(this.access_token);
      localStorage.setItem(this.ACCESS_TOKEN_NAME, response.access_token);
      localStorage.setItem(this.REFRESH_TOKEN_NAME, response.refresh_token);
      this.user = this.getUser(this.access_token);
      // this._userEmail$.next(this.user!.email);
    } ));
  }

  logout(){
    return this.http.post("http://localhost:8080/api/v1/auth/logout", null, { headers: new HttpHeaders({
      'Authorization': 'Bearer ' + this.access_token,
    })});
  }

  logoutUser(){
    return this.logout().pipe(tap((response: any) => {
      this._isLoggedIn$.next(false);
      // this._accessToken$.next("");
      localStorage.removeItem(this.ACCESS_TOKEN_NAME);
      localStorage.removeItem(this.REFRESH_TOKEN_NAME);
    }))
  }

  private getUser(token: string): UserSecurity | null {
    if (!token) {
      return null
    }
    const token_data = JSON.parse(atob(token.split('.')[1])) as TokenData;
    return { email: token_data.sub, roles: token_data.roles }
  }
}
