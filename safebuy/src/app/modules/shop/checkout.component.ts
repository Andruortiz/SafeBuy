import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-checkout',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.scss']
})
export class CheckoutComponent {
  selectedOption = 'saved';

  savedPayments = [
    { cardNumber: '**** **** **** 1234', owner: 'Juan Pérez', expirationDate: '12/25' },
    { cardNumber: '**** **** **** 5678', owner: 'Ana López', expirationDate: '01/26' }
  ];

  newPayment = {
    cardNumber: '',
    ownerName: '',
    expirationDate: '',
    cvv: ''
  };
  isFormValid(): boolean {
    return (
      !!this.newPayment.cardNumber.trim() &&
      !!this.newPayment.ownerName.trim() &&
      !!this.newPayment.expirationDate.trim() &&
      !!this.newPayment.cvv.trim()
    );
  }

  confirmarCompra() {
    alert('Compra confirmada correctamente.');
  }
}
