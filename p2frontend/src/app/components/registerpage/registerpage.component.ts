import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { RegisterServiceService } from 'src/app/services/register-service.service';

@Component({
  selector: 'app-registerpage',
  templateUrl: './registerpage.component.html',
  styleUrls: ['./registerpage.component.css']
})
export class RegisterpageComponent implements OnInit {
  public user:any=null;
  usernameinput:String="";
  passwordinput:String="";
  fnameinput:String="";
  lnameinput:String="";
  emailinput:String="";
  repeatpasswordinput:String="";
  subscription:Subscription=new Subscription;
  htmltoadd: string | undefined;
  constructor(private rs:RegisterServiceService,private router:Router) { }

  ngOnInit(): void {
  }
  register():void{
    this.rs.sendregister(this.usernameinput,this.passwordinput,this.fnameinput,this.lnameinput,this.emailinput).subscribe(
      (data:any)=>{
        console.log(data)
        
        this.user=data;
        this.router.navigate([""]);
        

      },
      ()=>{
        this.user=null;
        console.log("failed")
        this.htmltoadd='<div class="text-center text-muted mt-5 mb-0">register failed</div>'
      }
    )
  }
}
