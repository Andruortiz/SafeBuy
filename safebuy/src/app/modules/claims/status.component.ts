import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-status',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './status.component.html',
  styleUrl: './status.component.scss'
})
export class StatusComponent {
  claims = [
    {
      buyer: {
        name: 'Juan Pérez',
        email: 'juan.perez@example.com',
        phone: '+57 321 456 7890'
      },
      product: 'Auriculares inalámbricos',
      date: '2024-05-10',
      state: 'Revisado'
    },
    {
      buyer: {
        name: 'Laura Gómez',
        email: 'laura.gomez@example.com',
        phone: '+57 310 222 3344'
      },
      product: 'Teclado mecánico',
      date: '2024-05-08',
      state: 'No revisado'
    },
    {
      buyer: {
        name: 'Carlos Ramírez',
        email: 'carlos.ramirez@example.com',
        phone: '+57 301 123 4567'
      },
      product: 'Mouse gamer RGB',
      date: '2024-05-05',
      state: 'Solucionado'
    }
  ];
}
