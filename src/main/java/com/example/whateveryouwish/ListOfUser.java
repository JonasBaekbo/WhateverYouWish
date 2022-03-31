package com.example.whateveryouwish;

import java.util.ArrayList;

public class ListOfUser {


    private ArrayList<User> users = new ArrayList<>();

    public void addUser(String username, String password){

        users.add(new User(username, password));
    }

    public String getWish(){

        String[] stringAsArray = new String[4];
        stringAsArray[0] = String.valueOf(users.get(0));
        stringAsArray[1] = String.valueOf(users.get(1));
        stringAsArray[2] = String.valueOf(users.get(2));
        stringAsArray[3] = String.valueOf(users.get(3));
        return stringAsArray[1];
    }

    @Override
    public String toString() {
        return "ListOfUsers: " + users;
    }
}

