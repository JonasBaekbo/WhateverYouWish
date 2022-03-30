package com.example.whateveryouwish;

import java.util.ArrayList;

public class ListOfWish {

    private ArrayList<Wish> wishes = new ArrayList<>();

    public void addwish(String itemName, String description, int quantity, int id){
        wishes.add(new Wish(itemName,description,quantity,id));
    }

    public String getWish(){

        String[] stringAsArray = new String[4];
        stringAsArray[0] = String.valueOf(wishes.get(0));
        stringAsArray[1] = String.valueOf(wishes.get(1));
        stringAsArray[2] = String.valueOf(wishes.get(2));
        stringAsArray[3] = String.valueOf(wishes.get(3));
        return stringAsArray[1];
    }
}
