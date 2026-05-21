package com.atc.core;

public abstract class FlightComponent {
    protected ATCMediator mediator;
    protected String flightNumber;

    public FlightComponent(ATCMediator mediator, String flightNumber) {
        this.mediator = mediator;
        this.flightNumber = flightNumber;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public abstract void requestLanding();
}
