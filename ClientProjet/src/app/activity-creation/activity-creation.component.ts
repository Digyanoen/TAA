import {Component, OnInit} from '@angular/core';
import {Condition} from '../models/condition';
import {City} from '../models/city';
import {Http} from '@angular/http';
import {Router} from "@angular/router";

@Component({
  selector: 'app-activity-creation',
  templateUrl: './activity-creation.component.html',
  styleUrls: ['./activity-creation.component.css']
})
export class ActivityCreationComponent implements OnInit {
  private headers = new Headers({
    'Content-Type': 'application/json'
  });

  private user_id: number;

  protected name: string;
  protected city_id: number;
  protected condition: Condition;

  protected cities: City[];

  constructor(private http: Http, private router: Router) { }

  ngOnInit() {
    const n_u = JSON.parse(localStorage.getItem('currentUser')).id;
    if (this.user_id !== n_u) {
      this.user_id = n_u;
    }
  }

  create() {
    const activity = {
      id: this.user_id,
      name: this.name,
      city_id: this.city_id,
      condition: this.condition
    };
    this.http.post('http://localhost:4200/api/activity/create', activity, this.headers)
      .toPromise().then(_ => {
        this.router.navigate(['/activity']);
    });
  }

}
