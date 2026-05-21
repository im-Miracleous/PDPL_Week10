package com.atc.components;

import com.atc.core.ATCMediator;
import com.atc.core.FlightComponent;

public class CommercialFlight extends FlightComponent {
    public CommercialFlight(ATCMediator mediator, String flightNumber) {
        super(mediator, flightNumber);
    }

    @Override
    public void requestLanding() {
        System.out.println("✈️  [" + flightNumber + "] (Komersial) Meminta izin mendarat.");
        // Pesawat hanya melapor ke ATC (Mediator), tidak mengecek landasan sendiri
        mediator.notify(this, "REQUEST_LANDING");
    }

    public void land() {
        System.out.println("🛬 [" + flightNumber + "] Sedang mendarat di landasan...");
    }
}
