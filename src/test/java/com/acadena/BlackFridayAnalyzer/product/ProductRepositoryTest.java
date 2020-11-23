package com.acadena.BlackFridayAnalyzer.product;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductRepositoryTest {

    //TODO: Mock MVC Test https://www.baeldung.com/spring-mvc-test-exceptions



    @Autowired
    private ProductRepository repo;

    private static String productName;
    private static Product globalProduct;

    @BeforeAll
    static void setUp(){
        productName = "CocaCola";
        globalProduct = new Product(productName);
    }

    @Test
    @Rollback(false)
    @Order(1)
    public void testCreateProduct(){
        Product savedProduct = repo.save(globalProduct);
        assertThat(savedProduct.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void testFindByName(){
        repo.save(globalProduct);
        Product product = repo.findByName(globalProduct.getName());
        assertThat(product).isNotNull();
    }

    @Test
    @Order(3)
    public void testFindById(){
        assertThat(repo.findById(globalProduct.getId())).isNotNull();
    }

    @Test
    @Order(4)
    public void testListProducts() {
        List<Product> products = repo.findAll();
        assertThat(products).size().isGreaterThan(0);
    }

    @Test
    @Order(5)
    public void testDeleteProduct(){
        Product product = new Product("TestDelete");
        repo.save(product);
        repo.deleteById(product.getId());
        assertThat(repo.findById(product.getId())).isEmpty();
    }

    @Test
    @Order(6)
    public void testSaveSameProduct(){
        boolean isException = false;
        try{
            repo.save(globalProduct);
        }catch (Exception ex){
            isException = true;
        }
        assertThat(isException).isEqualTo(true);
    }

    //TODO: https://www.codejava.net/frameworks/spring-boot/junit-tests-for-spring-data-jpa

}
