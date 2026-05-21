package com.smarthome.receiver;

public abstract class SmartDevice {
    protected String name;

    public SmartDevice(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void turnOn();
    public abstract void turnOff();
}
