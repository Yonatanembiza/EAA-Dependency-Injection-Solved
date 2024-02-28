package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService{
    private EmailSender emailSender;
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, EmailSender emailSender) {
        this.emailSender = emailSender;
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(String name, Integer price) {
        System.out.println("Product created...");
        Product product = new Product(name, price);
        productRepository.save(product);
        emailSender.sendEmail("yonatan.tadesse@miu.edu", "Product "+name+" is added !");
    }
}
