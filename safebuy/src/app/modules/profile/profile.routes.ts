import { Routes } from '@angular/router';
import { VerifyDataComponent } from './verify-data.component';
import { AddressesComponent } from './addresses.component';
import { PaymentMethodsComponent } from './payment-methods.component';
import { MyOrdersComponent } from './my-orders.component';

export const PROFILE_ROUTES: Routes = [
  { path: 'verify', component: VerifyDataComponent },
  { path: 'addresses', component: AddressesComponent },
  { path: 'payments', component: PaymentMethodsComponent },
  { path: 'orders', component: MyOrdersComponent }
];
