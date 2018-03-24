package com.example.vladislav.myapplication.ItemListAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vladislav.myapplication.App;
import com.example.vladislav.myapplication.Data.Data;
import com.example.vladislav.myapplication.Data.DataList;
import com.example.vladislav.myapplication.Data.LoftData;
import com.example.vladislav.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladislav on 17.03.18.
 */

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {
    private List<Data> itemList = new ArrayList<>();
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        return new ItemViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Data item = itemList.get(position);
        holder.applyData(item);
    }
    @Override
    public int getItemCount() {
        return itemList.size();
    }
    public void setData(DataList data) {
        itemList = data.getData();
        notifyDataSetChanged();
    }

    public void addNewItem(Data newData) {
        itemList.add(newData);
        notifyItemInserted(itemList.size()-1);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView holderName;
        private TextView holderPrice;
        public ItemViewHolder(View itemView) {
            super(itemView);
            holderName = itemView.findViewById(R.id.nameView);
            holderPrice = itemView.findViewById(R.id.priceView);
        }
        public void applyData(Data item) {
            holderName.setText(item.getName());
            holderPrice.setText(String.valueOf(item.getPrice()));
        }
    }
}