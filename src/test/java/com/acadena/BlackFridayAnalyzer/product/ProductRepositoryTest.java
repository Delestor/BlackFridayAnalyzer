package com.acadena.BlackFridayAnalyzer.product;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
public class ProductRepositoryTest {

    //TODO: Mock MVC Test https://www.baeldung.com/spring-mvc-test-exceptions



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
        assertThrows(DataIntegrityViolationException.class, () -> repo.save(new Product(productName, new Price(3, "€"))));
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
