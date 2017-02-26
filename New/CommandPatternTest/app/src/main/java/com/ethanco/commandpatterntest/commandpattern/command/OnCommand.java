package com.ethanco.commandpatterntest.commandpattern.command;

import com.ethanco.commandpatterntest.commandpattern.Command;
import com.ethanco.commandpatterntest.commandpattern.RangeHood;

/**
 * Created by EthanCo on 2016/1/30.
 */
public class OnCommand extends Command {
    public OnCommand(RangeHood rangeHood) {
        super(rangeHood);
    }

    @Override
    public void execute() {
        rangeHood.openLight(true);
        rangeHood.setWindSpeed(RangeHood.WindSpeed.SMALL_WIND);
        rangeHood.openLight(true);
    }
}
