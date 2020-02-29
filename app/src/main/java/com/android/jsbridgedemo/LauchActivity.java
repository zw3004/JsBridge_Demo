package com.android.jsbridgedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LauchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_lauch);
        Intent intent = new Intent();
        intent.setClass(LauchActivity.this,StartActivity.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //intent.setAction("com.android.jsbridgedemo.MainActivity");


        startActivity(intent);
        (new Handler()).postDelayed(new Runnable() {
            public void run() {
                LauchActivity.this.finish();
            }
        }, 20L);
    }
}
