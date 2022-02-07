import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { LoginpageComponent } from '../loginpage/loginpage.component';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
user:any = null;
  constructor(private ls:LoginService) { }

  ngOnInit(): void {
    this.user=this.ls.user2;
    console.log(this.user)
  }

}
