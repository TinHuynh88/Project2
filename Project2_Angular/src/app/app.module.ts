import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { UserAccountComponent } from './user-account/user-account.component';
import { LogoutComponent } from './logout/logout.component';
import { LogoutConfirmComponent } from './logout-confirm/logout-confirm.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { ChangePasswordSuccessComponent } from './change-password-success/change-password-success.component';
import { RegisterSuccessComponent } from './register-success/register-success.component';
import { CartComponent } from './cart/cart.component';
import { OrderConfirmationComponent } from './order-confirmation/order-confirmation.component';
import { OrderSuccessComponent } from './order-success/order-success.component';
import { UserOrdersComponent } from './user-orders/user-orders.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AdminCreateProductComponent } from './admin-create-product/admin-create-product.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AdminSearchUsersComponent } from './admin-search-users/admin-search-users.component';
import { AdminSearchProductsComponent } from './admin-search-products/admin-search-products.component';

import { HttpClient, HttpClientModule } from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { ProductPageComponent } from './product-page/product-page.component';
import { AdminSearchTransactionsComponent } from './admin-search-transactions/admin-search-transactions.component';
import { AdminEditUserComponent } from './admin-edit-user/admin-edit-user.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    ForgotPasswordComponent,
    UserAccountComponent,
    LogoutComponent,
    LogoutConfirmComponent,
    ChangePasswordComponent,
    ChangePasswordSuccessComponent,
    RegisterSuccessComponent,
    CartComponent,
    OrderConfirmationComponent,
    OrderSuccessComponent,
    UserOrdersComponent,
    AdminLoginComponent,
    AdminCreateProductComponent,
    AdminHomeComponent,
    AdminSearchUsersComponent,
    AdminSearchProductsComponent,
    ProductPageComponent,
    AdminSearchTransactionsComponent,
    AdminEditUserComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

