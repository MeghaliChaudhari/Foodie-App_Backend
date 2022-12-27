package com.foodieapp.cartservice.service;

import com.foodieapp.cartservice.domain.Cart;
import com.foodieapp.cartservice.exception.ItemAlreadyExists;
import com.foodieapp.cartservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    private CartRepository cartRepository;
    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart addItem(Cart cart) throws ItemAlreadyExists {
        if (cartRepository.findById(cart.getItemId()).isPresent()){
            throw  new ItemAlreadyExists();
        }
        return cartRepository.save(cart);
    }

    @Override
    public boolean deleteItem(int itemId) {
        cartRepository.deleteById(itemId);
        return true;
    }

    @Override
    public List<Cart> getAllItem() {
        return (List<Cart>) cartRepository.findAll();
    }

    @Override
    public boolean deleteAllItem() {
        cartRepository.deleteAll();
        return true;
    }

    @Override
    public Cart getCartItemByItemId(int itemId) {
        return cartRepository.findByItemId(itemId);
    }

}
