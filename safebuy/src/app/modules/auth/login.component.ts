import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  email = '';
  password = '';
  selectedRole: 'comprador' | 'vendedor' | null = null;
  errorMessage = '';

  constructor(private router: Router, private auth: AuthService) {}

  login() {
    if (!this.email || !this.password || !this.selectedRole) {
      this.errorMessage = 'Todos los campos y el rol son obligatorios';
      return;
    }

    const users = JSON.parse(localStorage.getItem('users') || '[]');
    const matchedUser = users.find(
      (user: any) =>
        user.email === this.email &&
        user.password === this.password &&
        user.role === this.selectedRole
    );

    if (matchedUser) {
      this.auth.login(matchedUser.email, matchedUser.role);
      this.router.navigateByUrl('/');
    } else {
      this.errorMessage = 'Credenciales o rol incorrectos';
    }
  }
}
