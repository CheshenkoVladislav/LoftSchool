package com.example.vladislav.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemListActivity extends AppCompatActivity {
    static List<Item> itemList = new ArrayList<>();
    RecyclerView recyclerView;
    ItemAdapter adapter = new ItemAdapter();
    String forAddRubleSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_list);
        setData();
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        }

    private void setData() {
        for (int i = 0; i < 10; i++) {
            itemList.add(new Item(i + " ", i));
        }
    }
    class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activity, parent, false);
            return new ItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ItemViewHolder holder, int position) {
            Item item = ItemListActivity.itemList.get(position);
            holder.applyData(item);
        }

        @Override
        public int getItemCount() {
            return ItemListActivity.itemList.size();
        }

    }
    private class ItemViewHolder extends RecyclerView.ViewHolder{

        private TextView holderName;
        private TextView holderPrice;

        public ItemViewHolder(View itemView) {
            super(itemView);
            holderName = itemView.findViewById(R.id.nameView);
            holderPrice = itemView.findViewById(R.id.priceView);
        }

        private void applyData(Item item) {
            forAddRubleSign = getResources().getString(R.string.price);
            holderName.setText(item.getName());
            holderPrice.setText(String.format(forAddRubleSign,item.getPrice()));
        }
    }

}
