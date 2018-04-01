package com.example.vladislav.myapplication.Interfaces;

import com.example.vladislav.myapplication.Data.Balance;
import com.example.vladislav.myapplication.Data.Item;
import com.example.vladislav.myapplication.Data.ItemList;
import com.example.vladislav.myapplication.Data.Login;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RealApiLoftSchool {
    @GET("auth")
    Call<Login>getAuth(@Query("social_user_id")String userId);

    @GET ("items")
    Call<List<Item>> getItems(@Query("type")String type, @Query("auth-token")String token);

    @GET ("balance")
    Call<Balance> getBalance();

    @POST ("items/add")
    Call<Item>addItems(@Query("price")int price,@Query("name")String name, @Query("type")String type, @Query("auth-token")String token);

    @POST ("items/remove")
    Call<Item>removeItems(@Query("id") int id);
}
