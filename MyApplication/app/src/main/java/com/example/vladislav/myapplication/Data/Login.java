package com.example.vladislav.myapplication.Data;

import com.google.gson.annotations.SerializedName;

public class Login {

    private String status;

    private int id;

    @SerializedName("auth_token")
    private String token;

    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setAuth_token(String token){
        this.token = token;
    }
    public String getToken(){
        return this.token;
    }
}
