package com.example.vladislav.myapplication.ItemListAdapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.vladislav.myapplication.Data.Item;
import com.example.vladislav.myapplication.Data.ItemList;
import com.example.vladislav.myapplication.Interfaces.AdapterListenerInterface;
import com.example.vladislav.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladislav on 17.03.18.
 */

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {
    private List<Item> itemList = new ArrayList<>();
    private AdapterListenerInterface listener;

    public void setListener(AdapterListenerInterface listener){
        this.listener = listener;
    }
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        return new ItemViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.applyData(item,position,listener,selections.get(position,false));
    }
    @Override
    public int getItemCount() {
        return itemList.size();
    }
    public void setItem(ItemList data) {
        itemList = data.getData();
        notifyDataSetChanged();
    }
    public void addItem(Item newItem){
        itemList.add(newItem);
        notifyItemChanged(itemList.size()-1);
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