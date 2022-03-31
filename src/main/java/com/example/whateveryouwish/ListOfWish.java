package com.example.whateveryouwish;

import java.util.ArrayList;

public class ListOfWish {

    DB db = new DB();

    private ArrayList<Wish> wishes = new ArrayList<>();

    public void addwish(String itemName, String description, int quantity){
        Wish wish = new Wish(itemName,description,quantity);
        wishes.add(wish);
        db.addWishToDB(wish);
    }

    @Override
    public String toString() {
        return "listofwhishes:" +wishes;
    }
}
