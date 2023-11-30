import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { RequestImageCar } from '../models/request-image-car';

@Injectable({
  providedIn: 'root'
})
export class ImageCarServiceService {

  apiurl = 'http://localhost:8080/api/v1';

  constructor(private authService:AuthService, private http: HttpClient) { }

  uploadImageRequest(imageForm:any){
    return this.http.post(this.apiurl + '/images/upload', imageForm, { headers: new HttpHeaders({
      'Authorization': 'Bearer ' + this.authService.access_token,
    })} )
  }
}
