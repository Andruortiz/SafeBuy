import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  {
    path: 'auth',
    loadChildren: () =>
      import('./modules/auth/auth.routes').then((m) => m.AUTH_ROUTES),
  },
  {
    path: 'shop',
    loadChildren: () =>
      import('./modules/shop/shop.routes').then((m) => m.SHOP_ROUTES),
  },
  {
    path: 'profile',
    loadChildren: () =>
      import('./modules/profile/profile.routes').then((m) => m.PROFILE_ROUTES),
  },
  {
    path: 'products',
    loadChildren: () =>
      import('./modules/products/products.routes').then((m) => m.PRODUCT_ROUTES),
  },
  {
    path: 'claims',
    loadChildren: () =>
      import('./modules/claims/claims.routes').then((m) => m.CLAIM_ROUTES),
  },
];
