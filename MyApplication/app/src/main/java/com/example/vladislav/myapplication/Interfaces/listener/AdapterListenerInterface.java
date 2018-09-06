package com.example.vladislav.myapplication.Interfaces.listener;

import com.example.vladislav.myapplication.Data.Item;

/**
 * Created by vladislav on 28.03.18.
 */

public interface AdapterListenerInterface {
    void onClick(Item item, int position);
    void onLongClick(Item item, int position);
    String getAuthToken();
}
