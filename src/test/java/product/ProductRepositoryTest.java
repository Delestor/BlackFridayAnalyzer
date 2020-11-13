package product;

import com.acadena.BlackFridayAnalyzer.product.Price;
import com.acadena.BlackFridayAnalyzer.product.Product;
import com.acadena.BlackFridayAnalyzer.product.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository repository;

    @Test
    public void testNewAndFindProduct(){
        repository.save(new Product("Calculator", new Price(15.03, "€")));
        assertEquals(repository.findByName("Calculator").getPrice().getPrice(), 15.03, 0.0);
    }
}
