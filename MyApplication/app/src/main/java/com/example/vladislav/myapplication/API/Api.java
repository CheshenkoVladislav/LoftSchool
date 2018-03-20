package com.example.vladislav.myapplication.API;

import com.example.vladislav.myapplication.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by vladislav on 19.03.18.
 */

public interface Api {
    @GET ("/items")
    Call<List<Item>> getItems();
}
