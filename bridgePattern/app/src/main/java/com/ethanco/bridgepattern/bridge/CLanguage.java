package com.ethanco.bridgepattern.bridge;

import android.util.Log;

/**
 * C语言
 * <p/>
 * Created by EthanCo on 2016/1/8.
 */
public class CLanguage extends Subject {

    @Override
    public void showKnowledge() {
        Log.i("zhk-CLanguage", " printf(\"hello world !\");");
    }
}
