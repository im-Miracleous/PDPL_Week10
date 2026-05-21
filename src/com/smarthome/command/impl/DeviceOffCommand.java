package com.smarthome.command.impl;

import com.smarthome.command.Command;
import com.smarthome.receiver.SmartDevice;

public class DeviceOffCommand implements Command {
    private SmartDevice device;

    public DeviceOffCommand(SmartDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOff();
    }

    @Override
    public void undo() {
        device.turnOn();
    }
}
