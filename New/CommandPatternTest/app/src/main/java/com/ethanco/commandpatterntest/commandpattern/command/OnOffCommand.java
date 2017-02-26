package com.ethanco.commandpatterntest.commandpattern.command;

import com.ethanco.commandpatterntest.commandpattern.Command;
import com.ethanco.commandpatterntest.commandpattern.RangeHood;

/**
 * 关闭电源命令
 * <p/>
 * Created by EthanCo on 2016/1/30.
 */
public class OnOffCommand extends Command {

    public OnOffCommand(RangeHood rangeHood) {
        super(rangeHood);
    }

    @Override
    public void execute() {
        rangeHood.openLight(false);
        rangeHood.setWindSpeed(RangeHood.WindSpeed.NULL);
        rangeHood.openLight(false);
    }
}
