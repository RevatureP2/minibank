import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserProfileService {

  constructor(private http:HttpClient) { }
  updateProfile(userid:number, Address:String,Email:String, firstname:String, lastname:String, phonenumber:String):Observable<User>{
    let user={ email:Email, firstname:firstname, lastname:lastname, address:Address, phonenumber:phonenumber}
    console.log(user);
    let p: Observable<User>=this.http.post("http://localhost:3001/updateprofile/" + userid, user) as Observable<User>;

    return p;
   }
}
