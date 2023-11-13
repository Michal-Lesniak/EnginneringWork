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
import { AboutComponent } from './sites/about/about.component';
import { LoginComponent } from './sites/login/login.component';
import { RegisterComponent } from './sites/register/register.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './sites/home/home.component';
import { AdminComponent } from './sites/admin/admin.component';
import { CarsComponent } from './sites/cars/cars.component';
import { ContactComponent } from './sites/contact/contact.component';
import { SocialMediaComponent } from './components/social-media/social-media.component';
import { WhyWeSectionComponent } from './components/why-we-section/why-we-section.component';



@NgModule({
  declarations: [
    AppComponent,
    AboutComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    AdminComponent,
    CarsComponent,
    ContactComponent,
    CardsContainerComponent,
    SocialMediaComponent,
    WhyWeSectionComponent
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
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule { }
