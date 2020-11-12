package com.acadena.BlackFridayAnalyzer.shop;

import com.acadena.BlackFridayAnalyzer.product.Price;
import com.acadena.BlackFridayAnalyzer.product.Product;

public interface Shop {
    Price checkProductPrice(Product product) throws Exception;
}
