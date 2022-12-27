package com.foodieapp.favoriteService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Already Exits")
public class RestaurantAlreadyExits extends Exception{
}
