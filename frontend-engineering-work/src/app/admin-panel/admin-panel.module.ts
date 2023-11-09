import { NgModule } from '@angular/core';
import { Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { AdminGuard } from '../guards/admin.guard';
import { RouterModule } from '@angular/router';

const routes: Routes = [
  { path: '', component: AdminComponent, canActivate: [AdminGuard] },
  // ... inne trasy admina
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminPanelModule { }