import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root' // 👈 Esto hace que el servicio esté disponible globalmente
})
export class AuthService {
  login(email: string, role: string) {
    localStorage.setItem('user', email);
    localStorage.setItem('role', role);
  }

  logout() {
    localStorage.removeItem('user');
    localStorage.removeItem('role');
  }

  isAuthenticated(): boolean {
    // Solo retorna true si 'user' y 'role' existen y no están vacíos
    const user = localStorage.getItem('user');
    const role = localStorage.getItem('role');
    return !!user && !!role;
  }

  getRole(): string | null {
    return localStorage.getItem('role');
  }

  getUser(): string | null {
    return localStorage.getItem('user');
  }
}
