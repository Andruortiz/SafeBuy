import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-addresses',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './addresses.component.html',
  styleUrls: ['./addresses.component.scss']
})
export class AddressesComponent {
  addresses: string[] = ['Calle 123', 'Carrera 45', 'Av. Siempre Viva 742'];
  newAddress: string = '';

  addAddress() {
    if (this.newAddress.trim()) {
      this.addresses.push(this.newAddress.trim());
      this.newAddress = '';
    }
  }

  deleteAddress(index: number) {
    this.addresses.splice(index, 1);
  }
}
