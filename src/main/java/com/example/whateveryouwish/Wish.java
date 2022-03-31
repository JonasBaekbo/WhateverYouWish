package com.example.whateveryouwish;

public class Wish {

    private String itemName;
    private String description;
    private int quantity;
    private int id;

    public Wish(String itemName, String description, int quantity){
        this.itemName = itemName;
        this.description = description;
        this.quantity = quantity;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return itemName + ";" +description + ";" + quantity;
    }
}
