package com.example.vladislav.myapplication;

/**
 * Created by vladislav on 14.03.18.
 */

public class Item {
    private final String name;
    private final int price;
    public int getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
