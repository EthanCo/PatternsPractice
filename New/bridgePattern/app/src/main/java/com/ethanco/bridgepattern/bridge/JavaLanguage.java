package com.ethanco.bridgepattern.bridge;

import android.util.Log;

/**
 * Java语言
 * <p/>
 * Created by EthanCo on 2016/1/8.
 */
public class JavaLanguage extends Subject {
    @Override
    public void showKnowledge() {
        Log.i("zhk-JavaLanguage", "List<String> list = new ArrayList<String>();");
    }
}
