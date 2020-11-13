package com.acadena.BlackFridayAnalyzer.product.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Long id){
        super("Could not find product "+id);
    }

    public ProductNotFoundException(String name){
        super("Could not find product "+name);
    }
}
