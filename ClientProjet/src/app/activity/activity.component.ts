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
    const n_u = JSON.parse(localStorage.getItem('currentUser')).id;
    if (this.user_id !== n_u) {
      this.user_id = n_u;
      this.activityservice.getActivities(this.user_id).then(
        response => {
          console.warn(response.text());
          this.activities = JSON.parse(response.text());
        }
      );
    }
  }

  deleteActivity(id: number, idx: number) {
    this.activityservice.deleteActivity(id).then(_ => {
        this.activities = this.activities.slice(0, idx).concat( this.activities.slice(idx + 1, this.activities.length));
      }
    );
  }
}
