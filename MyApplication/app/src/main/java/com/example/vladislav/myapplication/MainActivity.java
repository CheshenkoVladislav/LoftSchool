package com.example.vladislav.myapplication;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.vladislav.myapplication.Data.Data;
import com.example.vladislav.myapplication.ItemListAdapter.MainPageAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private ViewPager pager;
    static FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab = findViewById(R.id.fab);
        pager = findViewById(R.id.pager);
        MainPageAdapter adapter = new MainPageAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(this);
        System.out.println((pager.getCurrentItem()));
        TabLayout tabItem = findViewById(R.id.tab);
        tabItem.setupWithViewPager(pager);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        if (position == 2)fab.hide();
        else fab.show();
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}
