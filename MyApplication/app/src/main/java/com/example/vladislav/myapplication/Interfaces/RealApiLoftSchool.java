package com.example.vladislav.myapplication.Interfaces;

import com.example.vladislav.myapplication.Data.Item;
import com.example.vladislav.myapplication.Data.ItemList;
import com.example.vladislav.myapplication.Data.Login;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RealApiLoftSchool {
    @GET("auth")
    Call<Login>getAuth(@Query("social_user_id")String userId, @Query("auth-token")String token);

    @GET ("items")
    Call<List<Item>> getItems(@Query("type")String type);
}
