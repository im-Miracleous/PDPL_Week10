package com.smarthome.receiver;

public class SmartLight extends SmartDevice {
    public SmartLight(String name) {
        super(name);
    }

    @Override
    public void turnOn() {
        System.out.println("💡 Lampu (" + name + ") MENYALA.");
    }

    @Override
    public void turnOff() {
        System.out.println("💡 Lampu (" + name + ") MATI.");
    }
}
