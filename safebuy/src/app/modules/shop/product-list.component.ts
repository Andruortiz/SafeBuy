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
    {
      id: 1,
      name: 'Computador AsusROG',
      price: 2499000,
      image: 'https://m.media-amazon.com/images/I/71tYh2Hz+HL._AC_SL1500_.jpg'
    },
    {
      id: 2,
      name: 'Celular Samsung Galaxy zFlip',
      price: 4639000,
      image: 'https://m.media-amazon.com/images/I/71pT7xjRz-L._AC_SL1500_.jpg'
    },
    {
      id: 3,
      name: 'Silla de escritorio Ejecutiva',
      price: 304900,
      image: 'https://m.media-amazon.com/images/I/61N9z4lKSDL._AC_SL1500_.jpg'
    },
    {
      id: 4,
      name: 'iPhone 15',
      price: 6299000,
      image: 'https://m.media-amazon.com/images/I/81CgtwSII3L._AC_SL1500_.jpg'
    },
    {
      id: 5,
      name: 'Computador Lenovo Legion',
      price: 4259000,
      image: 'https://m.media-amazon.com/images/I/61Tj5pKVVcL._AC_SL1500_.jpg'
    }
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
