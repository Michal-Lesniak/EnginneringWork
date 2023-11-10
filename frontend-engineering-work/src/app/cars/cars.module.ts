import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CarsComponent } from './cars/cars.component';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', component: CarsComponent }
];


@NgModule({
  declarations: [
    CarsComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    MatCardModule,
    MatButtonModule
  ]
})
export class CarsModule { }
