import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Project2Service } from '../project2.service';
import { Product } from '../product';
@Component({
  selector: 'app-admin-search-products',
  templateUrl: './admin-search-products.component.html',
  styleUrls: ['./admin-search-products.component.css']
})
export class AdminSearchProductsComponent implements OnInit {

  session: string[];
  prodList: Product[];
  searchValue: string;
  constructor(private project2Service: Project2Service, private router: Router) {
    this.searchValue="";
  }

  ngOnInit() {
    this.project2Service.getSession().subscribe(data => {
      this.session = data;
      if (this.session == null) {
        this.router.navigate(['/adminLogin']);
      } else {
        this.project2Service.getAllProducts().subscribe(data => {
          this.prodList = data;
        });
      }
    });
  }

  goEditProduct(product: Product) {
    // userTransfer = user;
    this.router.navigate(['adminHome/adminEditProduct', { id: product.productId }]);
  }
  deleteProductById(product: Product) {
    console.log("delete: " + product.productId);
    if (confirm("Do you want to delete Product: " + product.productName)) {
      this.project2Service.deleteProductById(product).subscribe(
        data => this.project2Service.getAllProducts().subscribe(data => {
          this.prodList = data;
        }));
    }
  }

  searchProduct(){
    console.log("search 0: "+this.searchValue);
    if(this.searchValue==""){
      this.project2Service.getAllProducts().subscribe(data => {
        this.prodList = data; });
    }else{
    this.project2Service.generalSearchProduct(this.searchValue).subscribe(data => {
      console.log("search 1: "+this.searchValue);
      this.prodList = data;
      if(this.prodList==null){
        this.prodList= [];
      }
    });
  }
  }
}
