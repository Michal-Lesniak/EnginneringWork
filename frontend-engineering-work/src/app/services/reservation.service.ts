import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { Reservation } from '../models/reservation';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  apiurl = 'http://localhost:8080/api/v1';

  constructor(private http:HttpClient, private authService:AuthService) { }

  getReservationsRequest(){
    return this.http.get(this.apiurl + '/reservations', {headers: new HttpHeaders({
      'Authorization' : "Bearer " + this.authService.access_token,
    })});
  }

  addReservationRequest(newReservation: Reservation) {
    return this.http.post(this.apiurl + '/reservations', newReservation, {headers: new HttpHeaders({
      'Authorization' : "Bearer " + this.authService.access_token,
    })})
  }

  editReservationRequest(editedReservation: Reservation){
    return this.http.put(this.apiurl + `/reservations/${editedReservation!.id}`, editedReservation, {headers: new HttpHeaders({
      'Authorization' : "Bearer " + this.authService.access_token,
    })})
  }

  deleteReservationRequest(id: number) {
    return this.http.delete(this.apiurl + `/reservations/${id}`, { headers: new HttpHeaders({
      'Authorization': 'Bearer ' + this.authService.access_token,
    })})}

  getReservationByUserEmailRequest(){
    return this.http.post(this.apiurl + "/reservations/getByEmail", this.authService.user?.email, { headers: new HttpHeaders({
      'Authorization': 'Bearer ' + this.authService.access_token,
    })});
  }
}
