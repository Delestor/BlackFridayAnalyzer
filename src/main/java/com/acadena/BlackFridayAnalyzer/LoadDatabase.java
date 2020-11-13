package com.acadena.BlackFridayAnalyzer;

import com.acadena.BlackFridayAnalyzer.product.Price;
import com.acadena.BlackFridayAnalyzer.product.Product;
import com.acadena.BlackFridayAnalyzer.product.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {
        Product product = new Product("Bilbo Baggins", new Price(10.2, "€"));
        return args -> {
            log.info("Preloading " + repository.save(product));
            log.info("Removing data " + repository.deleteByName(product.getName() ));
        };
    }
}
