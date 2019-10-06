import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductCardComponent } from '../product-card/product-card.component';
import { Project2Service } from '../project2.service';
import { Router } from '@angular/router';
import { ProductsService } from '../products.service';

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.css']
})
export class ProductPageComponent implements OnInit {
  product: Product;
  loggedIn: boolean;
  session: string[];
  products: Product[] = [];

  constructor(private project2Service: Project2Service,private productsService: ProductsService, private router: Router) { }

  ngOnInit() {
    this.productsService.getAllProducts().subscribe( data => {
      data.forEach(prod => {
        this.products.push(prod);
      });
    });
    this.project2Service.getUserSession().subscribe(data => {
      this.session = data;
      if (this.session == null) {
        console.log("logged product = false");
        this.loggedIn=false;

      } else {
        console.log("logged product= true");
        this.loggedIn=true;
//        window.location.reload();
        //show the 'add' button in items


        // this.project2Service.getAllUsers().subscribe(data => {
        //   this.userList = data;
        // });
      }
    });
  
   
  //   const p1 = new Product(100, 'Super Mario World', 34, '1991/03/25',
  //     'Platformer', 7, 10, 'SNES',
  //     ['http://content.propertyroom.com/listings/sellers/seller888888939/images/origimgs/888888939_183201702445865.jpg']);
  //   this.products.push(p1);
  //   const p2 = new Product(101, 'Donkey Kong Country', 27, '1993/06/07', 
  //     'Platformer', 3, 10, 'SNES',
  //     ['http://www.retrogameguide.com/images/box_art_and_carts/SNES-Donkey-Kong-Country-cart.jpg']);
  //   this.products.push(p2);
  //   const p3 = new Product(103, 'Star Fox', 21, '1994/05/12', 
  //     'Space Battles', 5, 10, 'SNES',
  //       ['http://images.nintendolife.com/news/2017/09/editorial_the_snes_classic_mini_star_fox_and_downsides_to_being_a_mega_drive_kid/attachment/0/original.jpg']);
  //   this.products.push(p3);
  //   const p4 = new Product(104, 'Super Metroid', 26, '1994/07/04', 
  //     'Platformer', 2, 10, 'SNES', 
  //     ['http://images.eurogamer.net/2014/usgamer/super-metroid-box.jpg']);
  //   this.products.push(p4);
  }

}
