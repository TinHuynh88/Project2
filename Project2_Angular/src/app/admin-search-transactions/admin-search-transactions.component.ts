import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Project2Service } from '../project2.service';

@Component({
  selector: 'app-admin-search-transactions',
  templateUrl: './admin-search-transactions.component.html',
  styleUrls: ['./admin-search-transactions.component.css']
})
export class AdminSearchTransactionsComponent implements OnInit {

  session:string[];
  constructor(private project2Service:Project2Service,private router:Router) { }

  ngOnInit() {
    this.project2Service.getSession().subscribe(data=>{
      this.session=data;
      if(this.session==null){
        this.router.navigate(['/adminLogin']);
      }
    });
  }

}
