package com.acadena.BlackFridayAnalyzer.product;

import com.acadena.BlackFridayAnalyzer.price.Price;
import com.acadena.BlackFridayAnalyzer.price.PriceRepository;
import com.acadena.BlackFridayAnalyzer.price.exception.PriceException;
import com.acadena.BlackFridayAnalyzer.product.exception.ProductNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;

    public ProductController(ProductRepository productRepository, PriceRepository priceRepository) {
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
    }

    @GetMapping("/product/all")
    List<Product> all(){
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    Product one(@PathVariable Long id){
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @GetMapping("/productName/{name}")
    Product oneByName(@PathVariable String name){
        Product product = null;
        product = productRepository.findByName(name);
        if(product == null)
            throw new ProductNotFoundException(name);
        return product;
    }

    @PostMapping("/product")
    Product newProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @PostMapping("/productPrice/{id}")
    Product addPrice(@PathVariable Long id, @RequestBody Price price){
        Product product = null;
        try{
            product = this.one(id);
            price.setProduct(product);
            priceRepository.save(price);
        }catch (ProductNotFoundException ex){
            throw new ProductNotFoundException(id);
        }catch (Exception ex){
            throw new PriceException();
        }
        return product;
    }

    @DeleteMapping("/product/{id}")
    void deleteProduct(@PathVariable Long id){
        try{
            productRepository.deleteById(id);
        }catch (Exception ex){
            throw new ProductNotFoundException(id);
        }
    }
}
