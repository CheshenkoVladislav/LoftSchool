package com.example.vladislav.myapplication;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vladislav.myapplication.ItemListAdapter.ItemListAdapter;

public class ItemListFragment extends Fragment {
    RecyclerView recyclerView;
    ItemListAdapter adapter = new ItemListAdapter();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ItemListAdapter.setData();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list,container,false);
        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);
    }
    public static ItemListFragment setInstance(){
        Bundle bundle = new Bundle();
        ItemListFragment itemListActivity = new ItemListFragment();
        itemListActivity.setArguments(bundle);
        return itemListActivity;
    }
}
