package com.foodieapp.favoriteService.service;

import com.foodieapp.favoriteService.domain.Favorite;
import com.foodieapp.favoriteService.exception.RestaurantAlreadyExits;
import com.foodieapp.favoriteService.exception.RestaurantNotFound;
import com.foodieapp.favoriteService.repository.FavouriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavServiceImpl implements FavService{
    private FavouriteRepository favouriteRepository;
    @Autowired

    public FavServiceImpl(FavouriteRepository favouriteRepository) {
        this.favouriteRepository = favouriteRepository;
    }

    @Override
    public Favorite addFavorite(Favorite favorite)throws RestaurantAlreadyExits {
        if (favouriteRepository.findById(favorite.getItemId()).isPresent()){
                throw  new RestaurantAlreadyExits();
        }
        return favouriteRepository.save(favorite);
    }

    @Override
    public boolean deleteFavorite(int itemId)throws RestaurantNotFound {
        boolean result=false;
        if (favouriteRepository.findById(itemId).isEmpty()){
            throw new RestaurantNotFound();
        }else {
            favouriteRepository.deleteById(itemId);

            result=true;
        }
        return result;
    }

    @Override
    public List<Favorite> getAllFavourite() throws RestaurantNotFound {
        return favouriteRepository.findAll();
    }

    @Override
    public Favorite getAllFavouriteItems() throws RestaurantNotFound {
        Favorite favorite=new Favorite();

        List<Favorite> favoriteList=new ArrayList<>();

        favoriteList.add(favorite);

        return favorite;
    }
}
