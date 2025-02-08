package org.app.sampledata;

public class FerrariRoma extends Car {

    public FerrariRoma(String serialNumber) {
        super("Ferrari", "Roma", serialNumber);
    }

    @Override
    public void increaseSpeed() {
        this.speed = this.speed + 40;
    }

}
