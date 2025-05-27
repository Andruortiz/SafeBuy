import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Router } from '@angular/router';

@Component({
  selector: 'app-my-orders',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './my-orders.component.html',
  styleUrls: ['./my-orders.component.scss']
})
export class MyOrdersComponent {
  orders = [
    {
      id: 1,
      product: 'Producto A',
      date: '2024-05-10',
      status: 'En camino',
      verified: false
    },
    {
      id: 2,
      product: 'Producto B',
      date: '2024-05-05',
      status: 'Entregado',
      verified: true
    }
  ];

  constructor(private router: Router) {}

  verifyOrder(order: any) {
    order.verified = true;
    alert(`Compra de ${order.product} verificada.`);
  }

  makeClaim(orderId: number) {
    this.router.navigate(['/claims/create'], { queryParams: { orderId } });
  }
}
