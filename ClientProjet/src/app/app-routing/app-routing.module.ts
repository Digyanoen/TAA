import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {ActivityComponent} from '../activity/activity.component';
import {ActivityCreationComponent} from '../activity-creation/activity-creation.component';

import {AuthGuard} from './auth.guard';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/activity',
    pathMatch: 'full'
  },
  {
    path: 'activity',
    component: ActivityComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'new-activity',
    component: ActivityCreationComponent,
    canActivate: [AuthGuard]
  }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
