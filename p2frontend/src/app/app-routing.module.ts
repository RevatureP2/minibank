import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountdetailComponent } from './components/accountdetail/accountdetail.component';
import { AccountpageComponent } from './components/accountpage/accountpage.component';
import { LoginpageComponent } from './components/loginpage/loginpage.component';
import { OpenAccountPageComponent } from './components/open-account-page/open-account-page.component';
import { RegisterpageComponent } from './components/registerpage/registerpage.component';
import { ResetComponent } from './components/reset/reset.component';
import { TranspageComponent } from './components/transpage/transpage.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';

const routes: Routes = [
  {
    path:"",
    component:LoginpageComponent
  },
  {
    path:"account",
    component:AccountpageComponent
  },
  {
    path:"transfer",
    component:TranspageComponent
  },
  {
    path:"register",
    component:RegisterpageComponent
  },
  {
    path:"open-new-account",
    component:OpenAccountPageComponent
  },
  {
    path:"user-profile",
    component:UserProfileComponent
  },
  {
    path:"accountdetail",
    component:AccountdetailComponent
  },
  {
    path:"reset",
    component:ResetComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
