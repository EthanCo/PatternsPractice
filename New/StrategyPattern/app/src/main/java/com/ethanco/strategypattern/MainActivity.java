package com.ethanco.strategypattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ethanco.strategypattern.strategy.Calculator;
import com.ethanco.strategypattern.strategy.Division;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        double value1 = 30;
        double value2 = 5;
        Calculator calculator;
        //calculator = new Calculator(new Addition());
        //calculator = new Calculator(new Subtraction());
        //calculator = new Calculator(new Multiplication());
        calculator = new Calculator(new Division());
        Log.i("zhk-MainActivity", "onCreate: " + calculator.calc(value1, value2));
    }
}
