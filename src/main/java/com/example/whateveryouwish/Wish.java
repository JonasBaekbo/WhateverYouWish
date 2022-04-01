package com.example.whateveryouwish;

public class Wish {

    private int wishID;
    private String itemName;
    private String description;
    private int quantity;
    private int userID;

    public Wish(int wishID,String itemName, String description, int quantity, int userID) {
        this.wishID=wishID;
        this.itemName = itemName;
        this.description = description;
        this.quantity = quantity;
        this.userID = userID;
    }
    public Wish(String itemName, String description, int quantity, int userID) {
        this.itemName = itemName;
        this.description = description;
        this.quantity = quantity;
        this.userID = userID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUserId() {
        return userID;
    }

    public void setUserID(int id) {
        this.userID = userID;
    }

    public int getWishID() {
        return wishID;
    }

    public void setWishID(int wishID) {
        this.wishID = wishID;
    }

    @Override
    public String toString() {
        return itemName + ";" + description + ";" + quantity;
    }

}