package com.example.vladislav.myapplication;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vladislav.myapplication.Data.Data;
import com.example.vladislav.myapplication.Data.DataList;
import com.example.vladislav.myapplication.ItemListAdapter.ItemListAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemListFragment extends Fragment {
    private static final String TAG = "ItemListFragment";
    private RecyclerView recyclerView;
    public Api api;
    private String type;
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
        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);
        dataInsert();
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
            }
            @Override
            public void onFailure(Call<DataList> call, Throwable t) {
            }
        });
    }
//    public void addData(){
//        Data da = new Data();
//        da.setName("My");
//        da.setPrice(500);
//        da.setType("income");
//        Log.d(TAG, "addData: +100500");
//        Call<Data>call = api.addItems(da);
//        Log.d(TAG, "addData: " + call.request());
//    }
}
