package com.acadena.BlackFridayAnalyzer.shop;

import com.acadena.BlackFridayAnalyzer.price.Price;
import com.acadena.BlackFridayAnalyzer.product.Product;
import com.acadena.BlackFridayAnalyzer.product.ProductRepository;
import com.acadena.BlackFridayAnalyzer.product.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

public class OculusShopManager implements ShopManager {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Price checkProductPrice(Product product) throws ProductNotFoundException{
        Product product1 = productRepository.findById(product.getId()).orElseThrow(() -> new ProductNotFoundException(product.getId()));

        return new Price();
    }
}
