package com.example.vladislav.myapplication.Data;

/**
 * Created by vladislav on 20.03.18.
 */

public class LoftData {

    private int id;

    private String name;

    private int price;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public int getPrice(){
        return this.price;
    }
}
