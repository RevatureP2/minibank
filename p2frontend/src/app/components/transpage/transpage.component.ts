import { formatDate } from '@angular/common';
import { Component, Inject, LOCALE_ID, OnInit } from '@angular/core';
import { Account } from 'src/app/models/account.model';
import { AccountService } from 'src/app/services/account.service';
import { LoginService } from 'src/app/services/login.service';

import { TransService } from 'src/app/services/trans.service';

@Component({
  selector: 'app-transpage',
  templateUrl: './transpage.component.html',
  styleUrls: ['./transpage.component.css']
})
export class TranspageComponent implements OnInit {
  user:any=null;
  account:any=null;
  currentDate:String=new Date().toString();
  
  //currentDate:string;
  //currentDate:string='12月 25, 2022';
  amountinput:number=0;
  receiver_id:number=0;
  sender_id:number=0;
  receiver:any=null;
  sender:any=null;
  trans:any=null;
  constructor(private ls:LoginService,private as:AccountService,private ts:TransService,
    @Inject(LOCALE_ID) private locale:string) {
    this.currentDate=formatDate(new Date().toDateString(),'MMM dd, yyyy',this.locale);
   }

  ngOnInit(): void {
    this.user=this.ls.user2;
    this.account=this.as.account;
    console.log(this.user)
    console.log(this.account)
    //console.log(this.account)
    
  }
  getsender(id:number){
    
    this.as.getaccountbyaccountid(id).subscribe(
      (data2:any)=>{
        console.log(data2)
        this.sender=data2;
        console.log(this.sender)
        this.getreceiver(this.receiver_id);
      },
      ()=>{
        
        console.log("getsender failed")
      
      }
    )
  }
  getreceiver(id:number){
    this.as.getaccountbyaccountid(id).subscribe(
      (data3:any)=>{
        console.log(data3)
        this.receiver=data3;
        console.log(this.receiver)
        this.updatetrans();
        
      },
      ()=>{
        
        console.log(" getreceiver failed")
      
      }
    )
  }
  updatetrans():void{
    console.log(this.currentDate);
    //this.currentDate=this.currentDate.toJSON();
    //this.currentDate=this.currentDate.getFullYear()+'-'+this.currentDate.getMonth()+'-'+this.currentDate.getDay();
    
    console.log(this.sender_id)
    console.log(this.receiver_id)
    
    console.log(this.receiver)
    console.log(this.sender)
    // this.getreceiver(this.receiver_id);
    // this.getsender(this.sender_id);

    // this.ts.sendtrans(this.amountinput,this.currentDate,
    //   this.sender,
    //   this.as.getaccountbyaccountid(this.receiver_id).subscribe(receiver=>{console.log(receiver);
    //   this.receiver=receiver;})).subscribe(
      
    this.ts.sendtrans(this.amountinput,this.currentDate,this.sender,this.receiver).subscribe(
      
      (data:any)=>{
        console.log(data)
        this.trans=data;
        console.log(this.receiver)
      },
      ()=>{
        
        console.log("send trans failed")
      
      }
    )
    // this.ts.sendtrans(this.amountinput,this.currentDate,this.account,this.)
  }

}
