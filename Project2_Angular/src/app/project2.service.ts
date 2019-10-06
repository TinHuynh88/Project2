import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { User } from './user';
import { Observable } from 'rxjs';


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

  public userLogin(user: User){
    return this.http.post<User>(this.userLoginUrl, user);
  }
}
