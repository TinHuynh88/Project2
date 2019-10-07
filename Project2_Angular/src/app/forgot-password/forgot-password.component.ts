import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { User } from '../user';
import { Project2Service } from '../project2.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {
  form: FormGroup;

  user: User;

  errMessage: string;
  listUser: User[];

  constructor(private formBuilder: FormBuilder, private project2Service: Project2Service, private router: Router) {

    this.user = new User();
    this.errMessage = "";
  }

  ngOnInit() {
    // this.form = this.formBuilder.group({
    //   username: new FormControl('', [Validators.required]),
    //   securityQuesion: new FormControl('', [Validators.required]),
    //   securityAnswer: new FormControl('', [Validators.required])
    // });


  }

  // get username() {
  //   return this.form.get('username');
  // }

  // get securityQuesion() {
  //   return this.form.get('securityQuesion');
  // }

  // get securityAnswer() {
  //   return this.form.get('securityAnswer');
  // }

  forgotPassword() {
    if (this.user.email == undefined || this.user.securityAnswer == undefined 
      || this.user.securityQuestion == undefined) {
      this.errMessage = "Please enter all fields";
      return;
    }
    console.log(this.user.email + " test ter- " + this.user.securityQuestion);
    this.project2Service.getAllUsers().subscribe(data => {
      this.listUser = data;
      this.listUser.forEach(u => {
        if (u.securityQuestion == this.user.securityQuestion
          && u.securityAnswer.toLowerCase() == this.user.securityAnswer.toLocaleLowerCase()
          && u.email.toLocaleLowerCase() == this.user.email.toLocaleLowerCase()) {
          this.router.navigate(['home/resetPassword', { id: u.userName }]);
          return;
        } 
         
        
      });
      this.errMessage = "Your information is not correct. Please retry...";
    });
  }
  
}

