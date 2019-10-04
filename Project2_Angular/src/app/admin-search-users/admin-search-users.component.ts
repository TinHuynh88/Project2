import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Project2Service } from '../project2.service';
import { User } from '../user';

@Component({
  selector: 'app-admin-search-users',
  templateUrl: './admin-search-users.component.html',
  styleUrls: ['./admin-search-users.component.css']
})
export class AdminSearchUsersComponent implements OnInit {

  session:string[];
  userList: User[];
  constructor(private project2Service:Project2Service,private router:Router) {

  //  
   }

  ngOnInit() {
    this.project2Service.getSession().subscribe(data=>{
      this.session=data;
      if(this.session==null){
        this.router.navigate(['/adminLogin']);
      }else{
        this.project2Service.getAllUsers().subscribe(data=>{
          this.userList = data;
        });
      }
    });
  }

  deleteByUsername(user:User){
    console.log("delete: "+user.userName);
    this.project2Service.deleteByUsername(user).subscribe(
      data=>this.project2Service.getAllUsers().subscribe(data=>{
        this.userList = data;
      }));
  }
 

}
