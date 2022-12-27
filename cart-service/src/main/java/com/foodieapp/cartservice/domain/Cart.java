package com.foodieapp.cartservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cart {
    @Id
    private int itemId;
    private String itemName;
    private double itemPrice;
    private String description;
    private String imagePath;
    private String itemType;
    private int quantity;

    public Cart() {
    }

    public Cart(int itemId, String itemName, int itemPrice, String description, String imagePath, String itemType, int quantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.description = description;
        this.imagePath = imagePath;
        this.itemType = itemType;
        this.quantity = quantity;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", description='" + description + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", itemType='" + itemType + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
