import { Routes } from '@angular/router';
import { ProfileComponent } from './profile.component';
import { VerifyDataComponent } from './verify-data.component';
import { AddressesComponent } from './addresses.component';
import { PaymentMethodsComponent } from './payment-methods.component';
import { MyOrdersComponent } from './my-orders.component'; // 👈 Asegúrate de importar esto

export const PROFILE_ROUTES: Routes = [
  { path: '', component: ProfileComponent },
  { path: 'verify', component: VerifyDataComponent },
  { path: 'addresses', component: AddressesComponent },
  { path: 'payments', component: PaymentMethodsComponent },
  { path: 'orders', component: MyOrdersComponent } // ✅ Ruta para "Ver mis compras"
];
