import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  constructor(private builder: FormBuilder, private router: Router,
    private toastr: ToastrService, private loginService:LoginService) {

  }

  registerform = this.builder.group({
    firstname: ['', [Validators.required, Validators.minLength(5)]],
    lastname: ['', Validators.required],
    password: ['', [
      Validators.required,
      Validators.pattern('(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&].{8,}')
    ]],
    email: ['', [Validators.required, Validators.email]],
    borndate: ['', Validators.required],
    mobilePhone: ['', [
      Validators.required,
      Validators.pattern('^\\+?[1-9]\\d{1,14}$')
    ]],
    city: ['', Validators.required],
    postcode: ['', [
      Validators.required,
      Validators.pattern('^\\d+-\\d+$')
    ]],
    address: ['', Validators.required],
    role: "USER"
  });

  proceedregister() {
    if (this.registerform.valid) {
      this.loginService.registerUser(this.registerform.value).subscribe(() => {
        window.location.reload();
        this.toastr.success('Registered successfully')
        this.router.navigate(['login']).then(() => {
          window.location.reload();
        });
      });
    } else {
      this.toastr.warning('Please enter valid data.')
    }
  }

}
