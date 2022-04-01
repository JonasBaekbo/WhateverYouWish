package com.example.whateveryouwish;

public class addWishTooDB {

    DB db = new DB();

    public void addwish(String itemName, String description, int quantity, int userID){
        Wish wish = new Wish(itemName,description,quantity,userID);
        db.addWishToDB(wish);
    }
}