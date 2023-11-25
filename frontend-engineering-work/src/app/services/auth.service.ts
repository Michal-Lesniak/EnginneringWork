import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, tap } from 'rxjs';
import { ApiServiceService } from './api-service.service';
import { UserSecurity } from '../models/user-security';
import { TokenData } from '../models/token-data';




@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private _isLoggedIn$ = new BehaviorSubject<boolean>(false);
  isLoggedIn$ = this._isLoggedIn$.asObservable();
  token_data: TokenData | null;
  user: UserSecurity;

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
    this.token_data = this.getDataFromToken(this.access_token);
    this.user = { email: this.token_data!.sub, roles: []};//sciagnac calego usera z zapytania
    this.getRoles();
    console.log(this.user);
    console.log("1");
  }

  getRolesRequest(user: UserSecurity | null){
    return this.http.post("http://localhost:8080/api/v1/users/getRoles", user!.email);
  }

  getRoles(){
    this.getRolesRequest(this.user).subscribe((response : any ) => {
      this.user.roles = response;
      console.log(this.user.roles);
      console.log("2");
    })
    console.log(this.user);
    console.log("3");
  }

  login(loginData: any){
    return this.apiService.loginUser(loginData).pipe(tap((response: any) => {
      this._isLoggedIn$.next(true);
      this.getRoles();
      localStorage.setItem(this.ACCESS_TOKEN_NAME, response.access_token);
      localStorage.setItem(this.REFRESH_TOKEN_NAME, response.refresh_token);
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
      localStorage.removeItem(this.ACCESS_TOKEN_NAME);
      localStorage.removeItem(this.REFRESH_TOKEN_NAME);
    }))
  }

  private getDataFromToken(token: string): TokenData | null {
    if (!token) {
      return null
    }
    return JSON.parse(atob(token.split('.')[1])) as TokenData;
  }

}
