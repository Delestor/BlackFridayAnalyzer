package com.acadena.BlackFridayAnalyzer.shop;

import com.acadena.BlackFridayAnalyzer.product.Price;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="shop")
public class Shop {

    private @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) Long id;
    private @Column(unique = true) String name;

    @OneToMany(mappedBy = "shop")
    @JsonManagedReference
    private Set<Price> prices;

    public Shop(){

    }

    public Shop(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        Shop shop = (Shop) o;
        return Objects.equals(id, shop.id) && Objects.equals(name, shop.name) && Objects.equals(prices, shop.prices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, prices);
    }
}
