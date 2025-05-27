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

  constructor(
    private route: ActivatedRoute,
    private router: Router
  ) {
    const productId = Number(this.route.snapshot.paramMap.get('id'));

    // Simulación local: reemplazar por fetch del backend en el futuro
    const mockProducts = [
      { id: 1, title: 'Producto 1', price: 100, image: 'assets/product1.jpg', description: 'Descripción del producto 1', quantity: 5 },
      { id: 2, title: 'Producto 2', price: 200, image: 'assets/product2.jpg', description: 'Descripción del producto 2', quantity: 3 },
    ];

    this.product = mockProducts.find(p => p.id === productId);
  }

  goToCheckout() {
    this.router.navigate(['/shop/checkout'], {
      queryParams: { productId: this.product.id }
    });
  }

}
