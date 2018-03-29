package com.example.vladislav.myapplication.Data;

import java.util.List;

/**
 * Created by vladislav on 20.03.18.
 */

public class ItemList {
    private String status;
    private List<Item> data;
    public void setStatus(String status){this.status = status;}
    public String getStatus(){
        return this.status;
    }
    public void setData(List<Item> data){
        this.data = data;
    }
    public List<Item> getData(){
        return this.data;
    }
}
