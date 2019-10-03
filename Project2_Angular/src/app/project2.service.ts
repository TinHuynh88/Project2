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


  constructor(private http:HttpClient) { 
    this.adminLoginUrl="http://localhost:3000/adminLogin";
    this.getSessionUrl="http://localhost:3000/getSession";
    this.adminHomeUrl="http://localhost:3000/adminHome";
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
}
