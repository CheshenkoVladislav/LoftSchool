package com.example.vladislav.myapplication.fragment;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vladislav.myapplication.adapters.ItemListAdapter;
import com.example.vladislav.myapplication.R;
import com.example.vladislav.myapplication.app.BaseFragment;
import com.example.vladislav.myapplication.presenter.FItemListPresenter;

import javax.inject.Inject;

import butterknife.BindView;

public class ItemListFragment extends BaseFragment {
    private static final int ADD_REQUEST_CODE = 123;
    public static final int RESULT_REQUEST_CODE = 234;
    private String type;
    private ItemListAdapter adapter;

    @Inject
    FItemListPresenter presenter;

    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    public static ItemListFragment createItemsFragment(String type) {
        ItemListFragment fragment = new ItemListFragment();
        fragment.type = type;
        return fragment;
    }
}
