import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Project2Service } from '../project2.service';
import { User } from '../user';

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm : FormGroup;
  user: User;
  userCreated:User;
  errMessage: string;
  streetInput:string;
  cityInput:string;
  stateInput: string;
  zipInput: string;

  constructor(private formBuilder:FormBuilder, private project2Service: Project2Service, private router: Router) {
    this.user = new User();
    this.userCreated= new User();
    this.errMessage = "";
    this.streetInput="";
    this.cityInput="";
    this.stateInput="";
    this.zipInput="";
   }

  ngOnInit() {

    this.registerForm = this.formBuilder.group({
      firstname: new FormControl('',[Validators.required]),
      lastname: new FormControl('',[Validators.required]),
      phone: new FormControl('',[Validators.required, Validators.minLength(10), Validators.maxLength(10)]),
      stadd: new FormControl('',[Validators.required]),
      city: new FormControl('',[Validators.required]),
      state: new FormControl('',[Validators.required]),
      zipcode: new FormControl('',[Validators.required,Validators.pattern('^[0-9]*$'),Validators.minLength(5),Validators.maxLength(5)]),
      username: new FormControl('',[Validators.required]),
      email: new FormControl('',[Validators.email]),
      password: new FormControl('',[Validators.required]),
      confirmPassword: new FormControl('',[Validators.required]),
      securityQuestion: new FormControl('',[Validators.required]),
      securityAnswer: new FormControl('',[Validators.required])
    });

  }

  

  get firstname(){
    return this.registerForm.get('firstname')
  }

  get lastname(){
    return this.registerForm.get('lastname')
  }

  get phone(){
    return this.registerForm.get('phone')
  }

  get stadd(){
    return this.registerForm.get('stadd')
  }

  get city(){
    return this.registerForm.get('city')
  }

  get state(){
    return this.registerForm.get('state')
  }

  get zipcode(){
    return this.registerForm.get('zipcode')
  }

  get username(){
    return this.registerForm.get('username')
  }

  get email(){
    return this.registerForm.get('email')
  }

  get password(){
    return this.registerForm.get('password')
  }

  get confirmPassword(){
    return this.registerForm.get('confirmPassword')
  }

  get securityQuestion(){
    return this.registerForm.get('securityQuestion')
  }

  get securityAnswer(){
    return this.registerForm.get('securityAnswer')
  }

  userRegister(){
    if(this.user.userName == undefined || this.user.password == undefined){
      this.errMessage="Please fill out all the fields.";
      return ;
    }
    this.user.role="User";
    this.user.address=this.streetInput+", "+this.cityInput+", "+this.stateInput+", "+this.zipInput;
    this.project2Service.userRegister(this.user).subscribe(data => {
      this.userCreated = data;
      
      if (this.userCreated != null) {
       
        console.log("test after- " + this.userCreated.userName);
        
        this.router.navigate(['/home']);
      } else {
        
        this.userCreated = new User();
        this.errMessage = "Please fill remaining fields.";
      }
    });
  }

}
