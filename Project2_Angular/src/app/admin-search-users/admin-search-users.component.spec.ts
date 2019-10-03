import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminSearchUsersComponent } from './admin-search-users.component';

describe('AdminSearchUsersComponent', () => {
  let component: AdminSearchUsersComponent;
  let fixture: ComponentFixture<AdminSearchUsersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminSearchUsersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminSearchUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
