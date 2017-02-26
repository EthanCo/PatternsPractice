package com.ethanco.commandpatterntest.commandpattern;

/**
 * Created by EthanCo on 2016/1/30.
 */
public class Invoker {

    public void setCommand(Command command) {
        this.command = command;
    }

    private Command command;

    public void action() {
        command.execute();
    }
}
