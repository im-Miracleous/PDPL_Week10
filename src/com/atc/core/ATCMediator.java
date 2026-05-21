package com.atc.core;

import com.atc.components.Runway;

public interface ATCMediator {
    void notify(FlightComponent sender, String event);
    void registerRunway(Runway runway);
    void registerFlight(FlightComponent flight);
}
