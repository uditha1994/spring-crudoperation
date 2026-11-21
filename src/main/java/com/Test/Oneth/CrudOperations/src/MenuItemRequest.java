package com.Test.Oneth.CrudOperations.src;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class MenuItemRequest {

    @NotBlank(message = "Name is required;")
    private String name;

    @Positive(message = "price must be greater than zero")
    private double price;

    private boolean available;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
