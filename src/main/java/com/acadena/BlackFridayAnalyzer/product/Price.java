package com.acadena.BlackFridayAnalyzer.product;

public class Price {
    double price = 0.0;
    String currency = "€";

    public Price(){}

    public Price(double price, String currency) {
        this.price = price;
        this.currency = currency;
    }

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
