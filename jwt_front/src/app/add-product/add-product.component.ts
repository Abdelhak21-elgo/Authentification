import { Component, OnInit } from '@angular/core';
import { Product } from '../_Model/Product.model';
import { NgForm } from '@angular/forms';
import { ProductService } from '../_Services/product.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  product: Product = {
    productName: "",
    productDescription: "",
    productCurentPrice: 0,
    productDiscountedPrice: 0
  }
  constructor(private productService: ProductService) { }

  ngOnInit(): void {
  }

  addProduct(productForm: NgForm) {
    this.productService.addProduct(this.product).subscribe(
      (response: Product) => {
        productForm.reset();
      },
      (error : HttpErrorResponse) => {
        console.log(error);
      }
    );
  }

}
