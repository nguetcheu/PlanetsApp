package com.example.planetsapp;

public class Planet {
    private String name;
    private int imageResId; // ID de la ressource image
    private int numberOfMoons;

    public Planet(String name, int imageResId, int numberOfMoons) {
        this.name = name;
        this.imageResId = imageResId;
        this.numberOfMoons = numberOfMoons;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public int getNumberOfMoons() {
        return numberOfMoons;
    }
}

