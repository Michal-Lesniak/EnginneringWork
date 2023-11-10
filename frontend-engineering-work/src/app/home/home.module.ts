import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { Routes } from '@angular/router';
import { RouterModule } from '@angular/router';
import {MatIconModule} from '@angular/material/icon';
import { CardsContainerComponent } from './components/cards-container/cards-container.component';
import { WhyWeSectionComponent } from './components/why-we-section/why-we-section.component';
import { SocialMediaComponent } from './components/social-media/social-media.component';

const routes: Routes = [
  { path: '', component: HomeComponent }
];

@NgModule({
  declarations: [
    HomeComponent,
    CardsContainerComponent,
    WhyWeSectionComponent,
    SocialMediaComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    MatToolbarModule,
    MatGridListModule,
    MatCardModule,
    MatButtonModule,
    MatIconModule,
  ],
})
export class HomeModule { }
