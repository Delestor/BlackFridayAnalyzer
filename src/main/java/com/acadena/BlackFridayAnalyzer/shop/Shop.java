package com.acadena.BlackFridayAnalyzer.shop;

import com.acadena.BlackFridayAnalyzer.product.Price;

import javax.persistence.*;

@Entity
public class Shop {

    private @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) Long id;
    private @Column(unique = true) String name;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="PRICES_ID", unique= true, nullable=true, insertable=true, updatable=true)
    private Price price;

}
