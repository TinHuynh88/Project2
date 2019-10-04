import { Component, OnInit, Input } from '@angular/core';
import { User } from '../user';
import { Router } from '@angular/router';
import { Project2Service } from '../project2.service';


@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent {

  user: User;
  errMessage: string;
  usernameMessage: string;
  passwordMessage: string;

  constructor(private project2Service: Project2Service, private router: Router) {
    this.user = new User();
    //  this.error=false;
    this.errMessage = "";
    this.passwordMessage = "";
    this.usernameMessage = "";
    //  console.log("test 111: " + this.user.userName);
  }


  adminLogin() {
    //    console.log("test: " + this.user.userName);
    this.passwordMessage = "";
    this.usernameMessage = "";
    if (this.user.userName == undefined || this.user.password == undefined) {
      if (this.user.password == undefined)
        this.passwordMessage = "Password can not empty..";

      if (this.user.userName == undefined)
        this.usernameMessage = "Username can not empty..";

      // if (this.user.userName == undefined || this.user.password == undefined)
      return;
    }
    else {
      this.project2Service.adminLogin(this.user).subscribe(data => {
        this.user = data;
        // come back later and change userName to cart once the 
        // cart component & class has been made
        if (this.user != null) {
          // this.project2Service.getSession().forEach(
          //   i=>{
          //     console.log("admiL"+i);
          //   }
          // );
          console.log("test after- " + this.user.userName);
          this.router.navigate(['/adminHome']);
        } else {
          //this.error = true;
          this.user = new User();
          this.errMessage = "Username and/or password is incorrect.";
        }
      });
    }
  }

}

