package com.atc.mediator;

import com.atc.components.CommercialFlight;
import com.atc.components.EmergencyHelicopter;
import com.atc.components.Runway;
import com.atc.core.ATCMediator;
import com.atc.core.FlightComponent;

public class ATCTower implements ATCMediator {
    private Runway runway;

    @Override
    public void registerRunway(Runway runway) {
        this.runway = runway;
    }

    @Override
    public void registerFlight(FlightComponent flight) {
        // Logika pendaftaran pesawat jika diperlukan
        System.out.println("📻 [ATC] Penerbangan " + flight.getFlightNumber() + " terhubung dengan menara pengawas.");
    }

    @Override
    public void notify(FlightComponent sender, String event) {
        if (event.equals("REQUEST_LANDING")) {
            System.out.println("📻 [ATC] Menerima permintaan dari " + sender.getFlightNumber() + "...");

            if (runway.isClear()) {
                System.out.println("✅ [ATC] Izin diberikan untuk " + sender.getFlightNumber() + ".");
                runway.setClear(false); // Blokir landasan

                // Asumsi pesawat langsung mendarat setelah diizinkan
                if (sender instanceof CommercialFlight) {
                    ((CommercialFlight) sender).land();
                }

                // Kosongkan kembali landasan setelah selesai mendarat (simulasi)
                runway.setClear(true);
            } else {
                System.out.println("❌ [ATC] Izin DITOLAK untuk " + sender.getFlightNumber() + ". Landasan sedang dipakai, harap berputar!");
            }
        }
        else if (event.equals("EMERGENCY_LANDING")) {
            System.out.println("📻 [ATC] Menerima sinyal DARURAT dari " + sender.getFlightNumber() + "!");
            System.out.println("⚠️  [ATC] Memaksa pengosongan landasan untuk pendaratan darurat!");

            // Logika khusus untuk darurat: paksa landasan dikosongkan (simulasi)
            runway.setClear(false);

            if (sender instanceof EmergencyHelicopter) {
                ((EmergencyHelicopter) sender).land();
            }

            runway.setClear(true);
        }
    }
}
