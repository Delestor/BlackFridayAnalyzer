package com.acadena.BlackFridayAnalyzer.store;

import com.acadena.BlackFridayAnalyzer.price.Price;
import com.acadena.BlackFridayAnalyzer.product.Product;

public interface StoreManager {
    Price checkProductPrice(Product product) throws Exception;
}
