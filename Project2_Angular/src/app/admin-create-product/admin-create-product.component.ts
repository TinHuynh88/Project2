<<<<<<< HEAD
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-create-product',
  templateUrl: './admin-create-product.component.html',
  styleUrls: ['./admin-create-product.component.css']
})
export class AdminCreateProductComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
=======
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

>>>>>>> 08fba8f654623e68484b57814a5345a36c0b3dba
