import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpecificationGridComponent } from './specification-grid.component';

describe('SpecificationGridComponent', () => {
  let component: SpecificationGridComponent;
  let fixture: ComponentFixture<SpecificationGridComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpecificationGridComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SpecificationGridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
