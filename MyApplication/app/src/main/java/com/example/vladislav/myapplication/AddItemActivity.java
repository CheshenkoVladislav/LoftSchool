package com.example.vladislav.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.vladislav.myapplication.Data.Data;
import com.example.vladislav.myapplication.ItemListAdapter.MainPageAdapter;

public class AddItemActivity extends AppCompatActivity {
    private EditText name;
    private EditText price;
    private Button addPosition;
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        type = getIntent().getStringExtra(ItemListFragment.TYPE_KEY);
        addPosition = findViewById(R.id.addPosition);
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                addPosition.setEnabled(name.getText().length() != 0 && price.getText().length() != 0);
            }
        };
        name.addTextChangedListener(textWatcher);
        price.addTextChangedListener(textWatcher);
        addPosition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = name.getText().toString();
                int itemPrice = Integer.parseInt(price.getText().toString());

                Data newData = new Data(itemName,itemPrice,type);
                Intent intent = new Intent();
                intent.putExtra(ItemListFragment.TYPE_KEY,newData);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
