package com.ethanco.commandpatterntest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ethanco.commandpatterntest.commandpattern.B_RangeHood;
import com.ethanco.commandpatterntest.commandpattern.Command;
import com.ethanco.commandpatterntest.commandpattern.Invoker;
import com.ethanco.commandpatterntest.commandpattern.RangeHood;
import com.ethanco.commandpatterntest.commandpattern.command.highWindCommand;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Invoker invoker = new Invoker();
        //RangeHood rangeHood = new A_RangeHood();
        RangeHood rangeHood = new B_RangeHood();
        //Command command = new OpenLightCommand(rangeHood);
        Command command = new highWindCommand(rangeHood);
        invoker.setCommand(command);
        invoker.action();
    }
}
