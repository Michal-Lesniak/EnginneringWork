import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';;
import { City } from 'src/app/models/city';

@Component({
  selector: 'app-car-reservation',
  templateUrl: './car-reservation.component.html',
  styleUrls: ['./car-reservation.component.scss']
})
export class CarReservationComponent implements OnInit {
  @Input() blockedDates!: Date[];
  @Input() costPerDay!: number;
  @Input() cities!:City[];
  @Output() submitEvent = new EventEmitter<any>();
  rentForm: FormGroup;

  constructor(private fb: FormBuilder,){
    this.rentForm = this.fb.group({
      dateRange: this.fb.group({
        rentDate: [null, Validators.required],
        arrivalDate: [null, Validators.required]
      }),
      rentCityId: ['', Validators.required],
      arrivalCityId: ['', Validators.required]
    });
  }

  submitForm(){
    if(this.rentForm.valid){
      this.submitEvent.emit(this.rentForm.value);
      this.rentForm.reset();
    }
  }

  get daysOfRent(){
    const start = this.rentForm.value.dateRange.rentDate;
    const end = this.rentForm.value.dateRange.arrivalDate;
    if (!start || !end) {
      return 0;
    }
    return this.amountOfDaysBetween(start, end);
  }

  ngOnInit(): void {
    console.log(this.blockedDates)
  }

  myFilter = (): boolean => {
    const day = new Date();

    return !this.blockedDates.some(blockedDate =>
        blockedDate.getDate() === day.getDate() &&
        blockedDate.getMonth() === day.getMonth() &&
        blockedDate.getFullYear() === day.getFullYear())
  }


  private amountOfDaysBetween(start: Date, end: Date): number{
    const MILISECUND_PER_DAY = 1000 * 60 * 60 * 24;
    const difference = end.getTime() - start.getTime();
    return Math.floor(difference / MILISECUND_PER_DAY);
  }


}
