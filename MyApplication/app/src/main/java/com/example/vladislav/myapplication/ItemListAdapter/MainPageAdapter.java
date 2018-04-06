package com.example.vladislav.myapplication.ItemListAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.vladislav.myapplication.BalanceFragment;
import com.example.vladislav.myapplication.ItemListFragment;
import com.example.vladislav.myapplication.MainActivity;

public class MainPageAdapter extends FragmentPagerAdapter {
    private static final String TAG = "MainPageAdapter";
    private String[]tabs = new String[]{"Расходы", "Доходы", "Баланс"};
    public  static String TYPE_EXPENSE = "expense";
    public static String TYPE_INCOME = "income";
    public static String TYPE_BALANCE = "balance";
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
                return BalanceFragment.createItemsFragment(TYPE_BALANCE);
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
