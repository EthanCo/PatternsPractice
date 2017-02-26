package com.ethanco.commandpatterntest.commandpattern.command;

import com.ethanco.commandpatterntest.commandpattern.Command;
import com.ethanco.commandpatterntest.commandpattern.RangeHood;

/**
 * Created by EthanCo on 2016/1/30.
 */
public class CloseLightCommand extends Command {
    public CloseLightCommand(RangeHood rangeHood) {
        super(rangeHood);
    }

    @Override
    public void execute() {
        rangeHood.openLight(false);
    }
}
