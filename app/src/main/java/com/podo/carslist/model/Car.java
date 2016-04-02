package com.podo.carslist.model;

import java.io.Serializable;

/**
 * Created by podo on 4/2/16.
 */
public class Car implements Serializable {


    public Car(long id, String model, String manufacturer, String thumbnailSmall, String thumbnailLarge, int engineSize, int speed, int acceleration) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.thumbnailSmall = thumbnailSmall;
        this.thumbnailLarge = thumbnailLarge;
        this.engineSize = engineSize;
        this.speed = speed;
        this.acceleration = acceleration;
    }

    private long id;
    private String model;
    private String manufacturer;
    private String thumbnailSmall;
    private String thumbnailLarge;
    private int engineSize ;
    private int speed ;
    private int acceleration ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getThumbnailSmall() {
        return thumbnailSmall;
    }

    public void setThumbnailSmall(String thumbnailSmall) {
        this.thumbnailSmall = thumbnailSmall;
    }

    public String getThumbnailLarge() {
        return thumbnailLarge;
    }

    public void setThumbnailLarge(String thumbnailLarge) {
        this.thumbnailLarge = thumbnailLarge;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", thumbnailSmall='" + thumbnailSmall + '\'' +
                ", thumbnailLarge='" + thumbnailLarge + '\'' +
                ", engineSize=" + engineSize +
                ", speed=" + speed +
                ", acceleration=" + acceleration +
                '}';
    }
}
