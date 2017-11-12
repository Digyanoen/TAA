import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { ActivityCreationComponent } from './activity-creation/activity-creation.component';
import { ActivityComponent } from './activity/activity.component';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { ActivityService } from './activity/activity.service';
import { LoginRoutingModule } from './login/login-routing.module';
import { RegistryComponent } from './registry/registry.component';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ActivityCreationComponent,
    ActivityComponent,
    RegistryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    LoginRoutingModule,
    FormsModule,
    HttpModule
  ],
  providers: [ActivityService],
  bootstrap: [AppComponent]
})
export class AppModule { }
