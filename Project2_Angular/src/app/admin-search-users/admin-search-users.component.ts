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

  // user:User;
  session: string[];
  userList: User[];
  constructor(private project2Service: Project2Service, private router: Router) {

    //  
  }

  ngOnInit() {
    this.project2Service.getSession().subscribe(data => {
      this.session = data;
      if (this.session == null) {
        this.router.navigate(['/adminLogin']);
      } else {
        this.project2Service.getAllUsers().subscribe(data => {
          this.userList = data;
        });
      }
    });
  }

  goEditUser(user: User) {
   // userTransfer = user;
    this.router.navigate(['adminHome/adminEditUser', { id: user.userName }]);
  }
  deleteByUsername(user: User) {
    console.log("delete: " + user.userName);
    if(confirm("Do you want to delete User: "+user.userName)) {
    this.project2Service.deleteByUsername(user).subscribe(
      data => this.project2Service.getAllUsers().subscribe(data => {
        this.userList = data;
      }));
    }
  }

  

}

//export var userTransfer: User = new User();