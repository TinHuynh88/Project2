import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ActivatedRoute, Router } from '@angular/router';
import { Project2Service } from '../project2.service';
import { Order } from '../order';
import { Location } from '@angular/common';

@Component({
  selector: 'app-admin-products-by-trans-id',
  templateUrl: './admin-products-by-trans-id.component.html',
  styleUrls: ['./admin-products-by-trans-id.component.css']
})
export class AdminProductsByTransIdComponent implements OnInit {

  product: Product;
  orderList: Order[];
  productList: Product[];
  id: string;
  private sub: any;
  isUpdate: boolean;
  session: string[];
  constructor(private location: Location,private project2Service: Project2Service, private router: Router, private route: ActivatedRoute) {
    this.productList=[];
    this.product=new Product();
    this.orderList=[];
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

        console.log("cc"+this.id);
        this.project2Service.getOrderByTransId(this.id).subscribe(data => {
          data.forEach(i => {
            
            if((i.transaction.transactionId+"")==this.id){
              console.log("bb"+i.product);
              this.productList.push(i.product);
              this.orderList.push(i);
         //     this.releastDate = new Date(this.product.releaseDate);
             // console.log("This product: "+this.product.productId);
            }
          });
        });
      }
    });
   }
   goProductList(order:Order){

   }
   goBack(){
    this.location.back();
   }
}
