package com.ethanco.commandpatterntest.commandpattern.command;

import com.ethanco.commandpatterntest.commandpattern.Command;
import com.ethanco.commandpatterntest.commandpattern.RangeHood;

/**
 * Created by EthanCo on 2016/1/30.
 */
public class SmallSpeedCommand extends Command {
    public SmallSpeedCommand(RangeHood rangeHood) {
        super(rangeHood);
    }

    @Override
    public void execute() {
        rangeHood.onoff(true);
        rangeHood.setWindSpeed(RangeHood.WindSpeed.SMALL_WIND);
    }
}
