package com.example.vladislav.myapplication.Interfaces;

import com.example.vladislav.myapplication.Data.Item;
import com.example.vladislav.myapplication.Data.ItemList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by vladislav on 19.03.18.
 */

public interface Api {
    @GET ("items")
    Call<ItemList> getItems(@Query("type")String type);

    @POST("items/add")
    Call<Item> addItems(@Body Item item);
}
