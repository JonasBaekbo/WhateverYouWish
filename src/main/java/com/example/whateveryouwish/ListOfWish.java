package com.example.whateveryouwish;

import java.util.ArrayList;

public class ListOfWish {

    private ArrayList<Wish> wishes = new ArrayList<>();

    public void addwish(String itemName, String description, int quantity){
        wishes.add(new Wish(itemName,description,quantity));
    }

    @Override
    public String toString() {
        return "listofwhishes:" +wishes;
    }
}
