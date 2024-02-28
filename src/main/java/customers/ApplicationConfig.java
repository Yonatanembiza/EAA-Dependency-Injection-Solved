package customers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public Logger logger(){
        return  new LoggerImpl();
    }
    @Bean
    public EmailSender emailSender(Logger logger){
        return new EmailSenderImpl(logger);
    }
    @Bean
    public CustomerRepository customerRepository(Logger logger){
        return new CustomerRepositoryImpl(logger);
    }
    @Bean
    public CustomerService customerService(CustomerRepository customerRepository, EmailSender emailSender){
        return new CustomerServiceImpl(customerRepository, emailSender);
    }
    @Bean
    public ProductRepository productRepository(Logger logger){
        return  new ProductRepositoryImpl(logger);
    }
    @Bean
    public ProductService productService(ProductRepository productRepository, EmailSender emailSender){
        return new ProductServiceImpl(productRepository, emailSender);
    }
}
