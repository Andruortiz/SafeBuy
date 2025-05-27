import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-create-claim',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss']
})
export class CreateComponent {
  orderId: number | null = null;
  reason: string = '';
  description: string = '';
  reasons = [
    'No me ha llegado el producto',
    'El producto me llegó en mal estado',
    'El producto no es el que compré',
    'Alguna de sus características es incorrecta'
  ];

  constructor(private route: ActivatedRoute) {
    this.route.queryParams.subscribe(params => {
      this.orderId = +params['orderId'] || null;
    });
  }

  submitClaim() {
    if (this.reason && this.description) {
      alert(`✅ Reclamo enviado:\n\nOrden: ${this.orderId}\nMotivo: ${this.reason}\nDescripción: ${this.description}`);
    } else {
      alert('⚠️ Por favor completa todos los campos antes de enviar el reclamo.');
    }
  }
}
