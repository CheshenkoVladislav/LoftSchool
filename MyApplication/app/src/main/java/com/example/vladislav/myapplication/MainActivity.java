package com.example.vladislav.myapplication;

import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.vladislav.myapplication.ItemListAdapter.MainPageAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    private App app;
    private static final String TAG = "MainActivity";
    private List<Item> itemList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.pager);
        MainPageAdapter adapter = new MainPageAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        TabLayout tabItem = findViewById(R.id.tab);
        tabItem.setupWithViewPager(pager);
    }
}
