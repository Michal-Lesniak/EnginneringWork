import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  apiurl='http://localhost:8080/api/v1';

  constructor(private http:HttpClient) {}

  getCarsRequest(){
    return this.http.get(this.apiurl + '/cars');
  }
}
