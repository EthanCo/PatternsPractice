package com.ethanco.bridgepattern.bridge;

import android.util.Log;

/**
 * 数学
 * <p/>
 * Created by EthanCo on 2016/1/8.
 */
public class Math extends Subject {

    @Override
    public void showKnowledge() {
        Log.i("zhk-Math", " 1 + 2 = 3 ");
    }
}
