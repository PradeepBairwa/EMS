import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  isLoggedIn=false;
  constructor(private login:LoginService) { }

  ngOnInit(): void {
       this.isLoggedIn=this.login.isLoggedIn();

  }

  public logout(){
      this.login.logOut();
      // window.location.reload();
  }

}
