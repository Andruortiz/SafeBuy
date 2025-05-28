import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-add',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.scss']
})
export class AddComponent {
  product = {
    title: '',
    description: '',
    price: 0,
    quantity: 0,
    category: '',
    image: '',
    imagePreview: ''
  };

  categories = ['Tecnología', 'Ropa', 'Hogar', 'Juguetes', 'Libros'];

  onImageChange(event: Event): void {
    const input = event.target as HTMLInputElement;
    const file = input.files?.[0];
    if (file) {
      const reader = new FileReader();
      reader.onload = () => {
        this.product.image = reader.result as string;
        this.product.imagePreview = reader.result as string;
      };
      reader.readAsDataURL(file);
    }
  }

  isValidForm(): boolean {
    return (
      this.product.title.trim() !== '' &&
      this.product.description.trim() !== '' &&
      this.product.price > 0 &&
      this.product.quantity > 0 &&
      this.product.category.trim() !== '' &&
      this.product.image !== ''
    );
  }

  addProduct(): void {
    if (this.isValidForm()) {
      const userEmail = localStorage.getItem('user') || '';
      const newProduct = {
        ...this.product,
        sellerEmail: userEmail // ✅ esto lo conecta con "Mis productos"
      };

      const savedProducts = JSON.parse(localStorage.getItem('products') || '[]');
      savedProducts.push(newProduct);
      localStorage.setItem('products', JSON.stringify(savedProducts));

      alert('Producto agregado con éxito');
      this.product = {
        title: '',
        description: '',
        price: 0,
        quantity: 0,
        category: '',
        image: '',
        imagePreview: ''
      };
    }
  }
}
