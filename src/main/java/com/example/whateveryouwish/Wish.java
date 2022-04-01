package com.example.whateveryouwish;

public class Wish {

    private int wishID;
    private String itemName;
    private String description;
    private int quantity;
    private int userID;

    public Wish(int wishID, String itemName, String description, int quantity, int userID) {
        this.wishID = wishID;
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

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getUserId() {
        return userID;
    }

    @Override
    public String toString() {
        return itemName + ";" + description + ";" + quantity;
    }

}