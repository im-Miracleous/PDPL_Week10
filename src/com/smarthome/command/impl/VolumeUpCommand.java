package com.smarthome.command.impl;

import com.smarthome.command.Command;
import com.smarthome.receiver.SmartTV;

public class VolumeUpCommand implements Command {
    private SmartTV tv;

    public VolumeUpCommand(SmartTV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.volumeUp();
    }

    @Override
    public void undo() {
        tv.volumeDown();
    }
}
