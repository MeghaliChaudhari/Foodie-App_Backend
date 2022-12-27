package com.foodieapp.cartservice.service;

import com.foodieapp.cartservice.domain.Cart;
import com.foodieapp.cartservice.exception.ItemAlreadyExists;

import java.util.List;

public interface CartService {
    Cart addItem(Cart cart) throws ItemAlreadyExists;
    boolean deleteItem(int itemId);
    List<Cart> getAllItem();
    boolean deleteAllItem();
     Cart getCartItemByItemId(int itemId);
}
