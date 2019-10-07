import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ActivatedRoute, Router } from '@angular/router';
import { Project2Service } from '../project2.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-admin-edit-product',
  templateUrl: './admin-edit-product.component.html',
  styleUrls: ['./admin-edit-product.component.css']
})
export class AdminEditProductComponent implements OnInit {

  product: Product;
  productList: Product[];
  id: string;
  private sub: any;
  isUpdate: boolean;
  session: string[];
 // releastDate:Date;
  constructor(private project2Service: Project2Service, private router: Router, private route: ActivatedRoute, private location: Location) {
    this.product = new Product();
    this.isUpdate = true;
  //  this.releastDate=new Date();
   }

  ngOnInit() {
    this.project2Service.getSession().subscribe(data => {
      this.session = data;
      if (this.session == null) {
        this.router.navigate(['/adminLogin']);
      } else {
        this.sub = this.route.params.subscribe(params => {
          this.id = params['id']; // +params['id'];  (+) converts string 'id' to a number
        });

        this.project2Service.getAllProducts().subscribe(data => {
          this.productList = data;
          this.productList.forEach(i => {
            if((i.productId+"")==this.id){
              this.product=i;
         //     this.releastDate = new Date(this.product.releaseDate);
              console.log("This product: "+this.product.productId);
            }
          });
        });
      }
    });
  }

  updateProduct() {

    if (this.isUpdate) {
      console.log("ddddddddddd"+this.product.productName);
      console.log("dddd"+this.product.releaseDate);
      this.project2Service.updateProduct(this.product).subscribe(data=>{
        this.product=data;
        alert("Update Product [ "+this.product.productName+" ] succeeded.");
      });
      console.log("qqqq"+this.product.productId);
    }
    else{
      console.log("aaaaaaaaaaaaaaaaaaaaa");
    }
  }

  goBack() {
    //window.history.go(-1);
    this.location.back();
    this.isUpdate = false;
  }
  
}
