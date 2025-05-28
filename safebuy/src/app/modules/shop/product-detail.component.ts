import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-product-detail',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent {
  product: any;

  mockProducts = [
    {
      id: 1,
      title: 'Computador AsusROG',
      price: 2499000,
      image: 'https://via.placeholder.com/150',
      description: 'Portátil de alto rendimiento ideal para gamers.',
      quantity: 5
    },
    {
      id: 2,
      title: 'Celular Samsung Galaxy zFlip',
      price: 4639000,
      image: 'https://via.placeholder.com/150',
      description: 'Teléfono plegable de última generación.',
      quantity: 3
    },
    {
      id: 3,
      title: 'Silla de escritorio Ejecutiva',
      price: 304900,
      image: 'https://via.placeholder.com/150',
      description: 'Silla ergonómica para oficina o estudio.',
      quantity: 8
    },
    {
      id: 4,
      title: 'iPhone 15',
      price: 6299000,
      image: 'https://via.placeholder.com/150',
      description: 'Último modelo de iPhone con cámaras avanzadas.',
      quantity: 4
    },
    {
      id: 5,
      title: 'Computador Lenovo Legion',
      price: 4259000,
      image: 'https://via.placeholder.com/150',
      description: 'Laptop potente para gaming y tareas intensivas.',
      quantity: 6
    }
  ];

  constructor(private route: ActivatedRoute, private router: Router) {
    const productId = Number(this.route.snapshot.paramMap.get('id'));
    this.product = this.mockProducts.find(p => p.id === productId);
  }

  goToCheckout() {
    this.router.navigate(['/shop/checkout'], {
      queryParams: { productId: this.product.id }
    });
  }
}
