import {Component, OnInit} from '@angular/core';
import {Condition} from '../models/condition';
import {City} from '../models/city';
import {Http} from '@angular/http';
import {Router} from '@angular/router';
import {ActivityCreationService} from './activity-creation.service';

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
  protected conditions: String[];

  constructor(private http: Http, private router: Router, private actcreaservice: ActivityCreationService) { }

  ngOnInit() {
    const n_u = JSON.parse(localStorage.getItem('currentUser')).id;
    if (this.user_id !== n_u) {
      this.user_id = n_u;
    }
    // this.actcreaservice.getCities().then(
    //   response => {
    //     this.cities = JSON.parse(response.text());
    //   }
    // );
    // this.cities = [{id: 1, city: 'test'}, {id: 2, city: 'test2'}];
    // this.actcreaservice.getCondition().then(
    //   response => {
    //     this.conditions = JSON.parse(response.text());
    //   }
    // );
    this.conditions = ['essai', 'essai2'];
  }

  create() {
    const activity = {
      id: this.user_id,
      name: this.name,
      city_id: this.city_id,
      condition: this.condition
    };
    this.actcreaservice.create(activity).then(_ => {
        this.router.navigate(['/activity']);
    });
  }

}
