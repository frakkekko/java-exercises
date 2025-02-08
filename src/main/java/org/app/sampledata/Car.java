package org.app.sampledata;

public abstract class Car {
    protected int speed = 0;
    protected int gear = 0;
    protected String serialNumber;

    public String getSerialNumber() {
        return serialNumber;
    }

    protected String brand;
    protected String model;

    protected Car(String brand, String model, String serialNumber) {
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
    }

    public String getBrand() {
        return brand;
    }


    public String getModel() {
        return model;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public abstract void increaseSpeed();

}
