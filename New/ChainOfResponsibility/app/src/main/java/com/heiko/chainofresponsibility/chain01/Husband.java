package com.heiko.chainofresponsibility.chain01;

/**
 * 丈夫类
 *
 * @author Heiko
 * @date 2020/4/30 0030
 */
public class Husband extends Handler {
    public Husband() {
        super(Handler.HUSBAND_LEVEL_REQUEST);
    }

    @Override
    protected void response(IWomen women) {
        System.out.println("--------妻子向丈夫请示-------");
        System.out.println(women.getRequest());
        System.out.println("丈夫的答复是： 同意\n");
    }
}
