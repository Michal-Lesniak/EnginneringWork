import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { City } from '../models/city';

@Injectable({
  providedIn: 'root'
})
export class CityService {

  apiurl = 'http://localhost:8080/api/v1';

  constructor(private authService:AuthService, private http: HttpClient) {}

  deleteCityRequest(id:number) {
    this.http.delete(this.apiurl + "/cities/{id}", { headers: new HttpHeaders({
      'Authorization': 'Bearer ' + this.authService.access_token,
    })} )
  }

  addCityRequest(city:City) {
    this.http.post(this.apiurl + "/cities", city, { headers: new HttpHeaders({
      'Authorization': 'Bearer ' + this.authService.access_token,
    })})}
}
