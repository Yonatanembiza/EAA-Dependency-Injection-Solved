package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository{
    private Logger logger;
    @Autowired
    public ProductRepositoryImpl(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void save(Product product) {
        System.out.println("Product saving...");
        System.out.println("Product saved: "+product.getName());
        logger.log("Product saved in the DB: "+ product.getName() );
    }
}
