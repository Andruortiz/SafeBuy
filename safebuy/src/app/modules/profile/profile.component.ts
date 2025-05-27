import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Router } from '@angular/router';
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

  constructor(private auth: AuthService, private router: Router) {
    this.userEmail = this.auth.getUser();
    this.role = this.auth.getRole();
  }

  goTo(path: string) {
    this.router.navigateByUrl('/' + path);
  }

  logout() {
    this.auth.logout();
    window.location.href = '/'; // también puedes usar this.router.navigateByUrl('/')
  }
}
