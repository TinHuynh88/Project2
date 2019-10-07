import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminProductsByTransIdComponent } from './admin-products-by-trans-id.component';

describe('AdminProductsByTransIdComponent', () => {
  let component: AdminProductsByTransIdComponent;
  let fixture: ComponentFixture<AdminProductsByTransIdComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminProductsByTransIdComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminProductsByTransIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
