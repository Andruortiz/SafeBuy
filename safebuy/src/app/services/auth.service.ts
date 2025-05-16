import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private readonly KEY = 'user';

  login(email: string) {
    localStorage.setItem(this.KEY, email);
  }

  logout() {
    localStorage.removeItem(this.KEY);
  }

  isAuthenticated(): boolean {
    return localStorage.getItem(this.KEY) !== null;
  }

  getUser(): string | null {
    return localStorage.getItem(this.KEY);
  }
}
