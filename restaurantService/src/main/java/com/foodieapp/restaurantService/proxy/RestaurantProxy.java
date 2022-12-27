package com.foodieapp.restaurantService.proxy;


import com.foodieapp.restaurantService.domain.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "menu-service",url = "http://menu-service:9001")
public interface RestaurantProxy {

    @PostMapping("/menu/addItem")
    public ResponseEntity<?> addItem(@RequestBody Item item);

}
