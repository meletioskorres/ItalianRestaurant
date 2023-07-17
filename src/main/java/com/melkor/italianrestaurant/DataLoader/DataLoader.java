package com.melkor.italianrestaurant.DataLoader;

import com.melkor.italianrestaurant.Entity.Ingredient;
import com.melkor.italianrestaurant.Entity.Pizza;
import com.melkor.italianrestaurant.Repository.IngredientRepository;
import com.melkor.italianrestaurant.Repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private final IngredientRepository ingredientRepository;
    private final PizzaRepository pizzaRepository;

    @Autowired
    public DataLoader(IngredientRepository ingredientRepository, PizzaRepository pizzaRepository) {
        this.ingredientRepository = ingredientRepository;
        this.pizzaRepository = pizzaRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        List<Ingredient> ingredients = List.of(
                new Ingredient("Pepperoni", Ingredient.Type.MEAT),
                new Ingredient("Ham", Ingredient.Type.MEAT),
                new Ingredient("Sausage", Ingredient.Type.MEAT),
                new Ingredient("Bacon", Ingredient.Type.MEAT),
                new Ingredient("Mushrooms", Ingredient.Type.VEGETABLE),
                new Ingredient("Onions", Ingredient.Type.VEGETABLE),
                new Ingredient("Bell Peppers", Ingredient.Type.VEGETABLE),
                new Ingredient("Olives", Ingredient.Type.VEGETABLE),
                new Ingredient("Mozzarella", Ingredient.Type.CHEESE),
                new Ingredient("Edam", Ingredient.Type.CHEESE),
                new Ingredient("Gorgonzola", Ingredient.Type.CHEESE),
                new Ingredient("Tomato Sauce", Ingredient.Type.SAUCE)
        );

        ingredientRepository.saveAll(ingredients);

        pizzaRepository.saveAll(List.of(
                new Pizza("Margherita", Arrays.asList(
                        findIngredientByName(ingredients, "Mozzarella"),
                        findIngredientByName(ingredients, "Tomato Sauce")
                )),

                new Pizza("Pepperoni Pizza", Arrays.asList(
                        findIngredientByName(ingredients, "Pepperoni"),
                        findIngredientByName(ingredients, "Mozzarella"),
                        findIngredientByName(ingredients, "Tomato Sauce")
                )),
                new Pizza("Vegetarian Pizza", Arrays.asList(
                        findIngredientByName(ingredients, "Mushrooms"),
                        findIngredientByName(ingredients, "Onions"),
                        findIngredientByName(ingredients, "Bell Peppers"),
                        findIngredientByName(ingredients, "Olives"),
                        findIngredientByName(ingredients, "Mozzarella"),
                        findIngredientByName(ingredients, "Tomato Sauce")
                )
                )));
    }

    private Ingredient findIngredientByName(List<Ingredient> ingredients, String name) {
        return ingredients.stream()
                .filter(ingredient -> ingredient.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
