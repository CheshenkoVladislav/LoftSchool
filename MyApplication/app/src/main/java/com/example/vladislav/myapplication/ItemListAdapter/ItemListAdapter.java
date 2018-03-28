package com.example.vladislav.myapplication.ItemListAdapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vladislav.myapplication.App;
import com.example.vladislav.myapplication.Data.Data;
import com.example.vladislav.myapplication.Data.DataList;
import com.example.vladislav.myapplication.Data.LoftData;
import com.example.vladislav.myapplication.Interfaces.AdapterListenerInterface;
import com.example.vladislav.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladislav on 17.03.18.
 */

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {
    private List<Data> itemList = new ArrayList<>();
    private AdapterListenerInterface listener;
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        return new ItemViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Data item = itemList.get(position);
        holder.applyData(item,position);
    }
    @Override
    public int getItemCount() {
        return itemList.size();
    }
    public void setData(DataList data) {
        itemList = data.getData();
        notifyDataSetChanged();
    }
    SparseBooleanArray selections = new SparseBooleanArray();

    void toggleSelections(){
        for (int i = 0; i < itemList.size(); i++) {
            if (selections.get(i,false))
                selections.delete(i);
            else selections.put(i,true);
        }
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView holderName;
        private TextView holderPrice;

        public ItemViewHolder(View itemView) {
            super(itemView);
            holderName = itemView.findViewById(R.id.nameView);
            holderPrice = itemView.findViewById(R.id.priceView);
        }
        public void applyData(Data item, int position) {
            holderName.setText(item.getName());
            holderPrice.setText(String.valueOf(item.getPrice()));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick();
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onLongClick();
                    return true;
                }
            });
        }
    }
}