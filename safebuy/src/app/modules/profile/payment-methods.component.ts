import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-payment-methods',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './payment-methods.component.html',
  styleUrls: ['./payment-methods.component.scss']
})
export class PaymentMethodsComponent {
  newPayment = {
    cardNumber: '',
    ownerName: '',
    expirationDate: '',
    cvv: ''
  };

  payments: any[] = [];

  addPayment() {
    if (this.isFormValid()) {
      this.payments.push({...this.newPayment});
      this.resetForm();
    }
  }

  deletePayment(index: number) {
    this.payments.splice(index, 1);
  }

  resetForm() {
    this.newPayment = {
      cardNumber: '',
      ownerName: '',
      expirationDate: '',
      cvv: ''
    };
  }

  isFormValid(): boolean {
    return (
      this.newPayment.cardNumber.trim().length > 0 &&
      this.newPayment.ownerName.trim().length > 0 &&
      this.newPayment.expirationDate.trim().length > 0 &&
      this.newPayment.cvv.trim().length > 0
    );
  }
}
