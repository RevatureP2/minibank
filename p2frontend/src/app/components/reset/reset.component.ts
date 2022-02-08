import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-reset',
  templateUrl: './reset.component.html',
  styleUrls: ['./reset.component.css']
})
export class ResetComponent implements OnInit {
  useremail:string="";
  password:string="";
  htmltoadd: string | undefined;
  constructor(private ls:LoginService) { }

  ngOnInit(): void {
  }
  reset():void{
    console.log(this.useremail);
    this.ls.reset(this.useremail).subscribe(
      (data:any)=>{
        console.log(data)
        this.password=data;
        console.log(this.password)
        if(this.password===null){
          this.htmltoadd='<div class="form-outline form-white mb-4" style="color: white;">reset failed, please enter correct email</div>'
        }
        else{
          this.htmltoadd='<div class="form-outline form-white mb-4" style="color: white;">Your new password is: password</div>'
        }
      }
      
    )
  }
}
