import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { LogoutConfirmComponent } from './logout-confirm/logout-confirm.component';
import { OrderConfirmationComponent } from './order-confirmation/order-confirmation.component';
import { OrderSuccessComponent } from './order-success/order-success.component';
import { RegisterComponent } from './register/register.component';
import { RegisterSuccessComponent } from './register-success/register-success.component';
import { UserAccountComponent } from './user-account/user-account.component';
import { UserOrdersComponent } from './user-orders/user-orders.component';
import { CartComponent } from './cart/cart.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { ChangePasswordSuccessComponent } from './change-password-success/change-password-success.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { HomeComponent } from './home/home.component';
import { AdminCreateProductComponent } from './admin-create-product/admin-create-product.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AdminSearchProductsComponent } from './admin-search-products/admin-search-products.component';
import { AdminSearchUsersComponent } from './admin-search-users/admin-search-users.component';
import { ProductPageComponent } from './product-page/product-page.component';
import { AdminSearchTransactionsComponent } from './admin-search-transactions/admin-search-transactions.component';
import { CreateProductComponent } from './create-product/create-product.component';
import { AdminEditUserComponent } from './admin-edit-user/admin-edit-user.component';
import { AdminEditProductComponent } from './admin-edit-product/admin-edit-product.component';
import { PaymentComponent } from './payment/payment.component';
import { AdminProductsByTransIdComponent } from './admin-products-by-trans-id/admin-products-by-trans-id.component';
import { ResetPasswordComponent } from './reset-password/reset-password.component';

import { ProductCardComponent } from './product-card/product-card.component';


const routes: Routes = [
  { path: '', redirectTo: 'home/products', pathMatch: 'full' },
  { path: 'home', redirectTo: 'home/products', pathMatch: 'full' },
  {
    path: 'home', component: HomeComponent, children: [
      { path: 'products', component: ProductPageComponent},
      { path: 'products/:id', component: ProductCardComponent },
      { path: 'login', component: LoginComponent },
      { path: 'logout', component: LogoutComponent },
      { path: 'logoutConfirm', component: LogoutConfirmComponent },
      { path: 'register', component: RegisterComponent },
      { path: 'registerSuccess', component: RegisterSuccessComponent },
      { path: 'forgotPassword', component: ForgotPasswordComponent },
      { path: 'changePassword', component: ChangePasswordComponent },
      { path: 'changePasswordSuccess', component: ChangePasswordSuccessComponent },
      { path: 'cart', component: CartComponent },
      { path: 'orderConfirmation', component: OrderConfirmationComponent },
      { path: 'orderSuccess', component: OrderSuccessComponent },
      { path: 'userAccount', component: UserAccountComponent },
      { path: 'userOrders', component: UserOrdersComponent },
      { path: 'createProduct', component: CreateProductComponent },
      { path: 'payment', component: PaymentComponent },
       {path:'resetPassword',component:ResetPasswordComponent}
    ]
  },
  {path:'adminLogin', component:AdminLoginComponent},
    {path:'adminHome',component:AdminHomeComponent, children:[
      {path:'adminSearchUsers',component:AdminSearchUsersComponent},
      {path:'adminCreateProduct',component:AdminCreateProductComponent},  
    {path:'adminSearchProducts',component:AdminSearchProductsComponent},
    {path:'adminSearchTransactions',component:AdminSearchTransactionsComponent},
    {path:'adminEditUser',component:AdminEditUserComponent},
    {path:'adminEditProduct',component:AdminEditProductComponent},
    {path:'adminProductByTransId', component:AdminProductsByTransIdComponent}
    ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

