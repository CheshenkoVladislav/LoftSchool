package com.example.vladislav.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.vladislav.myapplication.Data.Item;

public class AddItemActivity extends AppCompatActivity {
    private EditText name;
    private EditText price;
    private Button addPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        final String type = getIntent().getStringExtra(MainActivity.TYPE_KEY);
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
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
                Item item = new Item(itemName,itemPrice,type);
                Intent intent = new Intent();
                intent.putExtra(MainActivity.ITEM_KEY,item);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

}
