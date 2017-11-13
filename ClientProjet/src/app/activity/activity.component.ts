import { Component, OnInit } from '@angular/core';
import {ActivityService} from './activity.service';
import {Activity} from '../models/activity';

@Component({
  selector: 'app-home',
  templateUrl: './activity.component.html',
  styleUrls: ['./activity.component.css']
})
export class ActivityComponent implements OnInit {

  private user_id = 0;
  protected activities: Activity[] = [];

  constructor(public activityservice: ActivityService) { }

  ngOnInit() {
    console.error(localStorage.getItem('currentUser'));
    const n_u = JSON.parse(localStorage.getItem('currentUser')).id;
    if (this.user_id !== n_u) {
      this.user_id = n_u;
      this.activityservice.getActivities(this.user_id).then(
        response => {
          this.activities = response;
          console.warn(this.activities);
        }
      );
    }
  }

  deleteActivity(id: Number) {
    this.activityservice.deleteActivity(id);
  }
}
