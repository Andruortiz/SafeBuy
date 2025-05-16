import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  email = '';
  password = '';
  errorMessage = '';

  constructor(private router: Router) {}

  login() {
    if (!this.email || !this.password) {
      this.errorMessage = 'Todos los campos son obligatorios';
      return;
    }

    // simulación: login exitoso si email = admin@demo.com y password = 1234
    if (this.email === 'admin@demo.com' && this.password === '1234') {
      localStorage.setItem('user', this.email);
      this.router.navigateByUrl('/');
    } else {
      this.errorMessage = 'Credenciales incorrectas';
    }
  }
}
