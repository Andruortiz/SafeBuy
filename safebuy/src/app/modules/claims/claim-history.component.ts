import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-claim-history',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './claim-history.component.html',
  styleUrls: ['./claim-history.component.scss']
})
export class ClaimHistoryComponent {
  userClaims = [
    {
      id: 1,
      reason: 'No me ha llegado el producto',
      description: 'Llevo esperando 2 semanas y no ha llegado.',
      status: 'no revisado',
      product: 'Producto A',
      date: '2024-05-10'
    },
    {
      id: 2,
      reason: 'El producto no es el que compré',
      description: 'Me enviaron un producto totalmente diferente.',
      status: 'revisado',
      product: 'Producto B',
      date: '2024-05-15'
    }
  ];
}
