package com.example.vladislav.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vladislav.myapplication.Data.Data;
import com.example.vladislav.myapplication.Data.DataList;
import com.example.vladislav.myapplication.ItemListAdapter.ItemListAdapter;
import com.example.vladislav.myapplication.ItemListAdapter.MainPageAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemListFragment extends Fragment {
    List<Data> dataList = new ArrayList<>();
    public static final String TYPE_KEY = "type";
    public static final int ADD_REQUEST_CODE = 123;
    private static final String TAG = "ItemListFragment";
    private RecyclerView recyclerView;
    public Api api;
    private String type;
    private FloatingActionButton fab;
    private SwipeRefreshLayout refresh;
    ItemListAdapter adapter = new ItemListAdapter();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = App.getApi();
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
        fab = view.findViewById(R.id.fab);
        recyclerView = view.findViewById(R.id.recycler);
        refresh = view.findViewById(R.id.refresh);
        if (type == MainPageAdapter.TYPE_UNKNOWN)fab.hide();
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);
        dataInsert();
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                dataInsert();
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),AddItemActivity.class);
                intent.putExtra(TYPE_KEY,type);
                startActivityForResult(intent,ADD_REQUEST_CODE);
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            Data newData = (Data) data.getSerializableExtra(TYPE_KEY);
            adapter.addNewItem(newData);

        }
    }
    public static ItemListFragment createItemsFragment(String type){
        ItemListFragment fragment = new ItemListFragment();
        fragment.type = type;
        return fragment;
    }
    public void dataInsert() {
        Call<DataList>call = api.getItems(type);
        call.enqueue(new Callback<DataList>() {
            @Override
            public void onResponse(Call<DataList> call, Response<DataList> response) {
                adapter.setData(response.body());
                refresh.setRefreshing(false);
            }
            @Override
            public void onFailure(Call<DataList> call, Throwable t) {
            }
        });
    }
//    public void addData(){
//        for (int i = 0; i < 40; i++) {
//            dataList.add((new Data("" + i,i+1)));
//        }
//        adapter.setData(dataList);
//    }
}
