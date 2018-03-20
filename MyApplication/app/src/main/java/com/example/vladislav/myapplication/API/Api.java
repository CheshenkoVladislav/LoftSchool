package com.example.vladislav.myapplication.API;

import com.example.vladislav.myapplication.Data.Data;
import com.example.vladislav.myapplication.Data.DataList;
import com.example.vladislav.myapplication.Data.LoftData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by vladislav on 19.03.18.
 */

public interface Api {
    @GET ("items?type=<”expense”,”income”>")
    Call<DataList> getItems(@Query("type") String type);
}
