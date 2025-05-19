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
  fullName = '';
  idNumber = '';
  phone = '';
  verified = false;
  submitted = false;

  verify() {
    if (this.fullName && this.idNumber && this.phone) {
      this.verified = true;
    }
    this.submitted = true;
  }
}
