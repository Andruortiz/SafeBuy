import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
  name = '';
  email = '';
  password = '';
  role: 'comprador' | 'vendedor' | null = null;
  errorMessage = '';
  successMessage = '';

  constructor(private router: Router) {}

  register() {
    if (!this.name || !this.email || !this.password || !this.role) {
      this.errorMessage = 'Todos los campos son obligatorios.';
      return;
    }

    const newUser = {
      name: this.name,
      email: this.email,
      password: this.password,
      role: this.role
    };

    const users = JSON.parse(localStorage.getItem('users') || '[]');
    users.push(newUser);
    localStorage.setItem('users', JSON.stringify(users));

    this.successMessage = 'Registro exitoso. Ahora puedes iniciar sesión.';
    this.errorMessage = '';

    this.name = '';
    this.email = '';
    this.password = '';
    this.role = null;

    setTimeout(() => this.router.navigateByUrl('/auth/login'), 1500);
  }
}
