import { Routes } from '@angular/router';
import { LoginComponent } from './modules/auth/login.component';
import { RegisterComponent } from './modules/auth/register.component';
import { ProfileComponent } from './modules/profile/profile.component';
import { ProductListComponent } from './modules/shop/product-list.component'; // ✅ Corrección aquí
import { MyOrdersComponent } from './modules/profile/my-orders.component';
import { AddressesComponent } from './modules/profile/addresses.component';
import { PaymentMethodsComponent } from './modules/profile/payment-methods.component';
import { MyProductsComponent } from './modules/products/my-products.component';
import { AddComponent } from './modules/products/add.component';
import { VerifyDataComponent } from './modules/profile/verify-data.component';
import { StatusComponent } from './modules/claims/status.component';
import { ProductDetailComponent } from './modules/shop/product-detail.component';
import { CheckoutComponent } from './modules/shop/checkout.component';
import { CreateComponent } from './modules/claims/create.component';
import { MyClaimsComponent } from './modules/claims/my-claims.component';
import { ClaimHistoryComponent } from './modules/claims/claim-history.component';



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
  { path: 'products/add', component: AddComponent },
  { path: 'profile/verify', component: VerifyDataComponent },
  { path: 'claims/status', component: StatusComponent },
  { path: 'product/:id', component: ProductDetailComponent },
  { path: 'shop/checkout', component: CheckoutComponent },
  { path: 'claims/create', component: CreateComponent },
  { path: 'profile/my-claims', component: MyClaimsComponent },
  { path: 'claims/history', component: ClaimHistoryComponent },
];

