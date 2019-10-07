import { Transaction } from './transaction';
import { Product } from './product';

export class Order {

  orderId: number;

  transaction: Transaction;
  product: Product;
  quantitySold: number;
  totalUnitPrice: number;

}