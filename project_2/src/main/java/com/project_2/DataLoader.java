package com.project_2;

import java.security.MessageDigest;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project_2.dao.OrderDAO;
import com.project_2.dao.ProductsDAO;
import com.project_2.dao.TransactionDAO;
import com.project_2.dao.UserDAO;
import com.project_2.model.Order;
import com.project_2.model.Products;
import com.project_2.model.Transaction;
import com.project_2.model.User;

@Component
public class DataLoader {

	@Autowired // auto create object
	private UserDAO userDao;

	@Autowired
	private ProductsDAO productsDao;
	

	@Autowired
	private TransactionDAO transactionDao;
	@Autowired
	private OrderDAO orderDao;

	@PostConstruct
	public void init() {
		// init code goes here
		// CREATE USER
//		User u1 = new User("aaa", encryptPassword("a"), "aaa@yahoo.com", "Thanhaa", "Huynhaa", "111 aaa, irving, tx 75060",
//				"666-555-5555", "What is Your old Phone Number?", "aaa", "User");
//		userDao.save(u1);
//		userDao.save(new User("aa", encryptPassword("a"), "aa@yahoo.com", "Thanh", "Huynh", "111 aaa, irving, tx 75060",
//				"555-555-5555", "What is Your old Phone Number?", "aaa", "User"));
//		userDao.save(new User("a", encryptPassword("a"), "a@yahoo.com", "Thanh", "Huynh", "111 aaa, irving, tx 75060",
//				"555-555-5555", "What is Your old Phone Number?", "aaa", "Admin"));

		// CREATE PRODUCT
		
//		Products p1=new Products(0, "Mario", 12.0, "2011-10-31", "Plat", 23, 9.0f, "PC",
//				"http://www.retrogameguide.com/images/box_art_and_carts/SNES-Donkey-Kong-Country-cart.jpg",
//				"http://www.retrogameguide.com/images/box_art_and_carts/SNES-Donkey-Kong-Country-cart.jpg",
//				"http://www.retrogameguide.com/images/box_art_and_carts/SNES-Donkey-Kong-Country-cart.jpg");
//
//		productsDao.save(p1);
//		productsDao.save(new Products(0, "Donkey", 12.0, "2013-10-31", "Plat", 23, 9.0f, "PC",
//				"http://www.retrogameguide.com/images/box_art_and_carts/SNES-Donkey-Kong-Country-cart.jpg",
//				"http://www.retrogameguide.com/images/box_art_and_carts/SNES-Donkey-Kong-Country-cart.jpg",
//				"http://www.retrogameguide.com/images/box_art_and_carts/SNES-Donkey-Kong-Country-cart.jpg"));
//
//
//		productsDao.save(new Products(0, "Don", 23.0, "2014-10-31", "Plat", 23, 9.0f, "PS4",
//				"http://www.retrogameguide.com/images/box_art_and_carts/SNES-Donkey-Kong-Country-cart.jpg",
//				"http://www.retrogameguide.com/images/box_art_and_carts/SNES-Donkey-Kong-Country-cart.jpg",
//				"http://www.retrogameguide.com/images/box_art_and_carts/SNES-Donkey-Kong-Country-cart.jpg"));
//
//		// CREATE TRANSACTION
//		Date date = new Date();
//		System.out.println(date);
//		Transaction t1=new Transaction(0, date,30.3,u1);
//		transactionDao.save(t1);
//		transactionDao.save(new Transaction(0,date,30,u1));
//		transactionDao.save(new Transaction(0,date,30,u1));
//		
//		// CREATE ORDER
//		Order o1 = new Order(0,t1,p1,2,100.0);
//		Order o2 = new Order(0,t1,p1,2,100.0);
//		orderDao.save(o1);
//		orderDao.save(o2);
		User u1 = new User("tom", encryptPassword("Tomtom"), "thanh@yahoo.com", "Thanh", "Huynh",
                "111 Beltline, Irving, TX 75060", "2143527856", "What is Your old Phone Number?", "9723334444", "User");
        userDao.save(u1);
        User u2 = new User("thanh", encryptPassword("thanhthanh"), "tin@yahoo.com", "Tin", "Huynh", "333 Greenville, Dallas, TX 75060",
                "9873649812", "What is Your old Phone Number?", "9723334455", "User");
        userDao.save(u2);
        User u3 = new User("robert", encryptPassword("robert"), "michael@yahoo.com", "Michael", "Montgomery", "999 McArthur, Plano, TX 75060",
                "6264131234", "What is Your old Phone Number?", "9723334678", "Admin");
        userDao.save(u3);
        User u4 = new User("kumar", encryptPassword("kumar"), "michelle@yahoo.com", "Michelle", "Ganon", "111 bbb, Irving, TX 75060",
                "9723334544", "What is Your old Phone Number?", "6264319831", "User");
        userDao.save(u4);
        User u5 = new User("admin", encryptPassword("admin"), "charles@yahoo.com", "Charles", "Nguyen", "1916 Pioneer, Irving, TX 75060",
                "9723335555", "What is Your old Phone Number?", "9733459812", "Admin");
        userDao.save(u5);
        Products p1 = new Products(0, "Mario", 12.0, "2011-10-31", "Plat", 24, 9.0f, "PC",
                "https://images.fatherly.com/wp-content/uploads/2019/07/fatherlymariomaker1.jpg?q=65&enable=upscale&w=600",
                "https://secure.i.telegraph.co.uk/multimedia/archive/02412/mario_2412179b.jpg",
                "http://www.criticalcommons.org/Members/ebreilly/clips/super-mario-bros/thumbnailImage");
        p1=productsDao.save(p1);
        Products p2 = new Products(0, "Donkey", 12.0, "2013-10-31", "Plat", 25, 9.0f, "PC",
                "https://images-na.ssl-images-amazon.com/images/I/513S3AG2RTL._SX466_.jpg",
                "https://www.whbc.com/wp-content/uploads/2019/04/donkey11.jpg",
                "https://images-na.ssl-images-amazon.com/images/I/518SWKMEBVL._AC_SX215_.jpg");
        p2=productsDao.save(p2);
        Products p3 = new Products(0, "Lego", 23.0, "2014-10-31", "Plat", 23, 9.0f, "PS4",
                "https://www-konga-com-res.cloudinary.com/w_auto,f_auto,fl_lossy,dpr_auto,q_auto/media/catalog/product/G/F/125031_1555673842.jpg",
                "https://i03.hsncdn.com/is/image/HomeShoppingNetwork/prodfull/lego-marvel-super-heroes-xbox-one-d-20160113193516617~8027446w.jpg",
                "https://nerdist.com/wp-content/uploads/2019/02/lego-harry-header-1200x675.jpg");
        p3=productsDao.save(p3);
        Products p4 = new Products(0, "Nintendo", 40.0, "2015-10-31", "Plat", 26, 9.0f, "PS4",
                "https://timedotcom.files.wordpress.com/2017/04/nintendo-2ds1.jpg",
                "https://cdn.images.express.co.uk/img/dynamic/143/590x/Nintendo-Games-news-826381.jpg",
                "https://s.abcnews.com/images/Technology/nintendo-collection-sold-01-wisn-jef-170816_4x3_992.jpg");
        p4=productsDao.save(p4);
        Products p5 = new Products(0, "Raleigh", 25.0, "2016-10-31", "Plat", 28, 9.0f, "PS4",
                "https://www.wraltechwire.com/wp-content/uploads/2019/05/video-games-960x640.jpg",
                "https://i.ytimg.com/vi/uODKrZnGk7g/maxresdefault.jpg",
                "https://www.incimages.com/uploaded_files/image/1940x900/getty_655144716_356974.jpg");
        p5=productsDao.save(p5);
        Products p6 = new Products(0, "Polygon", 20.0, "2017-11-31", "Plat", 29, 9.0f, "PS4",
                "https://cdn.vox-cdn.com/thumbor/McfpogGnEyDvC7_N2GI9rkanJJk=/0x0:1920x1080/1200x675/filters:focal(16x393:322x699)/cdn.vox-cdn.com/uploads/chorus_image/image/58245783/unnamed_2.0.jpg",
                "https://static01.nyt.com/images/2019/09/15/opinion/sunday/15peyser/15peyser-superJumbo-v2.gif",
                "https://heavyeditorial.files.wordpress.com/2019/07/prime-day-video-games-deals-2019-get-a-ps-mini-for-20.jpg?quality=65&strip=all");
        p6=productsDao.save(p6);
        Products p7 = new Products(0, "Xbox", 30.0, "2018-10-31", "Plat", 30, 9.0f, "PS4",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Xbox-console.jpg/1200px-Xbox-console.jpg",
                "https://www.playerschoicevideogames.com/misc_images/xboxonesystem.jpg",
                "https://media.gamestop.com/i/gamestop/10149560/Fortnite-Deluxe-Edition?$zoom$");
        p7=productsDao.save(p7);
        Products p8 = new Products(0, "Spiderman", 45.0, "2019-1-31", "Plat", 13, 9.0f, "PS4",
                "https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcQ8zBkh58hn1OI15_b80GPEwq_QLKm-_cMFvRdA_y72TVrkGIU_bS49FUDzFMMnJuUa4AwBvO7lTF6LaHR7jS-0N74DSUFCx0e82l9Dj7DIdYlBbFlK3Xnz4w&usqp=CAY",
                "https://encrypted-tbn3.gstatic.com/shopping?q=tbn:ANd9GcTeTQuasgJ7QdFJeyRNlNYQmOT4Y5DlgV7pGWyqmxQNUvHlyQuaDLXNf-8vDw112wstjWI9UFrNEcx39eGjvViS9NI3GxzLwS6B4TxIbp2WYtbmLQYziK1_&usqp=CAY",
                "https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcR_kjyRfPdoxRbo2U50TnAz5ohi_JzDxn9P35_KVuygt3bp2bGPhAzehyneQbZD6By7IyxlPJZovGraXVNErc96C04wcdf66dRVz5Av0wIPTBOZnTrMkv4f&usqp=CAY");
        p8=productsDao.save(p8);
        Products p9 = new Products(0, "Mysterio", 12.0, "2014-7-31", "Plat", 43, 9.0f, "PS4",
                "https://i.ytimg.com/vi/3uAR2PKIAWM/maxresdefault.jpg",
                "https://i.pinimg.com/originals/78/ce/48/78ce48e70d69725562d32373ee2f6b91.jpg",
                "https://terrigen-cdn-dev.marvel.com/content/prod/1x/_mysterio_card_0.jpg");
        p9=productsDao.save(p9);
        Products p10 = new Products(0, "Pokemon", 60.0, "2014-10-31", "Plat", 34, 9.0f, "PS4",
                "https://cdn.wealthygorilla.com/wp-content/uploads/2019/08/The-Most-Popular-Video-Games-of-All-Time.jpg",
                "https://cdn.mos.cms.futurecdn.net/zmyebnoLbhVmYwTocG3ky8-768-80.jpg",
                "https://pisces.bbystatic.com/image2/BestBuy_US/Gallery/pol_ds_1214-58982.jpg;maxHeight=288;maxWidth=520g");
        p10=productsDao.save(p10);
	
        Date date = new Date();
        Transaction t1 = new Transaction(0, date, 30.3, u1);
        t1=transactionDao.save(t1);
        Transaction t2 = new Transaction(0, date, 20, u2);
        t2=transactionDao.save(t2);
        Transaction t3 = new Transaction(0, date, 13, u3);
        t3=transactionDao.save(t3);
        Transaction t4 = new Transaction(0, date, 320, u4);
        t4=transactionDao.save(t4);
        Transaction t5 = new Transaction(0, date, 132, u5);
        t5=transactionDao.save(t5);
        Transaction t6 = new Transaction(0, date, 112, u1);
        t6=transactionDao.save(t6);
        Transaction t7 = new Transaction(0, date, 445, u2);
        t7=transactionDao.save(t7);
        Transaction t8 = new Transaction(0, date, 121, u4);
        t8=transactionDao.save(t8);
        Transaction t9 = new Transaction(0, date, 66, u5);
        t9=transactionDao.save(t9);
        Transaction t10 = new Transaction(0, date, 112, u2);
        transactionDao.save(t10);
        t10=transactionDao.save(new Transaction(0, date, 30, u1));
//        // CREATE ORDER
        System.out.println(t1);
        System.out.println(p1);
        Order o1 = new Order(0, t1, p1, 2, 100.0);
        Order o2 = new Order(0, t2, p1, 2, 100.0);
        Order o3 = new Order(0, t3, p1, 2, 100.0);
        Order o4 = new Order(0, t4, p1, 2, 100.0);
        Order o5 = new Order(0, t5, p1, 2, 100.0);
        Order o6 = new Order(0, t6, p1, 2, 100.0);
        Order o7 = new Order(0, t7, p1, 2, 100.0);
        Order o8 = new Order(0, t8, p1, 2, 100.0);
        Order o9 = new Order(0, t9, p1, 2, 100.0);
        Order o10 = new Order(0, t10, p1, 2, 100.0);
        Order o11 = new Order(0, t1, p1, 2, 100.0);
        Order o12 = new Order(0, t2, p1, 2, 100.0);
  //      orderDao.save(new Order(0, t1, p1, 2, 100.0));
//        
//        orderDao.save(o1);
//        orderDao.save(o2);
//        orderDao.save(o3);
//        orderDao.save(o4);
//        orderDao.save(o5);
//        orderDao.save(o6);
//        orderDao.save(o7);
//        orderDao.save(o8);
//        orderDao.save(o9);
//        orderDao.save(o10);
//        orderDao.save(o11);
//        orderDao.save(o12);
	}

	public String encryptPassword(String password) {
		StringBuffer message = new StringBuffer();

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] hash = md.digest(password.getBytes("UTF-8"));

			for (byte w : hash) {
				message.append(String.format("%02x", w));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return message.toString();

	}
}
