package com.melkor.italianrestaurant.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CustomerOrder {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String City;
    private String Zip;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Pizza> pizzas;

    public void addPizza(Pizza pizza) {
        this.pizzas.add(pizza);
    }
}
