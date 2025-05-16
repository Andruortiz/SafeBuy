import { Routes } from '@angular/router';
import { CreateComponent } from './create.component';
import { StatusComponent } from './status.component';

export const CLAIM_ROUTES: Routes = [
  { path: 'create', component: CreateComponent },
  { path: 'status', component: StatusComponent }
];
