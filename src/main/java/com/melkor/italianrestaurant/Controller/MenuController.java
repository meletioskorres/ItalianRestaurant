package com.melkor.italianrestaurant.Controller;

import com.melkor.italianrestaurant.Entity.Pizza;
import com.melkor.italianrestaurant.Repository.PizzaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MenuController {

    private final PizzaRepository pizzaRepository;

    public MenuController(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @GetMapping("/menu")
    public String showMenu(Model model) {
        List<Pizza> pizzas = (List<Pizza>) pizzaRepository.findAll();

        model.addAttribute("pizzas", pizzas);

        return "menu";
    }
}
