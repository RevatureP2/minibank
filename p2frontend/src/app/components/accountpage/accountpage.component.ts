import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Account } from 'src/app/models/account.model';

import { AccountService } from 'src/app/services/account.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-accountpage',
  templateUrl: './accountpage.component.html',
  styleUrls: ['./accountpage.component.css']
})
export class AccountpageComponent implements OnInit {
  user:any=null;
  account:any=null;
  selected:any=null;
  subscription:Subscription=new Subscription();
  constructor(private ls:LoginService,private as:AccountService) { }

  ngOnInit(): void {
    this.user=this.ls.user2;
    this.as.getaccountbyid(this.user.id).subscribe(
      (data:any)=>{
        console.log(data)
        console.log(data.status)
        this.account=data.body;
        this.as.account=data.body;
        console.log(this.account)

        

      },
      ()=>{
        this.account=null;
        console.log("its gone")
      }
    )
    console.log(this.user);
  }
onSelect(id:number){
  console.log(id)
  this.as.account=this.account.find((element:any) => element.id===id)
  console.log(this.as.account)
}
}
