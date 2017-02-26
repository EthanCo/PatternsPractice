package com.ethanco.statepattern.left_sample;

/**
 * Created by EthanCo on 2016/9/24.
 */
public interface ILeft {
    //电梯门开启
    void open();

    //电梯门关闭
    void close();

    //电梯运行
    void run();

    //电梯停止
    void stop();
}
