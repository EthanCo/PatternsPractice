package com.ethanco.commandpatterntest.commandpattern;

/**
 * 油烟机抽象类
 * <p/>
 * Created by EthanCo on 2016/1/30.
 */
public abstract class RangeHood {

    /**
     * 开关
     *
     * @param b
     */
    public abstract void onoff(boolean b);

    /**
     * 调节风速
     *
     * @param speed
     */
    public abstract void setWindSpeed(WindSpeed speed);

    /**
     * 开灯
     *
     * @param b
     */
    public abstract void openLight(boolean b);

    public enum WindSpeed {
        HIGH_WIND, SMALL_WIND, NULL
    }
}
