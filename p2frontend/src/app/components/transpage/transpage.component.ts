import { Component, OnInit } from '@angular/core';
import { AccountService } from 'src/app/services/account.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-transpage',
  templateUrl: './transpage.component.html',
  styleUrls: ['./transpage.component.css']
})
export class TranspageComponent implements OnInit {
  user:any=null;
  account:any=null;
  constructor(private ls:LoginService,private as:AccountService) { }

  ngOnInit(): void {
    this.user=this.ls.user2;
    this.account=this.as.account;
    console.log(this.user)
    console.log(this.account)
  }

}
