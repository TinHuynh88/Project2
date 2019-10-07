import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductsService } from '../products.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-create-product',
  templateUrl: './admin-create-product.component.html',
  styleUrls: ['./admin-create-product.component.css']
})
export class AdminCreateProductComponent {
  product: Product;

  constructor(private productsService: ProductsService, private router: Router ) {
    this.product = new Product();
  }

  ngOnInit() {
  }
  
  createProduct() {
    this.productsService.createProduct(this.product).subscribe(data => this.gotoProductsPage());
  }

  gotoProductsPage() {

    this.router.navigate(['/adminHome']);

  }
  
  gotoProductList() {
    this.router.navigate(['/products']);
  }
}

