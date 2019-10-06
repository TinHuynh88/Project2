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
  constructor(private project2Service: Project2Service, private router: Router, private route: ActivatedRoute, private location: Location) {
    this.product = new Product();
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
              console.log("This product: "+this.product.productId);
            }
          });
        });
      }
    });
  }

  updateUser() {

    //if (this.isUpdate) {
    //   console.log("ddddddddddd"+this.user.userName);
    //   console.log("dddd"+this.user.password);
    //   this.project2Service.updateUser(this.user).subscribe(data=>{
    //     this.user=data;
    //     alert("Update User[ "+this.user.userName+" ] succeeded.");
    //   });
    //   console.log("qqqq"+this.user.password);
    // }
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
