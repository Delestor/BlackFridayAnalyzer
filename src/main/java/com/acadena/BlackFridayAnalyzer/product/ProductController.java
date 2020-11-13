package com.acadena.BlackFridayAnalyzer.product;

import com.acadena.BlackFridayAnalyzer.product.exception.ProductNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    List<Product> all(){
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    Product one(@PathVariable Long id){
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @GetMapping("/product/{name}")
    Product oneByName(@PathVariable String name){
        Product product = null;

        List<Product> products = all();
        for (Product p:
             products) {
            if(p.getName().equalsIgnoreCase(name))
                product = p;
        }

        if(product == null)
            throw new ProductNotFoundException(name);

        return product;
    }

    @PostMapping("/products")
    Product newProduct(@RequestBody Product product){
        return productRepository.save(product);
    }
}
