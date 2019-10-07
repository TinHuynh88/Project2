import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Product } from './product';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {
  private createProductUrl: string;
  private getProductsUrl: string;
  private getProductsByIdUrl: string;
  //private deleteProductUrl:string;
  //private getProductUrl:string;
  //private updateProductUrl:string;
  constructor(private http:HttpClient) {
    this.createProductUrl="http://localhost:3000/createProduct";
    this.getProductsUrl="http://localhost:3000/products";
    this.getProductsByIdUrl="http://localhost:3000/products/";
    //this.deleteProductUrl="http://localhost:2000/product/";
    //this.getProductUrl="http://localhost:2000/product/";
    //this.updateProductUrl="http://localhost:2000/updateProduct";
  }

  public getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.getProductsUrl);
  }
  public getProductsById(id: string) {
    return this.http.get<Product>(this.getProductsByIdUrl + id);
  }

  public createProduct(product: Product) {
   return this.http.post<Product>(this.createProductUrl, product);
  }
}
