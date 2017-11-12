import { Injectable } from '@angular/core';
import {Http} from '@angular/http';
import {AuthService} from '../app-routing/auth.service';

@Injectable()
export class ActivityService {

  private static handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    // return Promise.reject(error.message || error);
    return Promise.resolve([{
      id: 1,
      name: 'basketball',
      city: 'rennes',
      condition: [{name: 'pluie', strength: 0}]
    },
      {
        id: 2,
        name: 'baseball',
        city: 'rennes',
        condition: [{name: 'vent', strength: 15}]
      }]);
  }

  constructor(public http: Http) { }

  getActivities(user_id) {
    return this.http.get('http://localhost:4200/activity/list' + user_id)
      .toPromise()
      .catch(ActivityService.handleError);
  }


}
