import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ReservationAdminView } from 'src/app/models/reservation-admin-view';
import { NewReservationComponent } from './new-reservation/new-reservation.component';
import { Reservation } from 'src/app/models/reservation';

@Component({
  selector: 'app-reservation-management',
  templateUrl: './reservation-management.component.html',
  styleUrls: ['./reservation-management.component.scss']
})
export class ReservationManagementComponent {
deleteReservation(arg0: any) {
throw new Error('Method not implemented.');
}
editReservation(arg0: any) {
throw new Error('Method not implemented.');
}
  displayedColumns: string[] = ['car', 'rentDate', 'arrivalDate', 'user', 'rentCity', 'arrivalCity', 'actions'];
  reservations: ReservationAdminView[] = rentalData;
  selectedItem: Reservation | null = null;
  searchText = '';
  public messageStateError = false;
  public messageStateComplete = false;
  public message = "";

  constructor(private dialog: MatDialog) { }

  ngOnInit() {
  }



  getReservation() {
    console.log('N')
  }

  public openDialog(): void {
    const newPartRef = this.dialog.open(NewReservationComponent, {
      backdropClass: 'backdropDialog',
    });

  //   newPartRef.afterClosed().subscribe(result => {
  //     this.getParts()
  //     if(result === true){
  //       this.handleMessage(false, "Urządzenie zostało pomyślnie dodane.")
  //     }else if(result === false){
  //       this.handleMessage(true, "Urządzenie o podanym kodzie już istnieje.")
  //     }

  //   });
  }
}

export const rentalData: ReservationAdminView[] = [
  {
    id: 1,
    carName: 'Toyota Corolla',
    rentDate: new Date('2023-01-01'),
    arrivalDate: new Date('2023-01-05'),
    userName: 'John Doe',
    rentCity: 'New York',
    arrivalCity: 'Washington'
  },
  {
    id: 2,
    carName: 'Honda Civic',
    rentDate: new Date('2023-02-10'),
    arrivalDate: new Date('2023-02-15'),
    userName: 'Jane Smith',
    rentCity: 'Los Angeles',
    arrivalCity: 'San Francisco'
  },
  // ... Additional objects follow the same structure
];
