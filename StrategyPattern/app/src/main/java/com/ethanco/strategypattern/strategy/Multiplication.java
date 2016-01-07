package com.ethanco.strategypattern.strategy;

/**
 * 乘法
 * <p/>
 * Created by Zhk on 2016/1/7.
 */
public class Multiplication implements IArithmetic {
    @Override
    public double operation(double value1, double value2) {
        return value1 * value2;
    }
}
