package br.com.Course.Config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.Course.Entities.Category;
import br.com.Course.Entities.Order;
import br.com.Course.Entities.OrderItem;
import br.com.Course.Entities.Payment;
import br.com.Course.Entities.Product;
import br.com.Course.Entities.User;
import br.com.Course.Entities.enums.OrderStatus;
import br.com.Course.Repository.CategoryRepository;
import br.com.Course.Repository.OrderItemRepository;
import br.com.Course.Repository.OrderRepository;
import br.com.Course.Repository.ProductRepository;
import br.com.Course.Repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	@Autowired
	private UserRepository userRepos;

	@Autowired
	private OrderRepository orderRepos;

	@Autowired
	private CategoryRepository categoryRepos;

	@Autowired
	private ProductRepository productRepos;
	
	@Autowired
	private OrderItemRepository orderItemRepo;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Leonardo Brown", "leonardo@gmail.com", "(11)996422659", "123456");
		User u2 = new User(null, "Petter Green", "alex@gmail.com", "977777777", "123456");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.CANCELED, u1);
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		userRepos.saveAll(Arrays.asList(u1, u2));
		orderRepos.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepos.saveAll(Arrays.asList(cat1, cat2, cat3));

		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);

		productRepos.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepo.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1);
		
		orderRepos.save(o1);
	}
}
