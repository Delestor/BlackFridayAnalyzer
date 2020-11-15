package com.acadena.BlackFridayAnalyzer.product;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {
    private @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id;
    private String name;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="PRICES_ID", unique= true, nullable=true, insertable=true, updatable=true)
    private Price price;
    //TODO: La clase Producto podria guardar una lista con todos los precios que ha ido teniendo en el tiempo,
    //estos precios podrían guardar la fecha y la tienda.

    public Product(){

    }

    public Product(String name){
        this.name = name;
        price = new Price();
    }

    public Product(String name, Price price){
        this.name = name;
        this.price = price;
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

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
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
