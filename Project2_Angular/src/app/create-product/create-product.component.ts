import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductsService } from '../products.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {

  product: Product;

  constructor(private productsService: ProductsService, private router: Router ) {
    this.product = new Product();
  }

  createProduct() {
    this.productsService.createProduct(this.product).subscribe(data => this.gotoProductsPage());
  }

  gotoProductsPage() {

    this.router.navigate(['/home']);

  }

}
