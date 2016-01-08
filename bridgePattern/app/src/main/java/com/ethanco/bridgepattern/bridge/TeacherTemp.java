package com.ethanco.bridgepattern.bridge;

import android.util.Log;

/**
 * 外聘的教师
 * <p/>
 * Created by EthanCo on 2016/1/8.
 */
public class TeacherTemp extends Teacher {

    public TeacherTemp(Subject _subject) {
        super(_subject);
        name = "不知道姓名的老师";
    }

    @Override
    public void teaching() {
        Log.i("zhk-TeacherTemp", name + "不知所云地教学");
        Log.i("zhk-TeacherTemp", "@$##@&(#@$&(#&@!)(#)(@!#");
        //super.teaching();
    }
}
