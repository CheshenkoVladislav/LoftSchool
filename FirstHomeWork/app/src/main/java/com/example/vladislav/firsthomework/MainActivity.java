package com.example.vladislav.firsthomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("start","СТАРРРТУЕМ!!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("resume","ИЛИ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("pause","П*ДУЕЕЕММ!!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("stop", "СТОП");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("destroy", "МАШИНА");
    }
}
