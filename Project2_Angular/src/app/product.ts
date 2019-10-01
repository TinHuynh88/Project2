export class Product {

  private productId:number;
  private productName:string;
  private productPrice:number;
  private releaseDate:string;
  private category:string;
  private quantity:number;
  private rating:number;
  private system:string;
  // URL
  private picture:string;

  constructor (productId:number, 
    productName:string,
    productPrice:number,
    releaseDate:string,
    category:string,
    quantity:number,
    rating:number,
    system:string,
    picture:string) {
    this.productId = productId;
    this.productName = productName;
    this.productPrice = productPrice;
    this.releaseDate = releaseDate;
    this.category = category;
    this.quantity = quantity;
    this.rating = rating;
    this.system = system;
    this.picture = picture;
  }

  get getProductId():number {
    return this.productId;
  }

  set setProductId(newId:number) {
    this.productId = newId;
  }

  get getProductName():string {
    return this.productName;
  }

  set setProductName(newName:string) {
    this.productName = newName;
  }

  get getProductPrice():number {
    return this.productPrice;
  }

  set setProductPrice(newPrice:number) {
    this.productPrice = newPrice;
  }

  get getReleaseDate():string {
    return this.releaseDate;
  }

  set setReleaseDate(newReleaseDate:string) {
    this.releaseDate = newReleaseDate;
  }

  get getCategory():string {
    return this.category;
  }

  set setCategory(newCategory:string) {
    this.category = newCategory;
  }

  get getQuantity():number {
    return this.quantity;
  }

  set setQuantity(newQuantity:number) {
    this.quantity = newQuantity;
  }

  get getRating():number {
    return this.rating;
  }

  set setRating(newRating:number) {
    this.rating = newRating;
  }

  get getSystem():string {
    return this.system;
  }

  set setSystem(newSystem:string) {
    this.system = newSystem;
  }

  get getPicture():string {
    return this.picture;
  }

  set setPicture(newPicture:string) {
    this.picture = newPicture;
  }

}
