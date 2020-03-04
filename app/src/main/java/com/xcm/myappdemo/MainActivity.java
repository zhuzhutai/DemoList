package com.xcm.myappdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, CoverViewActivity.class));
            }
        }, 5000);
    }

    public void onClickBtn1(View view) {
        startActivity(new Intent(MainActivity.this, CoverViewActivity.class));
    }
}
