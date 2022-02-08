import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Account } from '../models/account.model';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  account:any=null;
  constructor(private http:HttpClient) { }
  sendaccount(accounttype:String,balance:number,user:User):Observable<Account>{
    let account={account_type:accounttype , balance:balance, user:user}
    console.log(account);
    let p: Observable<Account>=this.http.post("http://localhost:3001/registeraccount",account) as Observable<Account>;
    //this.user2=p;
    //console.log(this.user2)
    return p;
    
    //return this.http.get("http://localhost:3001/allaccount", {observe:"response"}) as Observable<HttpResponse<User>>;
  }
  getaccountbyid(id:number):Observable<HttpResponse<Account>>{
    //console.log(account);
    return this.http.get("http://localhost:3001/allaccount/"+id+"/",{observe:"response"}) as Observable<HttpResponse<Account>>;
    
    //return this.http.get("http://localhost:3001/allaccount", {observe:"response"}) as Observable<HttpResponse<User>>;
  }
  getaccountbyaccountid(id:number):Observable<Account>{
    //console.log(account);
    return this.http.get("http://localhost:3001/account/"+id) as Observable<Account>;
    
    //return this.http.get("http://localhost:3001/allaccount", {observe:"response"}) as Observable<HttpResponse<User>>;
  }
}
