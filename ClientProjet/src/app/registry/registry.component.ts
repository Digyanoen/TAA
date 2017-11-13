import { Component, OnInit } from '@angular/core';
import {AuthService} from "../app-routing/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-registry',
  templateUrl: './registry.component.html',
  styleUrls: ['./registry.component.css']
})
export class RegistryComponent implements OnInit {

  login: string;
  password: string;
  mail: string;

  constructor(public authservice: AuthService, public router: Router) { }

  ngOnInit() {
  }

  signup() {
    this.authservice.signup(this.login, this.password, this.mail).then(
      response => {
        this.router.navigate(['/login']);
      }
    );
  }

}
