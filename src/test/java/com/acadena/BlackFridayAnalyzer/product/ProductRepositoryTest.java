package com.acadena.BlackFridayAnalyzer.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repo;

    @Test
    @Rollback(false)
    public void testCreateProduct(){
        Product savedProduct = repo.save(new Product("CocaCola", new Price(3, "€")));
        assertThat(savedProduct.getId()).isGreaterThan(0);
    }

    //TODO: https://www.codejava.net/frameworks/spring-boot/junit-tests-for-spring-data-jpa

}
