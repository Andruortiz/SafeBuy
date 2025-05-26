import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home.component';
import { LoginComponent } from './modules/auth/login.component';
import { RegisterComponent } from './modules/auth/register.component';
import { ProfileComponent } from './modules/profile/profile.component';
import { ProductListComponent } from './modules/shop/product-list.component'; // ✅ Corrección aquí
import { MyOrdersComponent } from './modules/profile/my-orders.component';
import { AddressesComponent } from './modules/profile/addresses.component';
import { PaymentMethodsComponent } from './modules/profile/payment-methods.component';
import { MyProductsComponent } from './modules/products/my-products.component';

export const routes: Routes = [
  { path: '', component: ProductListComponent },
  { path: 'auth/login', component: LoginComponent },
  { path: 'auth/register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'shop/products', component: ProductListComponent },
  { path: 'profile/orders', component: MyOrdersComponent },
  { path: 'profile/addresses', component: AddressesComponent },
  { path: 'profile/payments', component: PaymentMethodsComponent },
  { path: 'products/my-products', component: MyProductsComponent },
];
