package com.foodieapp.favoriteService.repository;

import com.foodieapp.favoriteService.domain.Favorite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteRepository extends MongoRepository<Favorite,Integer> {
        Favorite findByItemId(int itemId);
}
