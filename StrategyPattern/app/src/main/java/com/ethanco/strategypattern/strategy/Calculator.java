package com.ethanco.strategypattern.strategy;

/**
 * 计算器
 * <p/>
 * Created by Zhk on 2016/1/7.
 */
public class Calculator {
    private final IArithmetic arithmetic;

    public Calculator(IArithmetic _arithmetic) {
        this.arithmetic = _arithmetic;
    }

    public double calc(double value1, double value2) {
        return arithmetic.operation(value1, value2);
    }
}
