import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { RouterModule } from '@angular/router';//

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  // Permite usar [(ngModel)] y *ngIf
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  // Datos del formulario
  email = '';
  password = '';
  selectedRole: 'comprador' | 'vendedor' | null = null; // Rol seleccionado
  errorMessage = ''; // Para mostrar errores en pantalla

  constructor(private router: Router, private auth: AuthService) {}

  login() {
    // Validación: todos los campos deben estar completos
    if (!this.email || !this.password || !this.selectedRole) {
      this.errorMessage = 'Todos los campos y el rol son obligatorios';
      return;
    }

    // Simulación de credenciales válidas
    const validCreds =
      (this.email === 'cliente@demo.com' && this.password === '1234' && this.selectedRole === 'comprador') ||
      (this.email === 'vendedor@demo.com' && this.password === '1234' && this.selectedRole === 'vendedor');

    if (validCreds) {
      // Guardamos usuario y rol usando el AuthService
      this.auth.login(this.email, this.selectedRole);
      this.router.navigateByUrl('/'); // Redireccionamos al inicio
    } else {
      this.errorMessage = 'Credenciales o rol incorrectos';
    }
  }
}

