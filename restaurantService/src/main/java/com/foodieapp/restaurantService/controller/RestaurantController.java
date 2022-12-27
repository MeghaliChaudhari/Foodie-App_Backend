package com.foodieapp.restaurantService.controller;

import com.foodieapp.restaurantService.domain.Item;
import com.foodieapp.restaurantService.domain.Restaurant;
import com.foodieapp.restaurantService.exception.ItemAlreadyExistException;
import com.foodieapp.restaurantService.exception.ItemNotFoundException;
import com.foodieapp.restaurantService.exception.RestaurantAlreadyExistException;
import com.foodieapp.restaurantService.exception.RestaurantNotFoundException;
import com.foodieapp.restaurantService.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/restaurant/v1/")
public class RestaurantController {

    private ResponseEntity responseEntity;
    private RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService)
    {
        this.restaurantService=restaurantService;
    }

    //  http://localhost:9088/restaurant/v1/restaurant/addRestaurant
    @PostMapping("/restaurant/addRestaurant")
    public ResponseEntity<?> addRestaurant(@RequestBody Restaurant restaurant) throws  RestaurantAlreadyExistException
    {
        Restaurant restaurant1=restaurantService.addRestaurant(restaurant);
        responseEntity=new ResponseEntity<>(restaurant1, HttpStatus.CREATED);
        return responseEntity;
    }


    //  http://localhost:9088/restaurant/v1/restaurant/delete/{restaurantId}/{itemId}
    @DeleteMapping("/restaurant/delete/{restaurantId}/{itemId}")
    public ResponseEntity<?> deleteRestaurant(@PathVariable("restaurantId") int restaurantId, @PathVariable int itemId) throws RestaurantNotFoundException, ItemNotFoundException {

        try{
//            restaurantService.deleteRestaurant(restaurantId);
            responseEntity=new ResponseEntity<>(restaurantService.deleteRestaurant(restaurantId,itemId),HttpStatus.OK);

        }catch (RestaurantNotFoundException e){

            throw new RestaurantNotFoundException();

        }catch (ItemNotFoundException e){
            throw new ItemNotFoundException();
            //responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }


    //  http://localhost:9088/restaurant/v1/restaurant/{restaurantName}
    @GetMapping("/restaurant/{restaurantName}")
    public ResponseEntity<?> getAllRestaurantByRestaurantName(@PathVariable String restaurantName) throws RestaurantNotFoundException {
        try {
            responseEntity = new ResponseEntity(restaurantService.getAllRestaurantByRestaurantName(restaurantName), HttpStatus.CREATED);

        } catch ( RestaurantNotFoundException e) {
            throw new RestaurantNotFoundException();
        }
        catch (Exception e)
        {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    //  http://localhost:9088/restaurant/v1/restaurant/addMenu/{restaurantId}
    @PutMapping("/restaurant/addMenu/{restaurantId}")
    public ResponseEntity<?> addItemForRestaurant(@PathVariable int restaurantId, @RequestBody Item item) throws ItemAlreadyExistException {

        try{
            //Restaurant restaurant =restaurantService.addMenuForRestaurant(restaurantId, item);
            responseEntity=new ResponseEntity<>(restaurantService.addMenuForRestaurant(restaurantId, item),HttpStatus.OK);

        } catch (ItemAlreadyExistException e) {
            throw new ItemAlreadyExistException();
        }

        return responseEntity;
    }



//    {
//        "itemId": 25,
//            "itemName": "Paneer Cheese Pizza",
//            "itemPrice": 249,
//            "itemType": "Pizza",
//            "description": "Full paneer pizza",
//            "imagePath": "https://www.vegrecipesofindia.com/wp-content/uploads/2018/05/paneer-pizza-recipe-1.jpg"
//    }

    //  http://localhost:9088/restaurant/v1/{restaurantId}
    @GetMapping("/{restaurantId}")
    public ResponseEntity<?> getAllItemsByRestaurantId(@PathVariable int restaurantId){

        responseEntity=new ResponseEntity<>(restaurantService.getAllRestaurantItems(restaurantId),HttpStatus.CREATED);
        return responseEntity;
    }

//  http://localhost:9088/restaurant/v1/getAllRestaurant
    @GetMapping("/getAllRestaurant")
    public ResponseEntity<?> getAllRestaurant(){
        responseEntity=new ResponseEntity<>(restaurantService.getAllRestaurant(),HttpStatus.CREATED);
        return responseEntity;
    }

  //  http://localhost:9088/restaurant/v1/getRest/{data}
    @GetMapping(path = "/getRest/{data}")
    public ResponseEntity<?> getRestaurants(@PathVariable(value = "data") String restId)throws RestaurantNotFoundException{
        System.out.println("hello");
        String[] x = restId.split(",");
        int[] y = Arrays.stream(x).mapToInt(Integer::parseInt).toArray();
        List<Restaurant> restaurantList = restaurantService.getRestaurants(y);
        return responseEntity = new ResponseEntity(restaurantList,HttpStatus.OK);
    }

    //  http://localhost:9088/restaurant/v1/restaurant/delete/{restaurantId}
    @DeleteMapping("/restaurant/delete/{restaurantId}")
    public ResponseEntity<?> deleteSingleRestaurant(@PathVariable int restaurantId) throws RestaurantNotFoundException {
        try{
         responseEntity= new ResponseEntity<>(restaurantService.deleteSingleRestaurant(restaurantId),HttpStatus.OK)  ;
        }catch (RestaurantNotFoundException e){
            throw new RestaurantNotFoundException();
        }catch (Exception e){
            responseEntity=new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    // http://localhost:9088/restaurant/v1/items/{itemId}
//    @GetMapping("/items/{itemId}")
//    public ResponseEntity<?> getItemByItemId(@PathVariable int itemId ) throws ItemNotFoundException {
//        Item item = restaurantService.getSingleItem(itemId);
//        responseEntity=new ResponseEntity<>(item,HttpStatus.OK);
//        return responseEntity;
//    }

}
