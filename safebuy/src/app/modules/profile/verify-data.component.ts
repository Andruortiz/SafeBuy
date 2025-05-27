import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-verify-data',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './verify-data.component.html',
  styleUrls: ['./verify-data.component.scss']
})
export class VerifyDataComponent {
  email = '';
  dni = '';
  phone = '';
  verified = false;
  submitted = false;

  verify() {
    this.submitted = true;

    const emailValid = /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(this.email);
    const dniValid = /^\d{6,12}$/.test(this.dni); // Por ejemplo: 6 a 12 dígitos
    const phoneValid = /^\d{10}$/.test(this.phone); // Ejemplo: 10 dígitos para CO

    this.verified = emailValid && dniValid && phoneValid;
  }
}
