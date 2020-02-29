package com.android.jsbridgedemo;

import android.app.Application;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.app.Activity;
import android.widget.Toast;

public class MyApplication extends Application {


    //Application的创建，第一个创建，比Activity中的onCreate方法调用还要早
    //Application的创建，第一个创建，比Activity中的onCreate方法调用还要早
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "application_onCreate" + this, Toast.LENGTH_SHORT).show();
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            Integer count=0;
            @Override
            public void onActivityStopped(Activity activity) {
                Log.i("viclee", activity + "onActivityStopped");
                count--;
                if (count == 0) {
                    Log.i("viclee", ">>>>>>>>>>>>>>>>>>>切到后台  lifecycle");
                }
            }

            @Override
            public void onActivityStarted(Activity activity) {
                Log.i("viclee", activity + "onActivityStarted");
                if (count == 0) {
                    Log.i("viclee", ">>>>>>>>>>>>>>>>>>>切到前台  lifecycle");
                }
                count++;
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                Log.i("viclee", activity + "onActivitySaveInstanceState");
            }

            @Override
            public void onActivityResumed(Activity activity) {
                Log.i("viclee", activity + "onActivityResumed");
            }

            @Override
            public void onActivityPaused(Activity activity) {
                Log.i("viclee", activity + "onActivityPaused");
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                Log.i("viclee", activity + "onActivityDestroyed");
            }

            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Log.i("viclee", activity + "onActivityCreated");
            }
        });

    }


}
