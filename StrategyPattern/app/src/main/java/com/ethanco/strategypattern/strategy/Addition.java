package com.ethanco.strategypattern.strategy;

/**
 * 相加
 * <p/>
 * Created by Zhk on 2016/1/7.
 */
public class Addition implements IArithmetic {
    @Override
    public double operation(double value1, double value2) {
        return value1 + value2;
    }
}
