import { Component, OnInit } from '@angular/core';
import { LoginComponent } from '../login/login.component';
import { LogoutComponent } from '../logout/logout.component';
import { ForgotPasswordComponent } from '../forgot-password/forgot-password.component';
import { RegisterComponent } from '../register/register.component';
import { CartComponent } from '../cart/cart.component';
import { UserAccountComponent } from '../user-account/user-account.component';
import { ProductPageComponent } from '../product-page/product-page.component';
import { Project2Service } from '../project2.service';
import { Router } from '@angular/router';

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  loggedIn: boolean;

  title = 'Vintage Video Games';
  login: LoginComponent;
  logout: LogoutComponent;
  register: RegisterComponent;
  cart: CartComponent;
  account: UserAccountComponent;
  products: ProductPageComponent;


  session: string[];
  constructor(private project2Service: Project2Service, private router: Router) { }

  ngOnInit() {
    this.project2Service.getUserSession().subscribe(data => {
      this.session = data;
      if (this.session == null) {
        console.log("logged = false");
        this.loggedIn=false;
      } else {
        console.log("logged = true");
        this.loggedIn=true;
        // this.project2Service.getAllUsers().subscribe(data => {
        //   this.userList = data;
        // });
      }
    });
  }

  userLogout(){
    if(confirm("Do you want to Log Out ?")) {
      console.log("Implement delete functionality here");
      this.project2Service.userLogout().subscribe(data=>{
        window.location.reload();
      });
    }
    
  }
}
