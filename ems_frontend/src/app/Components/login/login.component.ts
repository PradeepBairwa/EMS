import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginData={
    username:'',
    password:''
  }

  constructor(private snack:MatSnackBar,private login:LoginService,private router:Router) { }

  ngOnInit(): void {

   
  }
  formSubmit(){
   
    console.log("LoginData :"+this.loginData)
    this.login.generateToken(this.loginData).subscribe(
      (data:any)=>{
        console.log("success");
        console.log(data);
        this.login.loginUser(data.token);
        this.router.navigate(['emp']);
        this.login.loginStatusSubject.next(true);
      },(error)=>{
        console.log("Error");
        console.log(error);
      }
    )
  }
  // reset(){
  //   this.loginData={
  //     username:'',
  //     password:''
  //   }
  // }

 
  

}
