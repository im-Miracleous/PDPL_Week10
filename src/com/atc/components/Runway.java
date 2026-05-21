package com.atc.components;

public class Runway {
    private boolean isClear = true;

    public boolean isClear() {
        return isClear;
    }

    public void setClear(boolean clear) {
        this.isClear = clear;
        if (clear) {
            System.out.println("🛣️  [Landasan] Sekarang kosong dan siap digunakan.");
        } else {
            System.out.println("🛣️  [Landasan] Sedang DIGUNAKAN.");
        }
    }
}
