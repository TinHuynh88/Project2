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


const routes: Routes = [
  {path:'', redirectTo: 'home', pathMatch: 'full'},
  {path:'cart',component:CartComponent},
  {path:'changePassword',component:ChangePasswordComponent},
  {path:'changePasswordSuccess',component:ChangePasswordSuccessComponent},
  {path:'forgotPassword',component:ForgotPasswordComponent},
  {path:'home',component:HomeComponent},
  {path:'home/login',component:LoginComponent},
  {path:'logout',component:LogoutComponent},
  {path:'logoutConfirm',component:LogoutConfirmComponent},
  {path:'orderConfirmation',component:OrderConfirmationComponent},
  {path:'orderSuccess',component:OrderSuccessComponent},
  {path:'home/register',component:RegisterComponent},
  {path:'registerSuccess',component:RegisterSuccessComponent},
  {path:'userAccount',component:UserAccountComponent},
  {path:'userOrders',component:UserOrdersComponent},
  {path:'adminCreateProduct',component:AdminCreateProductComponent},
  {path:'adminHome',component:AdminHomeComponent},
  {path:'adminLogin', component:AdminLoginComponent},
  {path:'adminSearchProducts',component:AdminSearchProductsComponent},
  {path:'adminSearchUsers',component:AdminSearchUsersComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
