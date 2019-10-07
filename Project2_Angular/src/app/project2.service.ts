import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { User } from './user';
import { Observable } from 'rxjs';
import { Product } from './product';
import { Transaction } from './transaction';
import { Order } from './order';

@Injectable({
  providedIn: 'root'
})
export class Project2Service {
  private adminLoginUrl: string;
  private getSessionUrl: string;
  private adminHomeUrl: string;
  private usersUrl:string;
  private deleteUserByUsernameUrl:string;
  private adminLogoutUrl:string;
  private getUserByUsernameUrl:string;
  private updateUserUrl:string;
  private userLoginUrl: string;
  private getAllProductsUrl: string;
  private deleteProductByIdUrl: string;
  private generalSearchProductUrl:string;
  private getUserSessionUrl: string;
  private userLogOutUrl: string;

  private createTransactionUrl: string;
  private createOrderUrl: string;

  private updateProductUrl: string;
  private generalSearchUserUrl:string;
  private getAllTransactionUrl:string;
  private getOrderByTranIDUrl:string;
  private generalSearchTransactionUrl:string;
  private userRegisterUrl: string;
  private updatePasswordUrl:string;
  


  constructor(private http:HttpClient) { 
    this.adminLoginUrl="http://localhost:3000/adminLogin";
    this.getSessionUrl="http://localhost:3000/getSession";
    this.adminHomeUrl="http://localhost:3000/adminHome";
    this.usersUrl="http://localhost:3000/users";
    this.deleteUserByUsernameUrl="http://localhost:3000/adminUser/";
    this.adminLogoutUrl="http://localhost:3000/adminLogout";
    this.getUserByUsernameUrl="http://localhost:3000//adminUser/";
    this.updateUserUrl="http://localhost:3000/adminUpdateUser";
    this.userLoginUrl="http://localhost:3000/userLogin";
    this.getAllProductsUrl="http://localhost:3000/products";
    this.deleteProductByIdUrl="http://localhost:3000/product/";
    this.generalSearchProductUrl="http://localhost:3000/searchProducts/";
    this.getUserSessionUrl="http://localhost:3000/getUserSession";
    this.userLogOutUrl= "http://localhost:3000/userLogout";

    this.createTransactionUrl="http://localhost:3000/createTransaction";
    this.createOrderUrl="http://localhost:3000/createOrder";

    this.updateProductUrl = "http://localhost:3000/adminUpdateProduct";
    this.generalSearchUserUrl="http://localhost:3000/searchUsers/";
    this.getAllTransactionUrl="http://localhost:3000/transactions";
    this.getOrderByTranIDUrl="http://localhost:3000/ordersByTransactionId/";
    this.generalSearchTransactionUrl="http://localhost:3000/searchTransactions/";
    this.userRegisterUrl="http://localhost:3000/userRegister";
    this.updatePasswordUrl="http://localhost:3000/adminUpdatePassword";

  }

    public createTransaction(transaction) {
    return this.http.post<Transaction>(this.createTransactionUrl, transaction);
  }

  public createOrder(order) {
    return this.http.post<Order>(this.createOrderUrl, order);
  }
  public adminLogin(user: User){
    return this.http.post<User>(this.adminLoginUrl, user);
  }
  public getSession(): Observable<string[]>{
    return this.http.get<string[]>(this.getSessionUrl);
  }
  public adminHome() {
    this.http.get(this.adminHomeUrl);
  }

  public getAllUsers(){
    return this.http.get<User[]>(this.usersUrl);
  }

  public deleteByUsername(user: User){
    return this.http.delete<User>(this.deleteUserByUsernameUrl+user.userName);
  }
  public getUserByUsername(userName: string){
    return this.http.get<User>(this.getUserByUsernameUrl+userName);
  }

  public updateUser(user:User){
    return this.http.put<User>(this.updateUserUrl,user);
  }
  public adminLogout(){
    return this.http.get(this.adminLogoutUrl);
  }

  public userLogin(user: User){
    return this.http.post<User>(this.userLoginUrl, user);
  }
  public getAllProducts(){
    return this.http.get<Product[]>(this.getAllProductsUrl);
  }
  public deleteProductById(product:Product){
    return this.http.delete<Product>(this.deleteProductByIdUrl+product.productId);
  }

  public generalSearchProduct(search: string){
    return this.http.get<Product[]>(this.generalSearchProductUrl+search);
  }

  public getUserSession():Observable<string[]>{
    return this.http.get<string[]>(this.getUserSessionUrl);
  }

  public userLogout(){
    return this.http.get(this.userLogOutUrl);
  }

  public updateProduct(product:Product){
    console.log("product: "+ product.productId);
    return this.http.put<Product>(this.updateProductUrl, product);
  }

  public generalSearchUser(search: string){
    console.log("search 3: "+this.generalSearchUserUrl+search);
    return this.http.get<User[]>(this.generalSearchUserUrl+search);
  }

  public getAllTransactions(){
    return this.http.get<Transaction[]>(this.getAllTransactionUrl);
  }

  public getOrderByTransId(id:string){
    return this.http.get<Order[]>(this.getOrderByTranIDUrl+id);
  }

  public generalSearchTransaction(search: string){
    return this.http.get<Transaction[]>(this.generalSearchTransactionUrl+search);
  }

  public userRegister(user: User){
    return this.http.post<User>(this.userRegisterUrl, user);
  }
  
  public updatePassword(user:User){
    console.log("user: "+ user.firstName);
    return this.http.put<User>(this.updatePasswordUrl,user);
  }
}
