package com.ethanco.bridgepattern.bridge;

import android.util.Log;

/**
 * 朱老师
 * <p/>
 * Created by EthanCo on 2016/1/8.
 */
public class TeacherZhu extends Teacher {
    public TeacherZhu(Subject _subject) {
        super(_subject);
        name = "朱老师";
    }

    @Override
    public void teaching() {
        Log.i("zhk-TeacherZhu", name + "极致地教学");
        super.teaching();
    }
}
