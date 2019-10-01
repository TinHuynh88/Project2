import { Product } from './product';

describe('Products', () => {
  it('should create an instance', () => {
    const x = new Date();
    expect(new Product(999, 'Video Game', 99, '2000/01/01',
      'Platformer', 10, 5, 'SNES',
      'https://content.propertyroom.com/listings/sellers/seller888888939/images/origimgs/888888939_183201702445865.jpg')).toBeTruthy();
  });
});
