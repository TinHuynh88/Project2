import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { User } from './user';
import { Observable } from 'rxjs';
import { Product } from './product';


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
<<<<<<< HEAD
  private userRegisterUrl: string;

=======
  private userLoginUrl: string;
  private getAllProductsUrl: string;
  private deleteProductByIdUrl: string;
  private generalSearchProductUrl:string;
  private getUserSessionUrl: string;
  private userLogOutUrl: string;
>>>>>>> 0c53937840895473feea607f0f6ceabf6d5aa260

  constructor(private http:HttpClient) { 
    this.adminLoginUrl="http://localhost:3000/adminLogin";
    this.getSessionUrl="http://localhost:3000/getSession";
    this.adminHomeUrl="http://localhost:3000/adminHome";
    this.usersUrl="http://localhost:3000/users";
    this.deleteUserByUsernameUrl="http://localhost:3000/adminUser/";
<<<<<<< HEAD

    this.userLoginUrl="http://localhost:3000/userLogin";
    this.userRegisterUrl="http://localhost:3000/userRegister";

=======
>>>>>>> 0c53937840895473feea607f0f6ceabf6d5aa260
    this.adminLogoutUrl="http://localhost:3000/adminLogout";
    this.getUserByUsernameUrl="http://localhost:3000//adminUser/";
    this.updateUserUrl="http://localhost:3000/adminUpdateUser";
    this.userLoginUrl="http://localhost:3000/userLogin";
    this.getAllProductsUrl="http://localhost:3000/products";
    this.deleteProductByIdUrl="http://localhost:3000/product/";
    this.generalSearchProductUrl="http://localhost:3000/searchProducts/";
    this.getUserSessionUrl="http://localhost:3000/getUserSession";
    this.userLogOutUrl= "http://localhost:3000/userLogout";
  }

  public adminLogin(user: User){
    return this.http.post<User>(this.adminLoginUrl, user);
  }
  public getSession():Observable<string[]>{
    return this.http.get<string[]>(this.getSessionUrl);
  }
  public adminHome(){
    this.http.get(this.adminHomeUrl);
  }

  public getAllUsers(){
    return this.http.get<User[]>(this.usersUrl);
  }

  public deleteByUsername(user:User){
    console.log("Delete at service: "+user.userName);
    return this.http.delete<User>(this.deleteUserByUsernameUrl+user.userName);
  }
  public getUserByUsername(userName: string){
    return this.http.get<User>(this.getUserByUsernameUrl+userName);
  }

  public updateUser(user:User){
    console.log("user: "+ user.firstName);
    return this.http.put<User>(this.updateUserUrl,user);
  }
  public adminLogout(){
    return this.http.get(this.adminLogoutUrl);
  }

<<<<<<< HEAD
  public userRegister(user: User){
    return this.http.post<User>(this.userRegisterUrl, user);
=======
  public userLogin(user: User){
    return this.http.post<User>(this.userLoginUrl, user);
  }
  public getAllProducts(){
    return this.http.get<Product[]>(this.getAllProductsUrl);
  }
  public deleteProductById(product:Product){
    console.log("Delete at service: "+product.productId);
    return this.http.delete<Product>(this.deleteProductByIdUrl+product.productId);
  }

  public generalSearchProduct(search: string){
    console.log("search 3: "+this.generalSearchProductUrl+search);
    return this.http.get<Product[]>(this.generalSearchProductUrl+search);
  }

  public getUserSession():Observable<string[]>{
    return this.http.get<string[]>(this.getUserSessionUrl);
  }

  public userLogout(){
    return this.http.get(this.userLogOutUrl);
>>>>>>> 0c53937840895473feea607f0f6ceabf6d5aa260
  }
}
