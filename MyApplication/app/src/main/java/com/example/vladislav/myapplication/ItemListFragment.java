package com.example.vladislav.myapplication;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.support.v7.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.vladislav.myapplication.Data.Data;
import com.example.vladislav.myapplication.Data.DataList;
import com.example.vladislav.myapplication.Interfaces.AdapterListenerInterface;
import com.example.vladislav.myapplication.ItemListAdapter.ItemListAdapter;
import com.example.vladislav.myapplication.ItemListAdapter.MainPageAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemListFragment extends Fragment {
    private static final String TAG = "ItemListFragment";
    private RecyclerView recyclerView;
    public Api api;
    private String type;
    ItemListAdapter adapter = new ItemListAdapter();
    SwipeRefreshLayout refresh;
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
        refresh = view.findViewById(R.id.refresh);
        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);
        dataInsert();
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                dataInsert();
            }
        });
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
                refresh.setRefreshing(false);
            }
        });
    }

    ActionMode actionMode;
    private class AdapterListener implements AdapterListenerInterface {

        @Override
        public void onClick() {
            if (inActionMode());

        }

        @Override
        public void onLongClick() {
            if (!inActionMode()) actionMode = ((AppCompatActivity)getActivity()).startSupportActionMode(callback);
        }
        ActionMode.Callback callback = new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                actionMode = mode;
                MenuInflater inflater = new MenuInflater(getContext());
                inflater.inflate(R.menu.menu_action_mode,menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                quitActionMode();
            }
        };
    }
    boolean inActionMode(){
        return actionMode != null;
    }
    void quitActionMode(){
        actionMode.finish();
        actionMode = null;
    }
}
