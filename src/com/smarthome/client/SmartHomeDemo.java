package com.smarthome.client;

import com.smarthome.command.Command;
import com.smarthome.command.impl.DeviceOffCommand;
import com.smarthome.command.impl.DeviceOnCommand;
import com.smarthome.command.impl.VolumeUpCommand;
import com.smarthome.invoker.RemoteControl;
import com.smarthome.receiver.SmartLight;
import com.smarthome.receiver.SmartTV;

public class SmartHomeDemo {
    public static void main(String[] args) {
        SmartLight ruangTamuLight = new SmartLight("Ruang Tamu");
        SmartTV kamarTV = new SmartTV("Kamar Tidur");

        Command lightOn = new DeviceOnCommand(ruangTamuLight);
        Command lightOff = new DeviceOffCommand(ruangTamuLight);

        Command tvOn = new DeviceOnCommand(kamarTV);
        Command tvOff = new DeviceOffCommand(kamarTV);
        Command tvVolUp = new VolumeUpCommand(kamarTV);

        RemoteControl remote = new RemoteControl(3);

        remote.setCommand(0, lightOn, lightOff);

        remote.setCommand(1, tvOn, tvOff);

        remote.setCommand(2, tvVolUp, new Command() {
            public void execute() {} public void undo() {}
        });

        // Simulasi penggunaan oleh User
        System.out.println("--- REMOTE CONTROL USAGE ---");

        System.out.println("\n[Skenario 1: Kontrol Lampu]");
        remote.pushOnButton(0);  // Nyalakan lampu
        remote.pushOffButton(0); // Matikan lampu
        remote.pushUndoButton(); // Batal matikan lampu (Undo -> Lampu nyala lagi)

        System.out.println("\n[Skenario 2: Kontrol TV & Volume]");
        remote.pushOnButton(1);  // Nyalakan TV
        remote.pushOnButton(2);  // Naikkan volume
        remote.pushUndoButton(); // Batal naikkan volume (Undo -> Volume turun ke asal)
        remote.pushOffButton(1); // Matikan TV
    }
}
