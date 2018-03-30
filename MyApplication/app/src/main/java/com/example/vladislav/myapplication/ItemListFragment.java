package com.example.vladislav.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.vladislav.myapplication.Data.Item;
import com.example.vladislav.myapplication.Data.ItemList;
import com.example.vladislav.myapplication.Interfaces.AdapterListenerInterface;
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
    SwipeRefreshLayout refresh;
    private static final int ADD_REQUEST_CODE = 123;
   public static final int RESULT_REQUEST_CODE = 234;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = App.getApi();
        adapter.setListener(new AdapterListener());
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
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ADD_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            Item newItem = (Item)data.getSerializableExtra(MainActivity.ITEM_KEY);
            if (newItem.getType().equals(getType())) {
                adapter.addItem(newItem);
            }
        }
        else if (requestCode == RESULT_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            int result = data.getExtras().getInt(ConfirmationDialog.RESULT_TYPE);
            if (result == -1){
                removeSelectionsItems();
                quitActionMode();
            }
        }
    }
    public static ItemListFragment createItemsFragment(String type){
        ItemListFragment fragment = new ItemListFragment();
        fragment.type = type;
        return fragment;
    }
    public String getType() {return type;}
    public void dataInsert() {
        Call<ItemList>call = api.getItems(type);
        call.enqueue(new Callback<ItemList>() {
            @Override
            public void onResponse(Call<ItemList> call, Response<ItemList> response) {
                adapter.setItem(response.body());
                refresh.setRefreshing(false);
            }
            @Override
            public void onFailure(Call<ItemList> call, Throwable t) {
                refresh.setRefreshing(false);
            }
        });
    }
    void removeSelectionsItems(){
        for (int i = adapter.getSelectedItems().size()-1; i >= 0; i--) {
            adapter.remove(adapter.getSelectedItems().get(i));
        }
    }

    private static ActionMode actionMode;

    public static ActionMode getActionMode() {
        return actionMode;
    }
    private class AdapterListener implements AdapterListenerInterface {

        @Override
        public void onClick(Item item, int position) {
            if (!inActionMode())return;
            else toggleSelection(position);
        }

        @Override
        public void onLongClick(Item item, int position) {
            if (!inActionMode()) {
                actionMode = ((AppCompatActivity)getActivity()).startSupportActionMode(callback);
                toggleSelection(position);
            }else return;
        }

        ActionMode.Callback callback = new ActionMode.Callback() {@Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                actionMode = mode;
                actionMode.setTitle("Удаление");
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
                switch (item.getItemId()){
                    case (R.id.delete):{
                        showDialog();
                    }
                }
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                quitActionMode();
            }
        };
    }
    static boolean inActionMode(){
        return actionMode != null;
    }
    public void quitActionMode(){
        actionMode.finish();
        actionMode = null;
        adapter.clearSelections();
    }
    void showDialog(){
        ConfirmationDialog dialog = new ConfirmationDialog();
        dialog.setTargetFragment(this,RESULT_REQUEST_CODE);
        dialog.show(getFragmentManager(),"ConfirmationDialog");
    }
    void toggleSelection(int position){
        adapter.toggleSelections(position);
    }
}
