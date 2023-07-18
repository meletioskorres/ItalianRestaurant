package com.melkor.italianrestaurant.Controller;

import com.melkor.italianrestaurant.Entity.Cart;
import com.melkor.italianrestaurant.Entity.CartItem;
import com.melkor.italianrestaurant.Entity.Pizza;
import com.melkor.italianrestaurant.Repository.PizzaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CartController {
    private final PizzaRepository pizzaRepository;
    private final Cart cart;

    public CartController(PizzaRepository pizzaRepository, Cart cart) {
        this.pizzaRepository = pizzaRepository;
        this.cart = cart;
    }

    @PostMapping("/addToCart")
    public String addToCart(@RequestParam("pizzaId") Long pizzaId, @RequestParam("quantity") int quantity) {
        Pizza pizza = pizzaRepository.findById(pizzaId).orElse(null);
        if (pizza != null) {
            CartItem cartItem = pizza.toCartItem(quantity);
            cart.addItem(cartItem);
        }

        return "redirect:/menu";
    }

    @GetMapping("/cart")
    public String showCart(Model model) {
        List<CartItem> cartItems = cart.getItems();
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }
}
