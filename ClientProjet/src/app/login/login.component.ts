import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../app-routing/auth.service';

@Component({
  template: `
    <h2>LOGIN</h2>
    <p>{{message}}</p>
    <p>
      <button (click)="login()"  *ngIf="!authService.isLoggedIn">Login</button>
      <button (click)="logout()" *ngIf="authService.isLoggedIn">Logout</button>
    </p>`
})
export class LoginComponent {
  message: string;
  pseudo: string;
  mdp: string;

  constructor( public authService: AuthService, public router: Router) {
    this.setMessage();
  }

  setMessage() {
    this.message = 'Logged ' + (this.authService.isLoggedIn ? 'in' : 'out');
  }

  login() {
    this.message = 'Trying to log in ...';

    this.pseudo = 'loul';
    this.mdp = '0000';

    this.authService.login(this.pseudo, this.mdp, 'test');
  }

  logout() {
    this.authService.logout();
    this.setMessage();
  }
}
