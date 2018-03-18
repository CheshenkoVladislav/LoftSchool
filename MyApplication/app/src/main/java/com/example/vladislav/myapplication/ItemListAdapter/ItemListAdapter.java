package com.example.vladislav.myapplication.ItemListAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vladislav.myapplication.Item;
import com.example.vladislav.myapplication.R;

import java.util.ArrayList;

/**
 * Created by vladislav on 17.03.18.
 */

public class ItemListAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private static ArrayList<Item> itemList = new ArrayList<>();
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        return new ItemViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.applyData(item);
    }
    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static void setData() {
        for (int i = 0; i < 10; i++) {
            itemList.add(new Item(i + " ", i));
        }
    }
}