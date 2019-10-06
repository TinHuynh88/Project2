import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { User } from '../user';
import { Router } from '@angular/router';
import { Project2Service } from '../project2.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form:FormGroup;

  user:User;
  session: string[];
  errMessage: string;

  constructor(private formBuilder:FormBuilder, private project2Service: Project2Service, private router: Router) { 

    this.user = new User();
    this.errMessage = "";
  }

  ngOnInit() {
    this.form = this.formBuilder.group({
      username: new FormControl ('', [Validators.required]),
      password: new FormControl ('', [Validators.required,Validators.minLength(5)])
    });

    this.project2Service.getUserSession().subscribe(data => {
      this.session = data;
      if (this.session == null) {
        console.log("logged = false");
       // this.loggedIn=false;
      } else {
        console.log("logged = true");
        this.router.navigate(['/home']);
       // this.loggedIn=true;
        // this.project2Service.getAllUsers().subscribe(data => {
        //   this.userList = data;
        // });
      }
    });
    
  }

  get username(){
    return this.form.get('username');
  }

  get password(){
    return this.form.get('password');
  }

  userLogin(){
    console.log(this.user.password+" test ter- " +this.user.userName);
    this.project2Service.userLogin(this.user).subscribe(data => {
      this.user = data;
      
      if (this.user != null) {
       
        console.log("test after- " + this.user.userName);
        window.location.reload();
     //   this.router.navigate(['/home/products']);
        
      } else {
        
        this.user = new User();
        this.errMessage = "Username and/or password is incorrect.";
      }
    });
  }

}
