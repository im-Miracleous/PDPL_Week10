package com.smarthome.command.impl;

import com.smarthome.command.Command;
import com.smarthome.receiver.SmartDevice;

public class DeviceOnCommand implements Command {
    private SmartDevice device;

    public DeviceOnCommand(SmartDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }

    @Override
    public void undo() {
        device.turnOff();
    }
}
