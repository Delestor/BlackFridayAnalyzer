package com.acadena.BlackFridayAnalyzer.product;

import com.acadena.BlackFridayAnalyzer.price.Price;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "product")
public class Product {
    private @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id;
    private @Column(unique = true) String name;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private Set<Price> prices;

    public Product(){

    }

    public Product(String name){
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Price> getPrices() {
        return prices;
    }

    public void setPrices(Set<Price> prices) {
        this.prices = prices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
