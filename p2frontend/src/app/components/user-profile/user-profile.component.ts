import { Component, OnInit, Input } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import{UserProfileService} from 'src/app/services/user-profile.service';
import { LoginpageComponent } from '../loginpage/loginpage.component';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
@Input() user:any = null;






  constructor(private ls:LoginService, private ups:UserProfileService) { }

  ngOnInit(): void {
    this.user=this.ls.user2;
    console.log(this.user)
  }
  update():void{
    this.ups.updateProfile(this.user.id, this.user.address, this.user.email, this.user.firstname,
      this.user.lastname, this.user.phonenumber).subscribe(
        
      )
  }
}
