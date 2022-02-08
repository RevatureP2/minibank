import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Account } from '../models/account.model';
import { Trans } from '../models/trans.model';
import { AccountService } from './account.service';

@Injectable({
  providedIn: 'root'
})
export class TransService {

  constructor(private http:HttpClient,private as:AccountService) { }
  sendtrans(amount:number,currentdate:String,sender:Account,receiver:Account):Observable<Trans>{

    let trans={trans_amount:amount , transdate:currentdate,sender:sender,receiver:receiver}
    console.log(trans);
    let p: Observable<Trans>=this.http.post("http://localhost:3001/trans",trans) as Observable<Trans>;
    //this.user2=p;
    //console.log(this.user2)
    return p;
    
    //return this.http.get("http://localhost:3001/allaccount", {observe:"response"}) as Observable<HttpResponse<User>>;
  }
}
