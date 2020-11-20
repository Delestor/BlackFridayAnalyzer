package com.acadena.BlackFridayAnalyzer.shop;

import com.acadena.BlackFridayAnalyzer.price.Price;
import com.acadena.BlackFridayAnalyzer.product.Product;

public interface ShopManager {
    Price checkProductPrice(Product product) throws Exception;
}
