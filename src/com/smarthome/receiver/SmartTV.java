package com.smarthome.receiver;

public class SmartTV extends SmartDevice {
    private int volume = 10;

    public SmartTV(String name) {
        super(name);
    }

    @Override
    public void turnOn() {
        System.out.println("📺 TV (" + name + ") MENYALA.");
    }

    @Override
    public void turnOff() {
        System.out.println("📺 TV (" + name + ") MATI.");
    }

    public void volumeUp() {
        volume++;
        System.out.println("🔊 Volume TV (" + name + ") NAIK ke " + volume + ".");
    }

    public void volumeDown() {
        volume--;
        System.out.println("🔊 Volume TV (" + name + ") TURUN ke " + volume + ".");
    }
}
