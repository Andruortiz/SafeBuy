import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service';

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

  constructor(private router: Router, private auth: AuthService) {}

  login() {
    if (!this.email || !this.password) {
      this.errorMessage = 'Todos los campos son obligatorios';
      return;
    }

    if (this.email === 'admin@demo.com' && this.password === '1234') {
      this.auth.login(this.email);
      this.router.navigateByUrl('/');
    } else {
      this.errorMessage = 'Credenciales incorrectas';
    }
  }
}
