import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Account } from '../models/account.model';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  user2:any=null;
  // username:any=null;
  // password:any=null;
 // user={username:this.username , password:this.password};
  constructor(private http:HttpClient) { }
  sendlogin(username:String,password:String):Observable<User>{
    let user={username:username , password:password}
    console.log(user);
    let p: Observable<User>=this.http.post("http://localhost:3001/login",user) as Observable<User>;
    //this.user2=p;
    //console.log(this.user2)
    return p;
    
    //return this.http.get("http://localhost:3001/allaccount", {observe:"response"}) as Observable<HttpResponse<User>>;
  }
  reset(email:string):Observable<string>{
    //console.log(account);
    return this.http.get("http://localhost:3001/resetpassword/"+email) as Observable<string>;
    
    //return this.http.get("http://localhost:3001/allaccount", {observe:"response"}) as Observable<HttpResponse<User>>;
  }
}
