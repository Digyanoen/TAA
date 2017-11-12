import { Injectable } from '@angular/core';

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
    return Promise.resolve({id: 1, login: 'test'}); // Promise.reject(error.message || error);
  }

  constructor(private http: Http) {
  }

  login(login: string, password: string) {
    // console.warn(JSON.stringify({login, password}));
    return this.http.post('http://localhost:4200/api/user/create', {login, password}, this.headers)
      .toPromise()
      .catch(AuthService.handleError);
  }

  logout(): void {
    localStorage.removeItem('currentUser');
    this.isLoggedIn = false;
  }
}
