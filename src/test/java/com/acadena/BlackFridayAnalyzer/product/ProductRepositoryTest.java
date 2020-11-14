package com.acadena.BlackFridayAnalyzer.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repo;

    @Test
    public void testCreateProduct(){
        Product savedProduct = repo.save(new Product("CocaCola", new Price(3, "€")));
        assertThat(savedProduct.getId()).isGreaterThan(0);
    }

}
