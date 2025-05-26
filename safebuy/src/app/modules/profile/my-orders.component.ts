import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-my-orders',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './my-orders.component.html',
  styleUrls: ['./my-orders.component.scss']
})
export class MyOrdersComponent {
  compras = [
    {
      id: 1,
      producto: 'Mouse inalámbrico',
      fecha: '2025-05-20',
      estado: 'En camino',
      verificado: false
    },
    {
      id: 2,
      producto: 'Teclado mecánico',
      fecha: '2025-05-18',
      estado: 'Entregado',
      verificado: true
    }
  ];

  verificar(compraId: number) {
    const compra = this.compras.find(c => c.id === compraId);
    if (compra) {
      compra.verificado = true;
    }
  }
}
