package com.ethanco.bridgepattern.bridge;

import android.util.Log;

/**
 * 李老师
 * <p/>
 * Created by EthanCo on 2016/1/8.
 */
public class TeacherLi extends Teacher {
    public TeacherLi(Subject _subject) {
        super(_subject);
        name = "李老师";
    }

    @Override
    public void teaching() {
        Log.i("zhk-TeacherLi", name + "优雅地教学");
        super.teaching();
    }
}
