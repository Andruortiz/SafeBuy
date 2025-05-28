import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-my-products',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './my-products.component.html',
  styleUrls: ['./my-products.component.scss'],
})
export class MyProductsComponent implements OnInit {
  userEmail: string | null = '';
  myProducts: any[] = [];

  ngOnInit(): void {
    this.userEmail = localStorage.getItem('user');
    this.loadProducts();
  }

  loadProducts(): void {
    const products = JSON.parse(localStorage.getItem('products') || '[]');
    this.myProducts = products.filter((p: any) => p.sellerEmail === this.userEmail);
  }

  deleteProduct(product: any): void {
    const confirmDelete = confirm(`¿Eliminar el producto "${product.title}"?`);
    if (confirmDelete) {
      let allProducts = JSON.parse(localStorage.getItem('products') || '[]');
      allProducts = allProducts.filter((p: any) => !(p.title === product.title && p.sellerEmail === this.userEmail));
      localStorage.setItem('products', JSON.stringify(allProducts));
      this.loadProducts(); // Recargar productos
    }
  }

  editProduct(product: any): void {
    alert('Funcionalidad de edición aún no implementada 🛠️');
  }
}
