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
      {
        id: 1,
        title: 'Computador AsusROG',
        price: 4999000,
        image: 'https://via.placeholder.com/150',
        description: 'Portátil de alto rendimiento ideal para gamers.',
        quantity: 5
      },
      {
        id: 2,
        title: 'Celular Samsung Galaxy zFlip',
        price: 4399000,
        image: 'https://via.placeholder.com/150',
        description: 'Teléfono plegable de última generación.',
        quantity: 3
      },
      {
        id: 3,
        title: 'Silla de escritorio Ejecutiva',
        price: 899000,
        image: 'https://via.placeholder.com/150',
        description: 'Silla ergonómica para oficina o estudio.',
        quantity: 8
      },
      {
        id: 4,
        title: 'iPhone 15',
        price: 6299000,
        image: 'https://via.placeholder.com/150',
        description: 'Último modelo de iPhone con cámaras avanzadas.',
        quantity: 4
      },
      {
        id: 5,
        title: 'Computador Lenovo Legion',
        price: 5799000,
        image: 'https://via.placeholder.com/150',
        description: 'Laptop potente para gaming y tareas intensivas.',
        quantity: 6
      }
    ];

    this.product = mockProducts.find(p => p.id === id);
  }

  get totalPrice(): number {
    return this.product ? this.quantity * this.product.price : 0;
  }

  selectPayment(method: any) {
    alert(`Has seleccionado pagar con la tarjeta terminada en ${method.cardNumber}`);
  }

  confirmPurchase() {
    const address = this.addressOption === 'saved' ? this.selectedAddress : this.newAddress;
    alert(`Compra confirmada del producto "${this.product.title}" x${this.quantity} por $${this.totalPrice.toLocaleString()} a entregar en "${address}"`);
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
