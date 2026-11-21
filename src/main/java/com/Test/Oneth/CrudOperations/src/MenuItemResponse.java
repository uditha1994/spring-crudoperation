package com.Test.Oneth.CrudOperations.src;

public class MenuItemResponse {
    //send back to client
    //Getters only

    private int id;
    private String name;
    private double price;
    private boolean available;
    private String priceLabel;

    public MenuItemResponse(int id, String name, double price, boolean available){
        this.id = id;
        this.name = name;
        this.price = price;
        this.available = available;
        this.priceLabel = "LKR. "+ price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getPriceLabel() {
        return priceLabel;
    }
}
