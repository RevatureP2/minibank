import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class RegisterServiceService {
 
  constructor(private http:HttpClient) { }
  sendregister(username:String,password:String,fname:String,lname:String,email:String):Observable<User>{
    let user={username:username , password:password,email:email,firstname:fname,lastname:lname}
    console.log(user);
    let p: Observable<User>=this.http.post("http://localhost:3001/registeruser",user) as Observable<User>;

    return p;
    
    //return this.http.get("http://localhost:3001/allaccount", {observe:"response"}) as Observable<HttpResponse<User>>;
  }
}
