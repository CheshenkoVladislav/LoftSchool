package com.example.vladislav.myapplication;

import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vladislav.myapplication.ItemListAdapter.MainPageAdapter;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.pager);
        MainPageAdapter adapter = new MainPageAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        TabLayout tabItem = findViewById(R.id.tab);
        tabItem.setupWithViewPager(pager);
    }
}
