import { Transaction } from './transaction';
import { Product } from './product';

export class Order {

  private transaction: Transaction;
  private product: Product;
  private quantitySold: number;
  private totalUnitPrice: number;

}