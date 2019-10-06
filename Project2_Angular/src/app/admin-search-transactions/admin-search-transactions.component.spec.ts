import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminSearchTransactionsComponent } from './admin-search-transactions.component';

describe('AdminSearchTransactionsComponent', () => {
  let component: AdminSearchTransactionsComponent;
  let fixture: ComponentFixture<AdminSearchTransactionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminSearchTransactionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminSearchTransactionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
