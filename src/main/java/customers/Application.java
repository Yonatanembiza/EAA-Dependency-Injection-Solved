package customers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class Application {

	public static void main(String[] args) {
		// This is for Classpath scanning DI
//		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");

		// This is for the Java Config DI
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		CustomerService customerService = context.getBean("customerService", CustomerService.class);

		customerService.addCustomer("Frank Brown", "fbrown@acme.com",
				"mainstreet 5", "Chicago", "60613");
		ProductService productService = context.getBean("productService", ProductService.class);
		productService.addProduct("iPhone 21", 1300);

	}
}

