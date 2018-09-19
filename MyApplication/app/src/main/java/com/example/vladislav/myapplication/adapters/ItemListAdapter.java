package com.example.vladislav.myapplication.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vladislav.myapplication.Data.Item;
import com.example.vladislav.myapplication.Interfaces.listener.AdapterListenerInterface;
import com.example.vladislav.myapplication.api.RealApiLoftSchool;
import com.example.vladislav.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vladislav on 17.03.18.
 */

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {
    private List<Item> itemList = new ArrayList<>();
    private AdapterListenerInterface listener;
    private static final String TAG = "ItemListAdapter";
    private RealApiLoftSchool apiLoftSchool;

    public void setListener(AdapterListenerInterface listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.applyData(item,position,listener,selections.get(position,false));
    }
    @Override
    public int getItemCount() {
        try{
            return itemList.size();

        }catch (NullPointerException n){
            return 0;
        }
    }

    public void setItem(List<Item> data) {
        itemList = data;
        notifyDataSetChanged();
    }
    public void addItem(Item newItem){
//        apiLoftSchool = App.getApiLoftSchool();
    }
    SparseBooleanArray selections = new SparseBooleanArray();

    public void toggleSelections(int position){
            if (selections.get(position,false)) {
                selections.delete(position);}
            else {selections.put(position,true);}
            notifyItemChanged(position);
    }
    public void clearSelections(){
        selections.clear();
        notifyDataSetChanged();
    }
    public List<Integer> getSelectedItems(){
        List<Integer>selectedItems = new ArrayList<>();
        for (int i = 0; i < selections.size(); i++) {
            selectedItems.add(selections.keyAt(i));
        }
        return selectedItems;
    }

    public Item remove(int position){
        final Item item = itemList.remove(position);
        System.out.println(item.getId());
        notifyItemRemoved(position);
        return item;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView holderName;
        private TextView holderPrice;

        public ItemViewHolder(View itemView) {
            super(itemView);
            holderName = itemView.findViewById(R.id.nameView);
            holderPrice = itemView.findViewById(R.id.priceView);
        }
        public void applyData(final Item item, final int position, final AdapterListenerInterface listener, final boolean selected) {
            holderName.setText(item.getName());
            holderPrice.setText(String.valueOf(item.getPrice()) + " \u20BD");
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println(selected);
                    listener.onClick(item,position);
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    System.out.println(selected);
                    listener.onLongClick(item,position);
                    return true;
                }
            });
            itemView.setActivated(selected);
        }
    }
}