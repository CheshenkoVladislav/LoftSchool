package com.example.vladislav.myapplication;


import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.vladislav.myapplication.ItemListAdapter.MainPageAdapter;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private static final String TAG = "MainActivity";
    private ViewPager pager;
    static FloatingActionButton fab;
    private static int currentPage;
    private static String typeFragment;
    private static final int ADD_ITEM_REQUEST = 123;
    public static final String TYPE_KEY = "type";
    public static final String ITEM_KEY = "item";
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
                Intent intent = new Intent(MainActivity.this,AddItemActivity.class);
                intent.putExtra(TYPE_KEY,typeFragment);
                startActivityForResult(intent,ADD_ITEM_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            fragment.onActivityResult(requestCode,resultCode,data);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        if (position == 0) typeFragment = MainPageAdapter.TYPE_EXPENSE;
        else if (position == 1)typeFragment = MainPageAdapter.TYPE_INCOME;
        else if (position == 2)typeFragment = MainPageAdapter.TYPE_UNKNOWN;

        if (position == 2)fab.hide();
        else fab.show();
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}
