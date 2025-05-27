import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-my-claims',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './my-claims.component.html',
  styleUrls: ['./my-claims.component.scss']
})
export class MyClaimsComponent {
  myClaims = [
    {
      id: 1,
      order: 'Producto A',
      reason: 'No me ha llegado el producto',
      status: 'No revisado',
      description: 'Hice la compra hace una semana y aún no llega'
    },
    {
      id: 2,
      order: 'Producto B',
      reason: 'El producto me llegó en mal estado',
      status: 'Solucionado',
      description: 'Estaba roto al recibirlo'
    }
  ];
}
