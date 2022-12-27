package com.foodieapp.favoriteService.controller;

import com.foodieapp.favoriteService.domain.Favorite;
import com.foodieapp.favoriteService.exception.RestaurantAlreadyExits;
import com.foodieapp.favoriteService.exception.RestaurantNotFound;
import com.foodieapp.favoriteService.service.FavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/fav")
public class FavController {
    private ResponseEntity responseEntity;
    private FavService favService;

    @Autowired
    public FavController(FavService favService) {
        this.favService = favService;
    }

    // http://localhost:8099/api/v1/fav/addfav
    @PostMapping("/addfav")
    public ResponseEntity<?> addFavService(@RequestBody Favorite favorite) throws RestaurantAlreadyExits {
        Favorite favorite1 = favService.addFavorite(favorite);
        responseEntity = new ResponseEntity<>(favorite1, HttpStatus.CREATED);
        return responseEntity;
    }

    // http://localhost:8099/api/v1/fav/delete/{itemId}
    @DeleteMapping("/delete/{itemId}")
    public ResponseEntity<?> deleteCustomerFav(@PathVariable("itemId") int itemId) throws RestaurantNotFound {
        try {
            favService.deleteFavorite(itemId);
            responseEntity = new ResponseEntity<>("Succesfully Deleted 1 record", HttpStatus.OK);
        } catch (RestaurantNotFound e) {
            throw new RestaurantNotFound();
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    // http://localhost:8099/api/v1/fav/getAllFavourites
    @GetMapping("/getAllFavourites")
    public ResponseEntity<?>getAllFavourites () throws RestaurantNotFound{
        List<Favorite> allFavourite = favService.getAllFavourite();
        responseEntity=new ResponseEntity<>(allFavourite,HttpStatus.OK);
        return responseEntity;
    }
}
