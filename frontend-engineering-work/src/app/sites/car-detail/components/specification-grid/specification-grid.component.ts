import { Component, Input } from '@angular/core';
import { CarDetailComponent } from '../../car-detail.component';
import { CarDetailView } from 'src/app/models/car-detail-view';

@Component({
  selector: 'app-specification-grid',
  templateUrl: './specification-grid.component.html',
  styleUrls: ['./specification-grid.component.scss']
})
export class SpecificationGridComponent {
  @Input() carData!: CarDetailView;
}
