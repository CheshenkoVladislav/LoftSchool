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
    private static String typeFragment = MainPageAdapter.TYPE_EXPENSE;
    private static final int ADD_ITEM_REQUEST = 123;
    public static final String TYPE_KEY = "type";
    public static final String ITEM_KEY = "item";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab = findViewById(R.id.fab);
        pager = findViewById(R.id.pager);
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
    protected void onResume() {
        super.onResume();
        if (SignInActivity.account == null) {
            Intent checksignIn = new Intent(this, SignInActivity.class);
            startActivity(checksignIn);
        }else initFragments();
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
        if (ItemListFragment.inActionMode())ItemListFragment.getActionMode().finish();
        if (position == 0) {
            fab.show();
            typeFragment = MainPageAdapter.TYPE_EXPENSE;
        }
        else if (position == 1){
            fab.show();
            typeFragment = MainPageAdapter.TYPE_INCOME;
        }
        else if (position == 2){
            fab.hide();
            typeFragment = MainPageAdapter.TYPE_UNKNOWN;
        }
//        switch (position){      : НЕ КОРРЕКТНО РАБОТАЕТ
//            case 0:{
//                fab.show();
//                typeFragment = MainPageAdapter.TYPE_EXPENSE;
//            }
//            case 1:{
//                fab.show();
//                typeFragment = MainPageAdapter.TYPE_INCOME;
//            }
//            case 2:{
//                fab.hide();
//                typeFragment = MainPageAdapter.TYPE_UNKNOWN;
//            }
//        }
    }
    @Override
    public void onPageScrollStateChanged(int state) {
    }
    private void initFragments() {
        if (((App)getApplication()).isLogin()) {
            MainPageAdapter adapter = new MainPageAdapter(getSupportFragmentManager());
            pager.setAdapter(adapter);
        }
    }
}
