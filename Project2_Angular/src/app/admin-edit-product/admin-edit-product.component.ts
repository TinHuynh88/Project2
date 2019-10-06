import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ActivatedRoute, Router } from '@angular/router';
import { Project2Service } from '../project2.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-admin-edit-product',
  templateUrl: './admin-edit-product.component.html',
  styleUrls: ['./admin-edit-product.component.css']
})
export class AdminEditProductComponent implements OnInit {

  product: Product;
  id: string;
  private sub: any;
  isUpdate: boolean;
  session: string[];
  constructor(private project2Service: Project2Service, private router: Router, private route: ActivatedRoute, private location: Location) {
    this.product = new Product();
   }

  ngOnInit() {
    this.project2Service.getSession().subscribe(data => {
      this.session = data;
      if (this.session == null) {
        this.router.navigate(['/adminLogin']);
      } else {
        this.sub = this.route.params.subscribe(params => {
          this.id = params['id']; // +params['id'];  (+) converts string 'id' to a number
        });

        // this.project2Service.getUserByUsername(this.id).subscribe(data => {
        //   this.user = data;
        // });
      }
    });
  }

}
