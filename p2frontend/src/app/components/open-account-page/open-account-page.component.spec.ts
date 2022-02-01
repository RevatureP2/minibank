import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OpenAccountPageComponent } from './open-account-page.component';

describe('OpenAccountPageComponent', () => {
  let component: OpenAccountPageComponent;
  let fixture: ComponentFixture<OpenAccountPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OpenAccountPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OpenAccountPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
