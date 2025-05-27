import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
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
  product: any;
  quantity: number = 1;

  paymentOption: string = 'saved';
  addressOption: string = 'saved';

  savedPayments = [
    { cardNumber: '1234', ownerName: 'Juan Pérez', expirationDate: '12/25' },
    { cardNumber: '5678', ownerName: 'Ana López', expirationDate: '01/26' }
  ];

  newPayment = {
    cardNumber: '',
    ownerName: '',
    expirationDate: '',
    cvv: ''
  };

  savedAddresses = ['Cra 1 #23-45 Medellín', 'Calle 9 #10-11 Bogotá'];
  selectedAddress = this.savedAddresses[0];
  newAddress = '';

  constructor(private route: ActivatedRoute) {
    const id = Number(this.route.snapshot.queryParamMap.get('productId'));
    const mockProducts = [
      { id: 1, title: 'Producto 1', description: 'Descripción 1', image: 'https://via.placeholder.com/150', price: 100, quantity: 10 },
      { id: 2, title: 'Producto 2', description: 'Descripción 2', image: 'https://via.placeholder.com/150', price: 200, quantity: 5 }
    ];
    this.product = mockProducts.find(p => p.id === id);
  }

  selectPayment(method: any) {
    alert(`Has seleccionado pagar con la tarjeta terminada en ${method.cardNumber}`);
  }

  confirmPurchase() {
    const address = this.addressOption === 'saved' ? this.selectedAddress : this.newAddress;
    alert(`Compra confirmada del producto "${this.product.title}" con cantidad ${this.quantity} y entrega en "${address}"`);
  }

  canPurchase(): boolean {
    const isPaymentValid = this.paymentOption === 'saved' || (
      this.newPayment.cardNumber.trim() &&
      this.newPayment.ownerName.trim() &&
      this.newPayment.expirationDate.trim() &&
      this.newPayment.cvv.trim()
    );

    const isAddressValid = this.addressOption === 'saved' || this.newAddress.trim();
    return !!(this.product && isPaymentValid && isAddressValid && this.quantity > 0);
  }
}
