package com.foodieapp.favoriteService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Favorite {
    @Id
    private int itemId;
    private String itemName;
    private String restaurantName;
    private String restaurantAddress;
    private String rating;
    private String imagePath;


    public Favorite() {
    }

    public Favorite(String restaurantName, String restaurantAddress, int itemId,
                    String imagePath, String rating,String itemName) {
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.itemId = itemId;
        this.imagePath = imagePath;
        this.rating = rating;
        this.itemName=itemName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }


    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantAddress='" + restaurantAddress + '\'' +
                ", rating='" + rating + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
