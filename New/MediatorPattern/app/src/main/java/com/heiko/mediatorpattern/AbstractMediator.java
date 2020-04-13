package com.heiko.mediatorpattern;

/**
 * 抽象中介者
 *
 * @author Heiko
 * @date 2020/4/10 0010
 */
public abstract class AbstractMediator {
    protected Purchase purchase;
    protected Sale sale;
    protected Stock stock;

    public AbstractMediator() {
        this.purchase = new Purchase(this);
        this.sale = new Sale(this);
        this.stock = new Stock(this);
    }

    //中介者最重要的方法叫做事件方法， 处理多个对象之间的关系
    public abstract void execute(String str, Object... objects);
}
