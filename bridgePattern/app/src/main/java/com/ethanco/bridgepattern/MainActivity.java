package com.ethanco.bridgepattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ethanco.bridgepattern.bridge.CLanguage;
import com.ethanco.bridgepattern.bridge.JavaLanguage;
import com.ethanco.bridgepattern.bridge.Math;
import com.ethanco.bridgepattern.bridge.Subject;
import com.ethanco.bridgepattern.bridge.Teacher;
import com.ethanco.bridgepattern.bridge.TeacherLi;
import com.ethanco.bridgepattern.bridge.TeacherZhu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("zhk-MainActivity", "================= C语言课 ================");
        Subject cLanguage = new CLanguage();
        Teacher cTeacher = new TeacherZhu(cLanguage);
        cTeacher.teaching();

        Log.i("zhk-MainActivity", "================= 数学课 ====================");
        Subject math = new Math();
        //Teacher mathTeacher = new TeacherTemp(math);
        Teacher mathTeacher = new TeacherLi(math); //外聘老师教的太烂，换李老师教
        mathTeacher.teaching();

        Log.i("zhk-MainActivity", "=================== Java语言课 =================");
        Subject javaLanguage = new JavaLanguage();
        Teacher javaTeacher = new TeacherZhu(javaLanguage); //朱老师教的很好，也教我们Java
        javaTeacher.teaching();
    }
}
