package com.example.vladislav.myapplication;

import com.example.vladislav.myapplication.Data.Data;
import com.example.vladislav.myapplication.Data.DataList;
import com.example.vladislav.myapplication.Data.LoftData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by vladislav on 19.03.18.
 */

public interface Api {
    @GET ("items")
    Call<DataList> getItems(@Query("type")String type);

    @POST("items/add")
    void addItems(@Query("price")String price,@Query("name")String name,@Query("type")String type);
}
