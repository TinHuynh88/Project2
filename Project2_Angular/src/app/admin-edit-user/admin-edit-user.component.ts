import { Component, OnInit, OnDestroy } from '@angular/core';
import { User } from '../user';
//import { userTransfer } from '../admin-search-users/admin-search-users.component';
import { ActivatedRoute, Router } from '@angular/router';
import { Project2Service } from '../project2.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-admin-edit-user',
  templateUrl: './admin-edit-user.component.html',
  styleUrls: ['./admin-edit-user.component.css']
})
export class AdminEditUserComponent implements OnInit, OnDestroy {

  user: User;
  id: string;
  private sub: any;
  isUpdate: boolean;

  constructor(private project2Service: Project2Service, private router: Router, private route: ActivatedRoute, private location: Location) {
    this.user = new User();
    this.isUpdate = true;
  }

  ngOnInit() {
    //  this.user = userTransfer;
    this.sub = this.route.params.subscribe(params => {
      this.id = params['id']; // +params['id'];  (+) converts string 'id' to a number
    });

    this.project2Service.getUserByUsername(this.id).subscribe(data => {
      this.user = data;
    });
  }

  updateUser(user: User) {

    if (this.isUpdate) {
      console.log("ddddddddddd"+user.userName);
      this.project2Service.updateUser(user).subscribe(data => {
        this.user = data;
        if (this.user == null) {
          console.log("Email unique");

        } else {

          this.router.navigate(['adminHome/adminSearchUsers']);
        }
      });
    }
    // else{
    //   console.log("aaaaaaaaaaaaaaaaaaaaa");
    // }
  }

  goBack() {
    //window.history.go(-1);
    this.location.back();
    this.isUpdate = false;
  }
  ngOnDestroy() {
    this.sub.unsubscribe();
  }

}
