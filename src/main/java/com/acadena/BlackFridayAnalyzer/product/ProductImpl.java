package com.acadena.BlackFridayAnalyzer.product;

public class ProductImpl implements Product{
    String name;

    public ProductImpl(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
