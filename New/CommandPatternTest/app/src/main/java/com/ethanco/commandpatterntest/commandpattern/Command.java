package com.ethanco.commandpatterntest.commandpattern;

/**
 * Created by EthanCo on 2016/1/30.
 */
public abstract class Command {
    protected RangeHood rangeHood;

    public Command(RangeHood rangeHood) {
        this.rangeHood = rangeHood;
    }

    public abstract void execute();
}
