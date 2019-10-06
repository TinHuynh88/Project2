import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { Transaction } from '../transaction';
import { Order } from '../order';

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


  constructor() { }

  ngOnInit() {
  }

}
