package com.foodieapp.restaurantService.service;

import com.foodieapp.restaurantService.domain.Item;
import com.foodieapp.restaurantService.domain.Restaurant;
import com.foodieapp.restaurantService.exception.ItemAlreadyExistException;
import com.foodieapp.restaurantService.exception.ItemNotFoundException;
import com.foodieapp.restaurantService.exception.RestaurantAlreadyExistException;
import com.foodieapp.restaurantService.exception.RestaurantNotFoundException;
import com.foodieapp.restaurantService.proxy.RestaurantProxy;
import com.foodieapp.restaurantService.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    private RestaurantRepository restaurantRepository;

    private RestaurantProxy restaurantProxy;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository,RestaurantProxy restaurantProxy)
    {
        this.restaurantRepository=restaurantRepository;
        this.restaurantProxy = restaurantProxy;
    }
    @Override
    public Restaurant addRestaurant(Restaurant restaurant) throws RestaurantAlreadyExistException {
        if(restaurantRepository.findById(restaurant.getRestaurantId()).isPresent()){
            throw new RestaurantAlreadyExistException();
        }
        return restaurantRepository.save(restaurant);
    }


    @Override
    public Restaurant deleteRestaurant( int restaurantId,int itemId) throws RestaurantNotFoundException, ItemNotFoundException {
        boolean result=false;
        if(restaurantRepository.findById(restaurantId).isEmpty()){
            throw new RestaurantNotFoundException();
        }
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        List<Item> items = restaurant.getItemList();
        result = items.removeIf(x -> x.getItemId() == itemId);
        if (!result){
            throw new ItemNotFoundException();
        }
        restaurant.setItemList(items);
        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurantByRestaurantName(String restaurantName) throws RestaurantNotFoundException {
        if(restaurantRepository.findAllRestaurantByRestaurantName(restaurantName).isEmpty())
        {
            throw new RestaurantNotFoundException();
        }
        return restaurantRepository.findAllRestaurantByRestaurantName(restaurantName);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }


    public Restaurant addMenuForRestaurant(int restaurantId, Item item){
        Restaurant restaurant1 = restaurantRepository.findByRestaurantId(restaurantId);
        if(restaurant1.getItemList() == null) {
            restaurant1.setItemList(Arrays.asList(item));
            //throw new ItemAlreadyExistException();
        }else {
            List<Item> itemList = restaurant1.getItemList();
            itemList.add(item);
            restaurant1.setItemList(itemList);
        }
        Restaurant addRestaurant = restaurantRepository.save(restaurant1);
        if (!(addRestaurant.getRestaurantId() == 0)){
            ResponseEntity re = restaurantProxy.addItem(item);
            System.out.println(re.getBody());
        }
        return addRestaurant;
    }

    @Override
    public List<Item> getAllRestaurantItems(int restaurantId) {
        return restaurantRepository.findByRestaurantId(restaurantId).getItemList();
    }

    @Override
    public List<Restaurant> getRestaurants(int[] restaurantId) throws RestaurantNotFoundException {
        System.out.println("Ok");
        List<Restaurant> list = new ArrayList<>();
        Arrays.stream(restaurantId).forEach(x->{
            Restaurant restaurant = restaurantRepository.findById(x).get();
            list.add(restaurant);
        });
        return list;
    }

    @Override
    public boolean deleteSingleRestaurant(int restaurantId) throws RestaurantNotFoundException {
        boolean result=false;
        if(restaurantRepository.findById(restaurantId).isEmpty()){
            throw new  RestaurantNotFoundException();
        }else {
            restaurantRepository.deleteById(restaurantId);
            result= true;
        }
        return result;
    }

    @Override
    public Item getSingleItem( int itemId) throws ItemNotFoundException {

        return restaurantRepository.findAllRestaurantItemsByItemId(itemId);
    }
}
