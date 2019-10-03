import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { Router } from '@angular/router';
import { Project2Service } from '../project2.service';


@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {

  session:string[];
  constructor(private project2Service:Project2Service,private router:Router) {
   // let x= getProjectService()
    this.project2Service.getSession().subscribe(data=>{
      this.session=data;
      if(this.session==null){
        this.router.navigate(['/adminLogin']);
      }
    });
    
  }

  ngOnInit() {
   // this.project2Service.adminHome();
  }

}

