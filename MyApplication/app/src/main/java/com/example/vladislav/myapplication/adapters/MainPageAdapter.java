package com.example.vladislav.myapplication.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.vladislav.myapplication.fragment.BalanceFragment;
import com.example.vladislav.myapplication.fragment.ItemListFragment;

import static com.example.vladislav.myapplication.Support.Constants.TYPE_BALANCE;
import static com.example.vladislav.myapplication.Support.Constants.TYPE_EXPENSE;
import static com.example.vladislav.myapplication.Support.Constants.TYPE_INCOME;

public class MainPageAdapter extends FragmentPagerAdapter {
    private static final String TAG = "MainPageAdapter";
    private String[]tabs = new String[]{"Расходы", "Доходы", "Баланс"};
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
                return BalanceFragment.newInstance(TYPE_BALANCE);
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
