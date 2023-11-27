import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Reservation } from 'src/app/models/Reservation';

@Component({
  selector: 'app-reservation-management',
  templateUrl: './reservation-management.component.html',
  styleUrls: ['./reservation-management.component.scss']
})
export class ReservationManagementComponent {
  reservation: Reservation[] = [];
  selectedItem: Reservation | null = null;
  searchText = '';
  public messageStateError = false;
  public messageStateComplete = false;
  public message = "";

  constructor(private dialog: MatDialog) { }

  ngOnInit() {
  }

  // applyFilter(event: Event) {
  //   const filterValue = (event.target as HTMLInputElement).value;
  //   this.parts = this.parts.filter(el => {
  //     return el.name.toLowerCase().includes(filterValue);
  //   });
  // }

  deletePart(reservation: Reservation) {
    // this.connection.deletePart(part.partCode).subscribe((res) => {
    //   if (res) {
    //     this.handleMessage(false, "Pomyślnie Usunięto!");
    //     this.getParts();
    //     this.selectedItem = null;
    //   }
    // }, () => this.handleMessage(true, "Wystąpił błąd w trakcie usuwania!"))
  };

  getReservation() {
    console.log('N')
  }

  public openDialog(): void {
    // const newPartRef = this.dialog.open(NewPartComponent, {
    //   backdropClass: 'backdropDialog',
    // });

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
