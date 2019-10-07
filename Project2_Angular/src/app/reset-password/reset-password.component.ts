import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { Project2Service } from '../project2.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent implements OnInit {

  user: User;
  id: string;
  private sub: any;
  isUpdate: boolean;
  session: string[];
  confirmPassword: string;
  errMessage: string;

  constructor(private project2Service: Project2Service, private router: Router, private route: ActivatedRoute) {
    this.user = new User();
    this.isUpdate = true;
    this.errMessage="";
  }

  updatePassword(){
    // subscribe data to the server for updating password 
    if(this.user.password!=this.confirmPassword){
      this.errMessage="Password is not matching..";
      return;
    }
    console.log("aaa: "+this.user.password+"--"+this.user.userName);
    this.project2Service.updatePassword(this.user).subscribe(data=>{
      this.user=data;
      alert("Update User[ "+this.user.userName+" ] succeeded with password.");
    
      //reset password succeed, redirect to login page
    this.router.navigate(['home/login']);
    });
  }

  ngOnInit() {
        this.sub = this.route.params.subscribe(params => {
          this.id = params['id']; // +params['id'];  (+) converts string 'id' to a number
        });
        
        this.project2Service.getUserByUsername(this.id).subscribe(data => {
          this.user = data;
        });
  }

}
