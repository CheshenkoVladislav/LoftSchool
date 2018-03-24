package com.example.vladislav.myapplication.ItemListAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.vladislav.myapplication.ItemListFragment;
public class MainPageAdapter extends FragmentPagerAdapter {
    private static final String TAG = "MainPageAdapter";
    private String[]tabs = new String[]{"Расходы", "Доходы", "Баланс"};
    public static final String TYPE_EXPENSE = "expense";
    public static final String TYPE_INCOME = "income";
    public static final String TYPE_UNKNOWN = null;
    public MainPageAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ItemListFragment.createItemsFragment(TYPE_EXPENSE);
            case 1:
                return ItemListFragment.createItemsFragment(TYPE_INCOME);
            case 2:
                return ItemListFragment.createItemsFragment(TYPE_UNKNOWN);
        }
        return null;
    }
    @Override
    public int getCount() {
        return tabs.length;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
