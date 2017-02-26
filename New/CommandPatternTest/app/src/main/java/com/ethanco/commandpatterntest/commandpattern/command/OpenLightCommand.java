package com.ethanco.commandpatterntest.commandpattern.command;

import com.ethanco.commandpatterntest.commandpattern.Command;
import com.ethanco.commandpatterntest.commandpattern.RangeHood;

/**
 * Created by EthanCo on 2016/1/30.
 */
public class OpenLightCommand extends Command {
    public OpenLightCommand(RangeHood rangeHood) {
        super(rangeHood);
    }

    @Override
    public void execute() {
        rangeHood.onoff(true);
        rangeHood.openLight(true);
    }
}
