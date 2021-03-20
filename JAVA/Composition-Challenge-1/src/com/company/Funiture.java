package com.company;

public class Funiture {
    private boolean couch;
    private boolean wardrobe;
    private Carpet carpetSize;
    private Curtain curtainSize;

    public Funiture(boolean couch, boolean wardrobe, Carpet carpetSize, Curtain curtainSize) {
        this.couch = couch;
        this.wardrobe = wardrobe;
        this.carpetSize = carpetSize;
        this.curtainSize = curtainSize;
    }

    public boolean isCouch() {
        return couch;
    }

    public boolean isWardrobe() {
        return wardrobe;
    }

    public Carpet getCarpetSize() {
        return carpetSize;
    }

    public Curtain getCurtainSize() {
        return curtainSize;
    }
}
