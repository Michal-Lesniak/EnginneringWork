import { Component, EventEmitter, Input, Output } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user-management',
  templateUrl: './user-management.component.html',
  styleUrls: ['./user-management.component.scss']
})
export class UserManagementComponent {
  @Input() users!:User[];
  @Output() usersChange = new EventEmitter<User[]>();

  displayedColumns: string[] = [ 'email', 'mobilePhone', 'name', 'surname', 'bornDate', 'city', 'postCode', 'address', 'actions'];

  constructor(private userService:UserService){}

  deleteUser(user: User) {
    this.userService.deleteUserRequest(user.id!).subscribe(() => {
      this.users = this.users.filter(obj => obj !== user);
      this.usersChange.emit(this.users);
    })
  }
}
