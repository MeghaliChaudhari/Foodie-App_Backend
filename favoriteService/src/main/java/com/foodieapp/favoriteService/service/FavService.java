package com.foodieapp.favoriteService.service;

import com.foodieapp.favoriteService.domain.Favorite;
import com.foodieapp.favoriteService.exception.RestaurantAlreadyExits;
import com.foodieapp.favoriteService.exception.RestaurantNotFound;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FavService {

    Favorite addFavorite(Favorite favorite) throws RestaurantAlreadyExits;
    boolean deleteFavorite(int  itemId) throws RestaurantNotFound;

    List<Favorite> getAllFavourite() throws RestaurantNotFound;

    Favorite getAllFavouriteItems() throws RestaurantNotFound;
}
