package com.example.vladislav.myapplication.Data;

import com.google.gson.annotations.SerializedName;

public class Balance {
    private String status;
    @SerializedName("total_expenses")
    private int totalExpenses;
    @SerializedName("total_income")
    private int totalIncome;

    public String getStatus() {
        return status;
    }
    public int getTotalExpenses() {
        return totalExpenses;
    }
    public int getTotalIncome() {
        return totalIncome;
    }
}
