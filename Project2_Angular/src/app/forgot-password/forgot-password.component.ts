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

  constructor(private formBuilder: FormBuilder, private project2Service: Project2Service, private router: Router) {

    this.user = new User();
    this.errMessage = "";
  }

  ngOnInit() {
    this.form = this.formBuilder.group({
      username: new FormControl('', [Validators.required]),
      securityQuesion: new FormControl('', [Validators.required]),
      securityAnswer: new FormControl('', [Validators.required])
    });


  }

  get username() {
    return this.form.get('username');
  }

  get securityQuesion() {
    return this.form.get('securityQuesion');
  }

  get securityAnswer() {
    return this.form.get('securityAnswer');
  }

  userLogin() {
    if (this.user.userName == undefined || this.user.password == undefined) {
      this.errMessage = "Please enter username or password";
      return;
    }
    console.log(this.user.password + " test ter- " + this.user.userName);
    this.project2Service.userLogin(this.user).subscribe(data => {
      this.user = data;

      if (this.user != null) {

        console.log("test after- " + this.user.userName);

        this.router.navigate(['/home']);
      } else {

        this.user = new User();
        this.errMessage = "Username and/or password is not entered.";
      }
    });
  }
}
