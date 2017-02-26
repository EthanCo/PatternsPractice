package com.ethanco.pattern;

import android.app.Application;

/**
 * Created by EthanCo on 2016/1/16.
 */
public class MyApplication extends Application {
    private static MyApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static MyApplication getInstance() {
        return sInstance;
    }
}
