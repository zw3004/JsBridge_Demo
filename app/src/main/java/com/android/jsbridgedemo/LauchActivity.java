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
        //判断不是第一次进入则直接关闭
        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            finish();
            return;
        }

        //进入真正的主Activity关闭掉自己
        Intent intent = new Intent();
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //intent.setAction("com.android.jsbridgedemo.MainActivity");
        intent.setClass(LauchActivity.this,StartActivity.class);
        startActivity(intent);
        (new Handler()).postDelayed(new Runnable() {
            public void run() {
                LauchActivity.this.finish();
            }
        }, 20L);
    }
}
