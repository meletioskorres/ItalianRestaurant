package com.melkor.italianrestaurant.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Type type;

    public enum Type {
        MEAT,CHEESE,SAUCE,VEGETABLE
    }

    public Ingredient(String name, Type type) {
        this.name = name;
        this.type = type;
    }
}
