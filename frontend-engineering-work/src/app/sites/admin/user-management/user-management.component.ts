import { Component } from '@angular/core';

@Component({
  selector: 'app-user-management',
  templateUrl: './user-management.component.html',
  styleUrls: ['./user-management.component.scss']
})
export class UserManagementComponent {
deleteUser(_t100: any) {
throw new Error('Method not implemented.');
}
  displayedColumns: string[] = [ 'email', 'mobilePhone', 'name', 'surname', 'bornDate', 'city', 'postCode', 'address', 'actions'];
  dataSource = ELEMENT_DATA;
}

const ELEMENT_DATA: any[] = [
  { id: 1, email: 'example@example.com', mobilePhone: '123-456-7890', name: 'Jan', surname: 'Kowalski', bornDate: new Date(1990, 0, 1), city: 'Warszawa', postCode: '00-001', address: 'Ulica 1' },
  // ... więcej danych
];
