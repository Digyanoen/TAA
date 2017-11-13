import { Injectable } from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class ActivityCreationService {
  private headers = new Headers({
    'Content-Type': 'application/json'
  });

  private static handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.resolve({id: 1, login: 'test'}); // Promise.reject(error.message || error);
  }

  constructor(private http: Http) { }

  getCities() {
    return this.http.get('http://localhost:4200/api/city')
      .toPromise()
      .catch(ActivityCreationService.handleError);
  }

  getCondition() {
    return this.http.get('http://localhost:4200/api/weather-condition')
      .toPromise()
      .catch(ActivityCreationService.handleError);
  }

  create(act) {
    return this.http.post('http://localhost:4200/api/activity/create', act, this.headers)
      .toPromise();
  }

}
