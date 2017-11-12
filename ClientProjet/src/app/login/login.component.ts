import {Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../app-routing/auth.service';

@Component({
  templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {
  pseudo: string;
  password: string;

  constructor( public authService: AuthService, public router: Router) {
  }

  ngOnInit() {
    // reset login status
    this.authService.logout();

    // get return url from route parameters or default to '/'
    this.authService.redirectUrl = '/';
  }

  login() {

    this.authService.login(this.pseudo, this.password)
      .then(response => {
        // login successful if there's a jwt token in the response
        console.warn('reponse is : ' + JSON.parse(response.text()));
        const user = response.text();
        if (user) {
          // store user details and jwt token in local storage to keep user logged in between page refreshes
          localStorage.setItem('currentUser', user);
          this.authService.isLoggedIn = true;
        }
        const redirect: string = this.authService.redirectUrl ? this.authService.redirectUrl : '/activity';

        // Redirect the user
        this.router.navigate([redirect]);
      });
  }
}
