package com.acadena.BlackFridayAnalyzer.product.exception;

public class ProductNotFoundException extends RuntimeException{
    ProductNotFoundException(Long id){
        super("Could not find product "+id);
    }
}
