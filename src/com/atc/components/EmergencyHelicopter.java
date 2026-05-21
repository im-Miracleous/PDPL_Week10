package com.atc.components;

import com.atc.core.ATCMediator;
import com.atc.core.FlightComponent;

public class EmergencyHelicopter extends FlightComponent {
    public EmergencyHelicopter(ATCMediator mediator, String flightNumber) {
        super(mediator, flightNumber);
    }

    @Override
    public void requestLanding() {
        System.out.println("🚁 [" + flightNumber + "] (Darurat Medis) Meminta izin mendarat SEGERA!");
        // Mengirim event yang berbeda ke ATC
        mediator.notify(this, "EMERGENCY_LANDING");
    }

    public void land() {
        System.out.println("🛬 [" + flightNumber + "] Mendarat darurat dengan cepat!");
    }
}
