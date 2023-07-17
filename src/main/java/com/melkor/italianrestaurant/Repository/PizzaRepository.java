package com.melkor.italianrestaurant.Repository;

import com.melkor.italianrestaurant.Entity.Pizza;
import org.springframework.data.repository.CrudRepository;

public interface PizzaRepository extends CrudRepository<Pizza,Long> {
}
