import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm : FormGroup;
  constructor(private formBuilder: FormBuilder) { }

  ngOnInit() {

    this.registerForm = this.formBuilder.group({
      firstname: new FormControl('',[Validators.required]),
      lastname: new FormControl('',[Validators.required]),
      address: new FormControl('',[Validators.required]),
      city: new FormControl('',[Validators.required]),
      state: new FormControl('',[Validators.required]),
      zipcode: new FormControl('',[Validators.required,Validators.pattern('^[0-9]*$'),Validators.minLength(5),Validators.maxLength(5)]),
      username: new FormControl('',[Validators.required]),
      email: new FormControl('',[Validators.email]),
    });

  }

  get zipcode(){
    return this.registerForm.get('zipcode')
  }

  get username(){
    return this.registerForm.get('username')
  }

}
