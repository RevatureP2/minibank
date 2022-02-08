import { Component, OnInit } from '@angular/core';
import { AccountService } from 'src/app/services/account.service';
import { TransService } from 'src/app/services/trans.service';



@Component({
  selector: 'app-accountdetail',
  templateUrl: './accountdetail.component.html',
  styleUrls: ['./accountdetail.component.css']
})
export class AccountdetailComponent implements OnInit {
  account:any=null;
  income:any=null;
  expense:any=null;
  constructor(private as:AccountService,private ts:TransService) { }

  ngOnInit(): void {
    this.account=this.as.account;
    console.log(this.as.account);
    this.ts.getincome(this.as.account.id).subscribe(
      (data:any)=>{
        //console.log(data)
        this.income=data;
        console.log(this.income)
        this.ts.getexpense(this.as.account.id).subscribe(
          (data:any)=>{
            //console.log(data)
            this.expense=data;
            console.log(this.expense)
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

}
