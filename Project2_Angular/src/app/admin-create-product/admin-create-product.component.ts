import { Component, OnInit } from '@angular/core';
import { Products } from '../products';
import { ProductsService } from '../products.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-create-product',
  templateUrl: './admin-create-product.component.html',
  styleUrls: ['./admin-create-product.component.css']
})
export class AdminCreateProductComponent {
  product:Products;
  constructor(private productService:ProductsService, private router:Router) {
    this.product=new Products();
  }
  createProduct() {
    this.productService.createProduct(this.product).subscribe(data=>this.gotoProductList());
  }
  
  gotoProductList() {
    this.router.navigate(['/products']);
  }
}

