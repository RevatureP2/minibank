import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-accountpage',
  templateUrl: './accountpage.component.html',
  styleUrls: ['./accountpage.component.css']
})
export class AccountpageComponent implements OnInit {
  user:any=null;
  subscription:Subscription=new Subscription();
  constructor(private ls:LoginService) { }

  ngOnInit(): void {
    this.user=this.ls.user2;
    console.log(this.user);
  }

}
