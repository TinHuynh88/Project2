import { Component, OnInit } from '@angular/core';
import { LoginComponent } from '../login/login.component';
import { LogoutComponent } from '../logout/logout.component';
import { ForgotPasswordComponent } from '../forgot-password/forgot-password.component';
import { RegisterComponent } from '../register/register.component';
import { CartComponent } from '../cart/cart.component';
import { UserAccountComponent } from '../user-account/user-account.component';
import { ProductPageComponent } from '../product-page/product-page.component';

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  loggedIn = false;

  title = 'Vintage Video Games';
  login: LoginComponent;
  logout: LogoutComponent;
  register: RegisterComponent;
  cart: CartComponent;
  account: UserAccountComponent;
  products: ProductPageComponent;

  constructor() { }

  ngOnInit() {

  }

}
