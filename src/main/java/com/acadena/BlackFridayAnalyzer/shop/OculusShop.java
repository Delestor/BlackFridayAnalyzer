package com.acadena.BlackFridayAnalyzer.shop;

import com.acadena.BlackFridayAnalyzer.product.Price;
import com.acadena.BlackFridayAnalyzer.product.Product;

public class OculusShop implements Shop{
    @Override
    public Price checkProductPrice(Product product) throws Exception{
        if(product.getName().equalsIgnoreCase("testException"))
            throw new Exception();
        return new Price();
    }
}
