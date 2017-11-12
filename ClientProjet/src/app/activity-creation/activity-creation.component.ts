import {Component, OnInit} from '@angular/core';
import {Condition} from '../models/condition';
import {City} from "../models/city";

@Component({
  selector: 'app-activity-creation',
  templateUrl: './activity-creation.component.html',
  styleUrls: ['./activity-creation.component.css']
})
export class ActivityCreationComponent implements OnInit {

  protected name: string;
  protected city_id: number;
  protected condition: Condition;

  protected cities: City[];

  constructor() { }

  ngOnInit() {

  }

}
