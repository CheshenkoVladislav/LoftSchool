package com.example.vladislav.myapplication.ItemListAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.vladislav.myapplication.ItemListFragment;

/**
 * Created by vladislav on 18.03.18.
 */

public class MainPageAdapter extends FragmentPagerAdapter {
    private String[]tabs;
    private String TYPE_EXPENSE = "expense";
    private String TYPE_INCOMES = "incomes";
    private String TYPE_UNKNOWN = "expense";
    public MainPageAdapter(FragmentManager fm) {
        super(fm);
        tabs = new String[]{
                "Расходы",
                "Доходы",
                "Баланс"};
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return ItemListFragment.createItemsFragment(TYPE_INCOMES);
            case 1:return ItemListFragment.createItemsFragment(TYPE_EXPENSE);
            case 2:return ItemListFragment.createItemsFragment(TYPE_UNKNOWN);
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
