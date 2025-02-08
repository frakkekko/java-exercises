package org.app.sampledata;

public class TeslaModelS extends Car{
    private final double batteryCapacityKw = 100.0;

    public TeslaModelS(String serialNumber) {
        super("Tesla", "S", serialNumber);
    }

    @Override
    public void increaseSpeed() {
        speed = speed + 15;
    }

    public double getBatteryCapacityKw() {
        return batteryCapacityKw;
    }
}
