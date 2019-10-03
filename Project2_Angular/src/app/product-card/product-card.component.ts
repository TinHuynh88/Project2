import { Component, OnInit } from '@angular/core';
import { Product } from '../product';

@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.css']
})
export class ProductCardComponent implements OnInit {

  private productId: number;
  private productName: string;
  private productPrice: number;
  private releaseDate: string;
  private category: string;
  private quantity: number;
  private rating: number;
  private system: string;
  // URL
  private picture: string;

  constructor(product: Product) {
    this.productId = product.getProductId;
    this.productName = product.getProductName;
    this.productPrice = product.getProductPrice;
    this.releaseDate = product.getReleaseDate;
    this.category = product.getCategory;
    this.quantity = product.getQuantity;
    this.rating = product.getRating;
    this.system = product.getSystem;
    this.picture = product.getPicture;
  }

  ngOnInit() {
  }

}
