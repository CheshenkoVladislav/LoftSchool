package com.example.vladislav.myapplication;

/**
 * Created by vladislav on 14.03.18.
 */

public class Item {
    public final static String TYPE_EXPENSES = "expenses";
    public final static String TYPE_INCOMES = "incomes";
    public final static String TYPE_UNKNOWN = "unknown";

    private String type;
    private String name;
    private int price;

    public int getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }

    public Item(String type, String name, int price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
}
