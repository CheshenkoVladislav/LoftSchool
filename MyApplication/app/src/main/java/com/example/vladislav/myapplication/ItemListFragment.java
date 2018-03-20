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

import com.example.vladislav.myapplication.API.Api;
import com.example.vladislav.myapplication.ItemListAdapter.ItemListAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemListFragment extends Fragment {
    private RecyclerView recyclerView;
    private App app;
    ItemListAdapter adapter = new ItemListAdapter();
    private static final String TAG = "ItemListFragment";
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataInsert();
        Log.d(TAG, "onCreate: HELLOwORLD");
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
    public void dataInsert() {
        Call<List<Item>> call = app.getApi().getItems();
        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                adapter.setData(response.body());
            }
            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
            }
        });
    }
}
