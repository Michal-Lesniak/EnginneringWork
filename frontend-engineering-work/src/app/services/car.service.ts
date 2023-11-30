import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { Car } from '../models/car';

@Injectable({
  providedIn: 'root'
})
export class CarService {


  apiurl='http://localhost:8080/api/v1';

  constructor(private http:HttpClient, private authService:AuthService) {}

  getCarsRequest(){
    return this.http.get(this.apiurl + '/cars');
  }

  getCarDetailsRequest(id: number ){
    return this.http.get(this.apiurl + `/cars/details/${id}`);
  }

  addCarRequest(newCar: Car) {
    return this.http.post(this.apiurl + '/cars', newCar, {headers: new HttpHeaders({
      'Authorization' : "Bearer " + this.authService.access_token,
    })})
  }

  editCarRequest(editedCar: Car){
    return this.http.put(this.apiurl + `/cars/${editedCar!.id}`, editedCar, {headers: new HttpHeaders({
      'Authorization' : "Bearer " + this.authService.access_token,
    })})
  }

  deleteCarRequest(id: number) {
    return this.http.delete(this.apiurl + `/cars/${id}`, { headers: new HttpHeaders({
      'Authorization': 'Bearer ' + this.authService.access_token,
    })})}
}
