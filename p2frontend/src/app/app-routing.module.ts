import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountpageComponent } from './components/accountpage/accountpage.component';
import { LoginpageComponent } from './components/loginpage/loginpage.component';

const routes: Routes = [
  {
    path:"",
    component:LoginpageComponent
  },
  {
    path:"account",
    component:AccountpageComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
