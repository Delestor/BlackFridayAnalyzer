package com.acadena.BlackFridayAnalyzer.product;

public class Price {
    double price = 15.03;
    String currency = "€";



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
