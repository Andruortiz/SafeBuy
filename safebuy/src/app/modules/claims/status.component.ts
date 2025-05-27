import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-status',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './status.component.html',
  styleUrls: ['./status.component.scss']
})
export class StatusComponent {
  claims = [
    {
      user: 'migue@gmail.com',
      contact: '+57 3100000000',
      orderId: 1,
      reason: 'El producto no es el que compré',
      status: 'No revisado' // Estado por defecto
    },
    {
      user: 'andres@gmail.com',
      contact: '+57 3111111111',
      orderId: 2,
      reason: 'No me ha llegado el producto',
      status: 'No revisado'
    }
  ];

  updateStatus(claim: any) {
    console.log(`Estado actualizado para orden ${claim.orderId}: ${claim.status}`);
    // Aquí podrías agregar lógica para persistir este cambio en el backend si deseas.
  }
}
