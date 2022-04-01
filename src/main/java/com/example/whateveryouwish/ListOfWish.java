package com.example.whateveryouwish;

import java.util.ArrayList;

public class ListOfWish {

    DB db = new DB();


    public void addwish(String itemName, String description, int quantity, int userID){
        Wish wish = new Wish(itemName,description,quantity,userID);
        db.addWishToDB(wish);
    }

}
