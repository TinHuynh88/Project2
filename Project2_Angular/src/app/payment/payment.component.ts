import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent {
  paymentForm = new FormGroup({
    securityCode: new FormControl('', [
      Validators.required,
      Validators.pattern('^[0-9]$'),
      Validators.minLength(3),
      Validators.maxLength(3)
   ]),
   customerName: new FormControl('', Validators.required),
   paymentType: new FormControl('', Validators.required),
   cardNumber: new FormControl('', [
     Validators.required,
     Validators.pattern('^[0-9]$'),
     Validators.minLength(16),
     Validators.maxLength(16)
   ]),
   totalPrice: new FormControl('', Validators.required)
  });
  get securityCode() {
    return this.paymentForm.get("securityCode");
  }
  get customerName() {
    return this.paymentForm.get("customerName");
  }
  get paymentType() {
    return this.paymentForm.get("paymentType");
  }
  get cardNumber() {
    return this.paymentForm.get("cardNumber");
  }
  get totalPrice() {
    return this.paymentForm.get("totalPrice");
  }
}
