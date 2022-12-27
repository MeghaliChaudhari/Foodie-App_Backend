package com.foodieapp.cartservice.repository;

import com.foodieapp.cartservice.domain.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart,Integer> {
    Cart findByItemId(int itemId);
}
