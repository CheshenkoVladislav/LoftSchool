package com.example.vladislav.myapplication.ItemListAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.vladislav.myapplication.Item;
import com.example.vladislav.myapplication.R;

/**
 * Created by vladislav on 18.03.18.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder{
    private static TextView holderName;
    private static TextView holderPrice;
    public ItemViewHolder(View itemView) {
        super(itemView);
        holderName = itemView.findViewById(R.id.nameView);
        holderPrice = itemView.findViewById(R.id.priceView);
    }
    static void applyData(Item item) {
        String forAddRubleSign = String.valueOf(holderPrice.getText());
        holderName.setText(item.getName());
        holderPrice.setText(String.format(forAddRubleSign,item.getPrice()));
    }
}
