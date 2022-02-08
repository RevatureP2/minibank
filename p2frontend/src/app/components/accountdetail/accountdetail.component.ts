import { Component, OnInit } from '@angular/core';
import { AccountService } from 'src/app/services/account.service';



@Component({
  selector: 'app-accountdetail',
  templateUrl: './accountdetail.component.html',
  styleUrls: ['./accountdetail.component.css']
})
export class AccountdetailComponent implements OnInit {

  constructor(private as:AccountService) { }

  ngOnInit(): void {
    console.log(this.as.account);
  }

}
