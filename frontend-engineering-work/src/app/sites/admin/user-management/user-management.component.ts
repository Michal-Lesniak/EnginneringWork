import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user-management',
  templateUrl: './user-management.component.html',
  styleUrls: ['./user-management.component.scss']
})
export class UserManagementComponent implements OnInit {

  displayedColumns: string[] = [ 'email', 'mobilePhone', 'name', 'surname', 'bornDate', 'city', 'postCode', 'address', 'actions'];
  users: User[] = [];

  constructor(private userService:UserService){}

  ngOnInit(): void {
    this.userService.getUsersRequest().subscribe((response:any) => {
      this.users = response;
    })
  }

  deleteUser(user: User) {
    this.userService.deleteUserRequest(user.id!).subscribe(() => {
      this.users = this.users.filter(obj => obj !== user);
    })
  }
}
