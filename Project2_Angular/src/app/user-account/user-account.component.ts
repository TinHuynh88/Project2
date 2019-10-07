import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductsService } from '../products.service';
import { Project2Service } from '../project2.service';
import { Product } from '../product';
import { Order } from '../order';
import { Transaction } from '../transaction';
import { User } from '../user';

@Component({
  selector: 'user-account',
  templateUrl: './user-account.component.html',
  styleUrls: ['./user-account.component.css']
})
export class UserAccountComponent implements OnInit {

  user: User;
  product: Product;
  loggedIn: boolean;
  session: string[];
  orders: Order[];
  transactions: Transaction[];
  products: Product[] = [];

  constructor(private project2Service: Project2Service, private productsService: ProductsService, private router: Router) { }

  ngOnInit() {

    this.project2Service.getUserSession().subscribe(data => {
      this.session = data;
      if (this.session == null) {
        this.loggedIn = false;
        this.router.navigate(['/home/products']);
      } else {
        this.loggedIn = true;
//        window.location.reload();
        this.project2Service.getUserByUsername(this.session[0]).subscribe(userData => {
          this.user = userData;
        });
        
      }
    });

  }

}
