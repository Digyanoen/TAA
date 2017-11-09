import { Injectable } from '@angular/core';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/delay';
import {Http} from '@angular/http';
import 'rxjs/add/operator/toPromise';
@Injectable()
export class AuthService {
  isLoggedIn = false;
  private headers = new Headers({
    'Content-Type': 'application/json'
  });

  // store the URL so we can redirect after logging in
  redirectUrl: string;

  private static handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

  constructor(private http: Http) {
  }

  login(login: string, password: string, email: string) {
    console.warn(JSON.stringify({'id': 1, login, password, email}));
    this.http.post('http://localhost:4200/user/create', {'id': 1, login, password, email}, this.headers)
      .toPromise()
      .then(response => {
        console.warn('YEAAHHH');
        // login successful if there's a jwt token in the response
        // const user = response.json();
        // if (user && user.token) {
          // store user details and jwt token in local storage to keep user logged in between page refreshes
          // localStorage.setItem('currentUser', JSON.stringify(user));
          // this.isLoggedIn = true;
        // }
      })
      .catch(AuthService.handleError);
    return Observable.of(true).delay(1000).do(val => this.isLoggedIn = true);
  }

  logout(): void {
    localStorage.removeItem('currentUser');
    this.isLoggedIn = false;
  }
}
