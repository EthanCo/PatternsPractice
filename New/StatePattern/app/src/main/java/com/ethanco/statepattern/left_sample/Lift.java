package com.ethanco.statepattern.left_sample;

import android.util.Log;

/**
 * Created by EthanCo on 2016/9/24.
 */
public class Lift implements ILeft {
    private static final String TAG = "Lift";

    @Override
    public void open() {
        Log.i(TAG, "open : ");
    }

    @Override
    public void close() {
        Log.i(TAG, "close : ");
    }

    @Override
    public void run() {
        Log.i(TAG, "run : ");
    }

    @Override
    public void stop() {
        Log.i(TAG, "stop : ");
    }
}
