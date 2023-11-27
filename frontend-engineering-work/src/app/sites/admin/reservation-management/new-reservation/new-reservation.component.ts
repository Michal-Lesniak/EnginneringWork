import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-new-reservation',
  templateUrl: './new-reservation.component.html',
  styleUrls: ['./new-reservation.component.scss']
})
export class NewReservationComponent {
  rentForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.rentForm = this.fb.group({
      id: [null, Validators.required],
      carId: [null, Validators.required],
      rentDate: [null, Validators.required],
      arrivalDate: [null, Validators.required],
      userId: [null, Validators.required],
      rentCity: ['', Validators.required],
      arrivalCity: ['', Validators.required]
    });
  }

  submitForm() {
    if (this.rentForm.valid) {
      console.log('Form Data:', this.rentForm.value);
      // Tutaj możesz dodać logikę wysyłania danych formularza
    } else {
      console.log('Form is not valid!');
    }
  }
}
