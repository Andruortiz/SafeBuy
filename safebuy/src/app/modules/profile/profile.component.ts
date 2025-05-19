import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent {
  userEmail: string | null = null;
  role: string | null = null;

  constructor(private auth: AuthService) {
    this.userEmail = this.auth.getUser();
    this.role = this.auth.getRole();
  }

  // ✅ Este método debe estar DENTRO de la clase
  logout() {
    this.auth.logout();
    window.location.href = '/'; // o usa Router si prefieres navegar sin recargar
  }
}
