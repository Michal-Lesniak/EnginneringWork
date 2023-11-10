import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WhyWeSectionComponent } from './why-we-section.component';

describe('WhyWeSectionComponent', () => {
  let component: WhyWeSectionComponent;
  let fixture: ComponentFixture<WhyWeSectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WhyWeSectionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WhyWeSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
