package com.acadena.BlackFridayAnalyzer.product;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "prices")
public class Price {
    private @Id @GeneratedValue(strategy= GenerationType.IDENTITY) Long id;
    double price = 0.0;
    String currency = "€";

    public Price(){}

    public Price(double price, String currency) {
        this.price = price;
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return Double.compare(price1.price, price) == 0 && Objects.equals(id, price1.id) && Objects.equals(currency, price1.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, currency);
    }
}
