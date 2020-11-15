package com.acadena.BlackFridayAnalyzer.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repo;

    private final String productName = "CocaCola";
    private final Price globalPrice = new Price(3, "€");
    private final Product globalProduct = new Product(productName, globalPrice);

    @Test
    public void testCreateProduct(){
        Product savedProduct = repo.save(globalProduct);
        assertThat(savedProduct.getId()).isGreaterThan(0);
    }

    @Test
    public void testTwoEqualsProducts(){
        repo.save(globalProduct);
        repo.save(new Product(productName, new Price(3, "€")));
        List<Product> products = repo.findAll();
        assertThat(products).size().isEqualTo(2);
    }

    @Test
    public void testSaveSameProductTwice(){
        repo.save(globalProduct);
        repo.save(globalProduct);
        List<Product> products = repo.findAll();
        assertThat(products).size().isEqualTo(1);
    }

    @Test
    public void testFindByName(){
        repo.save(globalProduct);
        Product product = repo.findByName(productName);
        assertThat(product).isNotNull();
    }

    @Test
    public void testListProducts() {
        repo.save(globalProduct);
        List<Product> products = repo.findAll();
        assertThat(products).size().isGreaterThan(0);
    }

    //TODO: https://www.codejava.net/frameworks/spring-boot/junit-tests-for-spring-data-jpa

}
