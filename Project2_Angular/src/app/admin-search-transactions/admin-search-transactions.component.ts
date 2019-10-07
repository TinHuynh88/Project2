import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Project2Service } from '../project2.service';
import { Transaction } from '../transaction';

@Component({
  selector: 'app-admin-search-transactions',
  templateUrl: './admin-search-transactions.component.html',
  styleUrls: ['./admin-search-transactions.component.css']
})
export class AdminSearchTransactionsComponent implements OnInit {

  transList:Transaction[];
  session:string[];
  searchValue:string;
  constructor(private project2Service:Project2Service,private router:Router) { 
    this.searchValue="";
  }

  ngOnInit() {
    this.project2Service.getSession().subscribe(data=>{
      this.session=data;
      if(this.session==null){
        this.router.navigate(['/adminLogin']);
      }else{
        this.project2Service.getAllTransactions().subscribe(data=>{
          this.transList = data;
        });
      }
    });
  }

  searchTransaction(){
    if(this.searchValue==""){
      this.project2Service.getAllTransactions().subscribe(data=>{
        this.transList = data; });
        console.log("seart");
    }else{
    this.project2Service.generalSearchTransaction(this.searchValue).subscribe(data => {
      console.log("search 1: "+this.searchValue);
      this.transList = data;
      if(this.transList==null){
        this.transList= [];
      }
    });
  }
  }
  goProductList(transaction:Transaction){
    console.log("qqqqqqqqqq");
    this.router.navigate(['adminHome/adminProductByTransId', { id: transaction.transactionId }]);
  }
}
