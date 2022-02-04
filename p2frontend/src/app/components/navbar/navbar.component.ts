import { NonNullAssert } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { LoginpageComponent } from '../loginpage/loginpage.component';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  user:any=null;
  constructor(private ls:LoginService) { }

  ngOnInit(): void {
    this.user=this.ls.user2;
    console.log(this.user)
  }

}
