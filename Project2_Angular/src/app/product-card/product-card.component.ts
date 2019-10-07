import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductsService } from '../products.service';
import { Project2Service } from '../project2.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.css']
})
export class ProductCardComponent implements OnInit {

  loggedIn: boolean;
  product: Product;
  productList: Product[];
  session: string[];
  private sub: any;
  id: string;
  outOfStockMessage: string;

  constructor(private project2Service: Project2Service, private router: Router, private route: ActivatedRoute) {
    this.product = new Product();
    this.id = '';
    this.loggedIn = false;
  }

  ngOnInit() {
    this.project2Service.getUserSession().subscribe(data => {
      this.session = data;
      if (this.session == null) {
        this.loggedIn = false;
        this.sub = this.route.params.subscribe(params => {
          this.id = params['id']; // +params['id'];  (+) converts string 'id' to a number
        });
        this.project2Service.getAllProducts().subscribe(prods => {
          this.productList = prods;
          this.productList.forEach(i => {
            if ((i.productId + '') === this.id) {
              this.product = i;
            }
          });
        });
      } else {
        this.loggedIn = true;
        console.log('LOGGED INTO CART')
        this.sub = this.route.params.subscribe(params => {
          this.id = params['id']; // +params['id'];  (+) converts string 'id' to a number
        });
        this.project2Service.getAllProducts().subscribe(prods => {
          this.productList = prods;
          this.productList.forEach(i => {
            if ((i.productId + '') === this.id) {
              this.product = i;
            }
          });
        });
      }
    });
  }

  addToCart(productId: string) {

    if (sessionStorage.length <= 0 && this.product.quantity > 0) {
      console.log('Create sessionStorage');
      sessionStorage.setItem(productId, '1');
      this.product.quantity -= 1;
    } else if (sessionStorage.length > 0 && this.product.quantity > 0) {
      console.log('Update sessionStorage');
      const item = +sessionStorage.getItem(productId);
      sessionStorage.setItem(productId, '' + (item + 1));
      this.product.quantity -= 1;
    } else if (sessionStorage.length > 0 && this.product.quantity <= 0) {
      this.outOfStockMessage = 'Unable to add to your shopping card. Out of stock.';
    } else {
      this.outOfStockMessage = 'Out of stock. Try again in a few days.';
    }

  }

}
