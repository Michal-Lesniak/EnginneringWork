import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './sites/login/login.component';
import { RegisterComponent } from './sites/register/register.component';
import { HomeComponent } from './sites/home/home.component';
import { CarsComponent } from './sites/cars/cars.component';
import { ContactComponent } from './sites/contact/contact.component';
import { AdminComponent } from './sites/admin/admin.component';
import { MyProfileComponent } from './sites/my-profile/my-profile.component';
import { AdminGuard } from './security/guards/admin.guard';
import { HasRoleGuard } from './security/guards/has-role.guard';
import { CarDetailComponent } from './sites/car-detail/car-detail.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'cars', component: CarsComponent },
  { path: 'cars/:car_name', component: CarDetailComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'admin', component: AdminComponent, canActivate: [AdminGuard, HasRoleGuard], data: { role: 'ROLE_ADMIN', } },
  { path: 'myAccount', component: MyProfileComponent, canActivate: [AdminGuard, HasRoleGuard], data: { role: 'ROLE_USER', } },
];


@NgModule({
  imports: [
    RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
