package com.foodieapp.menuService.domain;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Item {
    @Id
    private  int itemId;
    private  String itemName;
    private double itemPrice;
    private String itemType;
    private String description;
    private String restaurantName;
    private String restaurantAddress;
    private String rating;
    private String imagePath;

    public Item(){}

    public Item(int itemId, String itemName, double itemPrice, String itemType,
                String description, String restaurantName, String restaurantAddress,
                String rating, String imagePath) {

        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemType = itemType;
        this.description = description;
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.rating = rating;
        this.imagePath = imagePath;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemType='" + itemType + '\'' +
                ", description='" + description + '\'' +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantAddress='" + restaurantAddress + '\'' +
                ", rating='" + rating + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
