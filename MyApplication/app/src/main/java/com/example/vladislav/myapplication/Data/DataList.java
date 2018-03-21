package com.example.vladislav.myapplication.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladislav on 20.03.18.
 */

public class DataList {
    private String status;
    private List<Data> data;
    public void setStatus(String status){this.status = status;}
    public String getStatus(){
        return this.status;
    }
    public void setData(List<Data> data){
        this.data = data;
    }
    public List<Data> getData(){
        return this.data;
    }
}
