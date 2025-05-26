import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home.component';
import { LoginComponent } from './modules/auth/login.component';
import { RegisterComponent } from './modules/auth/register.component';
import { ProfileComponent } from './modules/profile/profile.component';
import { ProductListComponent } from './modules/shop/product-list.component'; // ✅ Corrección aquí

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'auth/login', component: LoginComponent },
  { path: 'auth/register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'shop/products', component: ProductListComponent } // ✅ Ruta funcional
];
