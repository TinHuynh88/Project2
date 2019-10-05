import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form:FormGroup;

  constructor(private formBuilder:FormBuilder) { }

  ngOnInit() {
    this.form = this.formBuilder.group({
      username: new FormControl ('', [Validators.required]),
      password: new FormControl ('', [Validators.required,Validators.minLength(5)])
    });

    
  }

  get username(){
    return this.form.get('username');
  }

  get password(){
    return this.form.get('password');
  }

}
