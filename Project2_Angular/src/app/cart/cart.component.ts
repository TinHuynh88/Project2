import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { Transaction } from '../transaction';
import { Order } from '../order';
import { Project2Service } from '../project2.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Product } from '../product';

@Component({
  selector: 'cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  user: User;
  transaction: Transaction;
  order: Order;
  orders: Order[];

  loggedIn: boolean;
  transTotal: number;
  product: Product;
  productList: Product[];
  session: string[];
  private sub: any;
  id: string;

  constructor(private project2Service: Project2Service, private router: Router, private route: ActivatedRoute) {
    this.product = new Product();
    this.id = '';
    this.loggedIn = false;
    this.user = new User();
    this.order = new Order();
    this.transaction = new Transaction();
    this.orders = [];
    this.transTotal = 0;
  }

  createTransaction() {
    this.transaction.user = this.user;
    this.transaction.transactionPrice = this.transTotal;
    this.transaction.transactionDate = new Date();
    this.project2Service.createTransaction(this.transaction).subscribe( createdTransaction => {
      this.transaction.transactionId = createdTransaction.transactionId;
    });

    this.orders.forEach(lineItem => {
      lineItem.transaction = this.transaction;
      console.log('CREATE ORDER PRODUCT ID:: ' + lineItem.product.productId);
      this.project2Service.createOrder(lineItem).subscribe( createdOrder => {
        this.orders.forEach(order => {
          order.orderId = createdOrder.orderId;
        });
      });
    });

    this.router.navigate(['/home/orderSuccess']);
  }

  ngOnInit() {
    this.project2Service.getUserSession().subscribe(data => {
      this.session = data;
      if (this.session == null) {
        this.router.navigate(['/home']);
      } else {
        // SET LOGGED IN AND GET USER DATA
        this.loggedIn = true;
        this.project2Service.getUserByUsername(this.session[0]).subscribe(userData => {
          this.user = userData;
        });

        // loop through items in sessionStorage and add it to Orders
        if (sessionStorage.length > 0) {
          for (let i = 0; i < sessionStorage.length; i++) {
            // build the order object by pulling the product info from table
            this.project2Service.getAllProducts().subscribe( prods => {
              prods.forEach(prod => {
                if (prod.productId === +sessionStorage.key(i)) {
                  this.order.product = prod;
                  this.order.quantitySold = +sessionStorage.getItem('' + prod.productId);
                  this.order.totalUnitPrice = this.order.quantitySold * this.order.product.productPrice;
                  this.transTotal += this.order.totalUnitPrice;
                  this.orders.push(this.order);
                  this.order = new Order();
                }
              });
            });

          }
        }

      }
    });
  }

}
