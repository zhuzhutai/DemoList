package com.xcm.myappdemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CoverViewActivity extends AppCompatActivity {

    public static final String TAG = "CoverViewActivity";

    private TextView tv1, tv2, tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover_view);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);

        Log.e(TAG, "onCreate tv1" + new UIHelper().isViewCovered(tv1));
        Log.e(TAG, "onCreate tv2" + new UIHelper().isViewCovered(tv2));
        Log.e(TAG, "onCreate tv3" + new UIHelper().isViewCovered(tv3));
    }

    @Override
    protected void onResume() {
        super.onResume();

        tv1.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG, "onResume tv1" + new UIHelper().isViewCovered(tv1) + "   " + new UIHelper().isShown(tv1));
                Log.e(TAG, "onResume tv2" + new UIHelper().isViewCovered(tv2) + "   " + new UIHelper().isShown(tv2));
                Log.e(TAG, "onResume tv3" + new UIHelper().isViewCovered(tv3) + "   " + new UIHelper().isShown(tv3));
            }
        }, 5000);


    }
}
