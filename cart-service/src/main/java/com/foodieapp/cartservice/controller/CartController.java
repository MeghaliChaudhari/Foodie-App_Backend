package com.foodieapp.cartservice.controller;

import com.foodieapp.cartservice.domain.Cart;
import com.foodieapp.cartservice.exception.ItemAlreadyExists;
import com.foodieapp.cartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/cart")
public class CartController {
    private CartService cartService;
@Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    //  http://localhost:9003/cart/addToCart
    @PostMapping("/addToCart")
    public ResponseEntity<?> saveItem(@RequestBody Cart cart) throws ItemAlreadyExists {
        ResponseEntity responseEntity=null;

    try {
        responseEntity = new ResponseEntity<>(cartService.addItem(cart), HttpStatus.CREATED);
    }catch (ItemAlreadyExists e){
        throw new ItemAlreadyExists();
    }catch (Exception e){
        responseEntity=new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
        return responseEntity;
    }

    //  http://localhost:9003/cart/getCartItems
    @GetMapping("/getCartItems")
    public ResponseEntity<?> getAllCartItem(){
        return new ResponseEntity<>(cartService.getAllItem(),HttpStatus.OK);
    }

    //  http://localhost:9003/cart/delete/itemId
    @DeleteMapping("/delete/{itemId}")
    public ResponseEntity<?> deleteCartItem(@PathVariable int itemId){
    return new ResponseEntity<>(cartService.deleteItem(itemId),HttpStatus.OK);

    }

    //  http://localhost:9003/cart/deleteAll
    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllCart(){
    return new ResponseEntity<>(cartService.deleteAllItem(),HttpStatus.OK);
    }


    //  http://localhost:9003/cart/items/itemId
    @GetMapping("/items/{itemId}")
    public ResponseEntity<?> getCartItemByItemId(@PathVariable int itemId ){
        Cart item = cartService.getCartItemByItemId(itemId);
        return  new ResponseEntity<>(item,HttpStatus.OK);
    }
}
