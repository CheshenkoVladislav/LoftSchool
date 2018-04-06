package com.example.vladislav.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vladislav.myapplication.Data.Balance;
import com.example.vladislav.myapplication.Interfaces.AdapterListenerInterface;
import com.example.vladislav.myapplication.Interfaces.RealApiLoftSchool;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BalanceFragment extends Fragment {
    private static String type = "balance";
    TextView totalExpense;
    TextView totalIncome;
    TextView totalBalance;
    RealApiLoftSchool apiLoftSchool;
    App app;
    DiagramView diagram;
    private static final String TAG = "BalanceFragment";
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiLoftSchool = App.getApiLoftSchool();
        app = (App)getActivity().getApplication();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_balance,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        totalExpense = view.findViewById(R.id.totalExpense);
        totalIncome = view.findViewById(R.id.totalIncome);
        totalBalance = view.findViewById(R.id.totalBalance);
        diagram = view.findViewById(R.id.diagram);
        dataAccept();
    }

    public static Fragment createItemsFragment(String type) {
        BalanceFragment fragment = new BalanceFragment();
        fragment.type = type;
        return fragment;
    }
    private void dataAccept(){
        apiLoftSchool.getBalance(app.getAuthToken()).enqueue(new Callback<Balance>() {
            @Override
            public void onResponse(Call<Balance> call, Response<Balance> response) {
                Log.d(TAG, "BALANCE FRAGMENT STATUS : " + response.body().getStatus());
                dataInsert(response.body());
            }

            @Override
            public void onFailure(Call<Balance> call, Throwable t) {

            }
        });
    }
    private void dataInsert(Balance body){
        Log.d(TAG, "dataInsert: " + totalIncome.getText() + " " + body.getTotalIncome());
        int income = body.getTotalIncome();
        int expense = body.getTotalExpenses();
        totalIncome.setText(String.valueOf(income) + "\u20BD");
        totalExpense.setText(String.valueOf(expense) + "\u20BD");
        totalBalance.setText(String.valueOf(income - expense));
        diagram.updateDiagram(expense,income);
    }

}
