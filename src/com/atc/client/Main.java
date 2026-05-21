package com.atc.client;

import com.atc.components.CommercialFlight;
import com.atc.components.EmergencyHelicopter;
import com.atc.components.Runway;
import com.atc.core.ATCMediator;
import com.atc.mediator.ATCTower;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistem Air Traffic Control (ATC) Beroperasi ===\n");

        // 1. Inisialisasi Mediator (Menara ATC)
        ATCMediator atcTower = new ATCTower();

        // 2. Inisialisasi Komponen (Landasan dan Pesawat)
        Runway mainRunway = new Runway();
        atcTower.registerRunway(mainRunway);

        System.out.println();

        CommercialFlight flightGaruda = new CommercialFlight(atcTower, "GA-123");
        CommercialFlight flightLion = new CommercialFlight(atcTower, "JT-999");
        EmergencyHelicopter medivac = new EmergencyHelicopter(atcTower, "MED-01");

        atcTower.registerFlight(flightGaruda);
        atcTower.registerFlight(flightLion);
        atcTower.registerFlight(medivac);

        System.out.println("\n--- SKENARIO 1: Pendaratan Normal ---");
        flightGaruda.requestLanding();

        System.out.println("\n--- SKENARIO 2: Pendaratan Bersamaan (Simulasi bentrok) ---");
        // Kita simulasi landasan sedang dipakai manual untuk melihat reaksi ATC
        mainRunway.setClear(false);
        flightLion.requestLanding();

        System.out.println("\n--- SKENARIO 3: Pendaratan Darurat ---");
        medivac.requestLanding();

        System.out.println("\n=== Operasi Selesai ===");
    }
}
