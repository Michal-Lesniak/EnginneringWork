import { MatInputModule } from '@angular/material/input';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatRadioModule } from '@angular/material/radio';
import { MatIconModule } from '@angular/material/icon';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ToastrModule } from 'ngx-toastr';
import { MatButtonModule } from '@angular/material/button';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CardsContainerComponent } from './components/cards-container/cards-container.component';
import { MatCardModule } from '@angular/material/card';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './sites/login/login.component';
import { RegisterComponent } from './sites/register/register.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './sites/home/home.component';
import { AdminComponent } from './sites/admin/admin.component';
import { CarsComponent } from './sites/cars/cars.component';
import { ContactComponent } from './sites/contact/contact.component';
import { SocialMediaComponent } from './components/social-media/social-media.component';
import { WhyWeSectionComponent } from './components/why-we-section/why-we-section.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatNativeDateModule } from '@angular/material/core';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MyProfileComponent } from './sites/my-profile/my-profile.component';
import { HasRoleDirective } from './security/has-role.directive';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CarDetailComponent } from './sites/car-detail/car-detail.component';
import { CarManagementComponent } from './sites/admin/car-management/car-management.component';
import { ReservationManagementComponent } from './sites/admin/reservation-management/reservation-management.component';
import { CityManagementComponent } from './sites/admin/city-management/city-management.component';
import { UserManagementComponent } from './sites/admin/user-management/user-management.component';
import {MatListModule} from '@angular/material/list';
import {MatTableModule} from '@angular/material/table';
import {MatDialogModule} from '@angular/material/dialog';
import { DialogComponent } from './components/dialog/dialog.component';
import {MatSelectModule} from '@angular/material/select';
import { NewReservationComponent } from './sites/admin/reservation-management/new-reservation/new-reservation.component';
import { SpecificationGridComponent } from './sites/car-detail/components/specification-grid/specification-grid.component';
import {MatGridListModule} from '@angular/material/grid-list';
import { CarReservationComponent } from './sites/car-detail/components/car-reservation/car-reservation.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    AdminComponent,
    CarsComponent,
    ContactComponent,
    CardsContainerComponent,
    SocialMediaComponent,
    WhyWeSectionComponent,
    MyProfileComponent,
    HasRoleDirective,
    NavbarComponent,
    CarDetailComponent,
    CarManagementComponent,
    ReservationManagementComponent,
    CityManagementComponent,
    UserManagementComponent,
    DialogComponent,
    NewReservationComponent,
    SpecificationGridComponent,
    CarReservationComponent,
  ],
  imports: [
    ToastrModule.forRoot(),
    BrowserModule,
    HttpClientModule,
    MatToolbarModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatIconModule,
    MatCardModule,
    FormsModule,
    ReactiveFormsModule,
    MatRadioModule,
    MatInputModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatDatepickerModule,
    MatListModule,
    MatTableModule,
    MatDialogModule,
    MatSelectModule,
    MatGridListModule  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule { }
