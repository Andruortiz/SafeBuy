import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-my-products',
  standalone: true,
  templateUrl: './my-products.component.html',
  styleUrls: ['./my-products.component.scss'],
})
export class MyProductsComponent implements OnInit {
  userEmail: string | null = '';
  myProducts: any[] = [];

  ngOnInit(): void {
    this.userEmail = localStorage.getItem('user');
    const products = JSON.parse(localStorage.getItem('products') || '[]');
    this.myProducts = products.filter((p: any) => p.sellerEmail === this.userEmail);
  }
}
