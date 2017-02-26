package com.ethanco.commandpatterntest.commandpattern;

import android.util.Log;

/**
 * 油烟机B
 * <p/>
 * Created by EthanCo on 2016/1/30.
 */
public class B_RangeHood extends RangeHood {

    @Override
    public void onoff(boolean b) {
        String oper = b ? "打开" : "关闭";
        Log.i("zhk-B_RangeHood", oper + "油烟机B开关");
        //相关的命令改变
    }

    @Override
    public void setWindSpeed(WindSpeed speed) {
        switch (speed) {
            case NULL:
                Log.i("zhk-B_RangeHood", "adjustWindSpeed: 无风");
                break;
            case SMALL_WIND:
                Log.i("zhk-B_RangeHood", "adjustWindSpeed: 小风");
                break;
            case HIGH_WIND:
                Log.i("zhk-B_RangeHood", "adjustWindSpeed: 大风");
                break;
            default:
                throw new IllegalArgumentException("speed is not matching，current speed=" + speed);
        }
    }

    @Override
    public void openLight(boolean b) {
        String oper = b ? "打开" : "关闭";
        Log.i("zhk-B_RangeHood", oper + "油烟机B的灯");
    }
}
