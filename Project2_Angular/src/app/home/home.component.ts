import { Component, OnInit } from '@angular/core';
import { LoginComponent } from '../login/login.component';
import { LogoutComponent } from '../logout/logout.component';
import { ForgotPasswordComponent } from '../forgot-password/forgot-password.component';
import { RegisterComponent } from '../register/register.component';
import { CartComponent } from '../cart/cart.component';
import { UserAccountComponent } from '../user-account/user-account.component';
import { Product } from '../product';
import { ProductCardComponent } from '../product-card/product-card.component';

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  loggedIn = false;

  product: Product;
  productCard: ProductCardComponent;
  products: ProductCardComponent[] = [];

  title = 'Vintage Video Games';
  login: LoginComponent;
  logout: LogoutComponent;
  register: RegisterComponent;
  cart: CartComponent;
  account: UserAccountComponent;

  constructor() { }

  ngOnInit() {
    const p1 = new Product(100, 'Super Mario World', 34, '1991/03/25',
      'Platformer', 7, 10, 'SNES',
      'http://content.propertyroom.com/listings/sellers/seller888888939/images/origimgs/888888939_183201702445865.jpg');
    const p1Card = new ProductCardComponent(p1);
    this.products.push(p1Card);
    const p2 = new Product(101, 'Donkey Kong Country', 27, '1993/06/07', 
      'Platformer', 3, 10, 'SNES', 
      'http://www.retrogameguide.com/images/box_art_and_carts/SNES-Donkey-Kong-Country-cart.jpg');
    const p2Card = new ProductCardComponent(p2);
    this.products.push(p2Card);
    const p3 = new Product(103, 'Star Fox', 21, '1994/05/12', 
      'Space Battles', 5, 10, 'SNES', 
        'http://images.nintendolife.com/news/2017/09/editorial_the_snes_classic_mini_star_fox_and_downsides_to_being_a_mega_drive_kid/attachment/0/original.jpg');
    const p3Card = new ProductCardComponent(p3);
    this.products.push(p3Card);
    const p4 = new Product(104, 'Super Metroid', 26, '1994/07/04', 
      'Platformer', 2, 10, 'SNES', 
      'http://images.eurogamer.net/2014/usgamer/super-metroid-box.jpg');
    const p4Card = new ProductCardComponent(p4);
    this.products.push(p4Card);
  }

}
