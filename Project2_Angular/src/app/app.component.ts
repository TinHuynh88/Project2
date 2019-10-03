import { Component } from '@angular/core';
import { AdminLoginComponent } from './admin-login/admin-login.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  isAdmin:boolean = true;
  adminLogin: AdminLoginComponent;
   constructor(){};
}
