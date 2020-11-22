package com.acadena.BlackFridayAnalyzer.store;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="shop")
public class Store {

    private @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) Long id;
    private @Column(unique = true) String name;

/*TODO: Relation between Store and Prices,
    try to understand @JsonManagedReference and @JsonBackReference value.
*/
    public Store(){

    }

    public Store(String name) {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return Objects.equals(id, store.id) && Objects.equals(name, store.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
