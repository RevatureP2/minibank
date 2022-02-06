import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AccountService } from 'src/app/services/account.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-open-account-page',
  templateUrl: './open-account-page.component.html',
  styleUrls: ['./open-account-page.component.css']
})
export class OpenAccountPageComponent implements OnInit {

  balance:number=0;
  user:any=null;
  htmltoadd: string | undefined;
  constructor(private as:AccountService,private router:Router,private ls:LoginService) { }

  ngOnInit(): void {
  }
  createaccount(accounttype:String):void{
    this.user=this.ls.user2;
    this.as.sendaccount(accounttype,this.balance,this.user).subscribe(

      (data:any)=>{
        console.log(data)
        console.log(data.address)
        this.user=data;
        this.htmltoadd='<div class="form-outline form-white mb-4">Account created!</div>'
        // this.router.navigate(["/account"]);
        // this.ls.user2=data;
      },
      ()=>{
        this.user=null;
        console.log("failed")
        this.htmltoadd='<div class="form-outline form-white mb-4">Create Account failed!</div>'
      }

    )
  }
}
