package com.melkor.italianrestaurant.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany
    private List<Ingredient> ingredients;

    public Pizza(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public CartItem toCartItem(int quantity) {
        return new CartItem(this, quantity);
    }
}
