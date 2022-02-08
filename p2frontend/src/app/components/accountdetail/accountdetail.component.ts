import { Component, OnInit,ViewChild, ElementRef } from '@angular/core';
import { AccountService } from 'src/app/services/account.service';
import { TransService } from 'src/app/services/trans.service';

import {jsPDF} from 'jspdf';


@Component({
  selector: 'app-accountdetail',
  templateUrl: './accountdetail.component.html',
  styleUrls: ['./accountdetail.component.css']
})
export class AccountdetailComponent implements OnInit {
  account:any=null;
  income:any=null;
  expense:any=null;
  monthlytrans:any=null;
  totalincome:number=0;
  totalexpense:number=0;
  totalbudget:number=0;
  monthlyincome:number=0;
  monthlyexpense:number=0;
  monthlybudget:number=0;
  month:number=0;

  constructor(private as:AccountService,private ts:TransService) { }

  ngOnInit(): void {
    this.account=this.as.account;
    console.log(this.as.account);
    this.ts.getincome(this.as.account.id).subscribe(
      (data:any)=>{
        //console.log(data)
        this.income=data;
        console.log(this.income)
        for(var temp of this.income){
          this.totalincome=this.totalincome+temp.trans_amount;
        }
        this.ts.getexpense(this.as.account.id).subscribe(
          (data:any)=>{
            //console.log(data)
            this.expense=data;
            for(var temp of this.expense){
              this.totalexpense=this.totalexpense+temp.trans_amount;
              this.totalbudget=this.totalincome-this.totalexpense;
              
            }
          },
          ()=>{
            this.account=null;
            console.log("its gone")
          }
        )
      },
      ()=>{
        this.account=null;
        console.log("its gone")
      }
    )
    
  }
  monthbudget():void{
    console.log(this.month)
    this.monthlybudget=0;
    this.monthlyexpense=0;
    this.monthlyincome=0;
    this.ts.getmonthbudget(this.as.account.id,this.month).subscribe(
      (data:any)=>{
        //console.log(data)
        this.monthlytrans=data;
        console.log(this.monthlytrans)
        for(var temp of this.monthlytrans){
          if(temp.sender.id===this.as.account.id){
            this.monthlyexpense=this.monthlyexpense+temp.trans_amount;
            console.log(this.monthlyexpense)
          }
          else{
            this.monthlyincome=this.monthlyincome+temp.trans_amount;
            console.log(this.monthlyincome)
          }
          
        }
        this.monthlybudget=this.monthlyincome-this.monthlyexpense;
      },
      ()=>{

        console.log("its gone")
      }
    )
  }
  

}


