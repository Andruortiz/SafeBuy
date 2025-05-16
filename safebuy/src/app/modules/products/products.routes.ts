import { Routes } from '@angular/router';
import { AddComponent } from './add.component';
import { EditComponent } from './edit.component';
import { DeleteComponent } from './delete.component';
import { MyProductsComponent } from './my-products.component';

export const PRODUCT_ROUTES: Routes = [
  { path: 'add', component: AddComponent },
  { path: 'edit/:id', component: EditComponent },
  { path: 'delete/:id', component: DeleteComponent },
  { path: 'my-products', component: MyProductsComponent }
];
