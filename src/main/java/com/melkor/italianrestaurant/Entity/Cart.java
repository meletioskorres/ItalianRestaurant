package com.melkor.italianrestaurant.Entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.context.annotation.ScopedProxyMode;


@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(CartItem cartItem) {
        items.add(cartItem);
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}
