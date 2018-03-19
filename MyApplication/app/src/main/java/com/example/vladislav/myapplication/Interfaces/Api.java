package com.example.vladislav.myapplication.Interfaces;

import com.example.vladislav.myapplication.App;
import com.example.vladislav.myapplication.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by vladislav on 18.03.18.
 */

public interface Api {
    @GET ("/items?type=<”expense”,”income”>")
    Call<List<Item>> getIncomesAndExpenses(Item item);
}
