package com.melkor.italianrestaurant.Repository;

import com.melkor.italianrestaurant.Entity.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient,Long> {
}
