package com.acadena.BlackFridayAnalyzer.product;

import com.acadena.BlackFridayAnalyzer.shop.Shop;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "price")
public class Price {
    private @Id @GeneratedValue(strategy= GenerationType.IDENTITY) Long id;
    private double price = 0.0;
    private String currency = "€";

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;

    @ManyToOne()
    @JoinColumn(name="product_id", nullable = false)
    private Product product;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return Double.compare(price1.price, price) == 0 && Objects.equals(id, price1.id) && Objects.equals(currency, price1.currency) && Objects.equals(date, price1.date) && Objects.equals(product, price1.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, currency, date, product);
    }
}
