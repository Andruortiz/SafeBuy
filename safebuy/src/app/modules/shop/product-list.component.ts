import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-product-list',
  standalone: true,
  imports: [CommonModule, RouterModule, FormsModule],
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent {
  searchTerm = '';

  products = [
    { id: 1, name: 'Producto 1', price: 100, image: 'https://via.placeholder.com/150' },
    { id: 2, name: 'Producto 2', price: 150, image: 'https://via.placeholder.com/150' },
    { id: 3, name: 'Producto 3', price: 200, image: 'https://via.placeholder.com/150' },
    { id: 4, name: 'Producto 4', price: 250, image: 'https://via.placeholder.com/150' },
    { id: 5, name: 'Producto 5', price: 300, image: 'https://via.placeholder.com/150' },
    { id: 6, name: 'Producto 6', price: 350, image: 'https://via.placeholder.com/150' },
  ];

  constructor(public auth: AuthService, private router: Router) {}

  get filteredProducts() {
    return this.products.filter(p =>
      p.name.toLowerCase().includes(this.searchTerm.toLowerCase())
    );
  }

  goToLogin() {
    this.router.navigateByUrl('/auth/login');
  }

  goToProfile() {
    this.router.navigateByUrl('/profile');
  }
}
