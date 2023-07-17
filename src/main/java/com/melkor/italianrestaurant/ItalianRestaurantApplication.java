package com.melkor.italianrestaurant;

import com.melkor.italianrestaurant.Entity.Ingredient;
import com.melkor.italianrestaurant.Entity.Pizza;
import com.melkor.italianrestaurant.Repository.IngredientRepository;
import com.melkor.italianrestaurant.Repository.PizzaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageImpl;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ItalianRestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItalianRestaurantApplication.class, args);
	}
}
