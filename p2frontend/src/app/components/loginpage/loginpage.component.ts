import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { Subscriber, Subscription } from 'rxjs';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-loginpage',
  templateUrl: './loginpage.component.html',
  styleUrls: ['./loginpage.component.css']
})
export class LoginpageComponent implements OnInit {
  public user:any=null;
  usernameinput:String="";
  passwordinput:String="";
  subscription:Subscription=new Subscription;
  htmltoadd: string | undefined;

  constructor(private ls:LoginService,private router:Router) { }
  
  ngOnInit(): void {
  }
  login():void{
    this.ls.sendlogin(this.usernameinput,this.passwordinput).subscribe(

      (data:any)=>{
        console.log(data)
        console.log(data.address)
        this.user=data;
        console.log(this.user)
        this.router.navigate(["/account"]);
        this.ls.user2=data;
      },
      ()=>{
        this.user=null;
        console.log("failed")
        this.htmltoadd='<div class="form-outline form-white mb-4">login failed</div>'
      }

    )
  }

}
