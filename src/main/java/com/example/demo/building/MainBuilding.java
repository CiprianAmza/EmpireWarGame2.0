package com.example.demo.building;

import java.util.List;

public class MainBuilding {

    private List<List<Integer>> mainBuildingValues = List.of(List.of(25, 25, 25, 3, 50), List.of(50, 50, 50, 6, 80), List.of(75, 75, 75, 9, 150), List.of(99999, 99999, 99999, 9999, 300));
    private int level = 1;
    private int requestedWood, requestedClay, requestedStone, requestedPopulation, secondsUpgradeCost;

    public MainBuilding() {}

    public MainBuilding(int level) {
        this.level = level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRequestedWood() {
        return this.mainBuildingValues.get(level-1).get(0);
    }

    public int getRequestedClay() {
        return this.mainBuildingValues.get(level-1).get(1);
    }

    public int getRequestedStone() {
        return this.mainBuildingValues.get(level-1).get(2);
    }

    public int getRequestedPopulation() {
        return this.mainBuildingValues.get(level-1).get(3);
    }

    public int getLevel() {
        return this.level;
    }

    public int getSecondsUpgradeCost() {
        return this.mainBuildingValues.get(level-1).get(4);
    }

    public void setMainBuildingValues(List<List<Integer>> mainBuildingValues) {
        this.mainBuildingValues = mainBuildingValues;
    }

    public void setRequestedClay(int requestedClay) {
        this.requestedClay = requestedClay;
    }

    public void setRequestedPopulation(int requestedPopulation) {
        this.requestedPopulation = requestedPopulation;
    }

    public void setRequestedStone(int requestedStone) {
        this.requestedStone = requestedStone;
    }

    public void setRequestedWood(int requestedWood) {
        this.requestedWood = requestedWood;
    }

    public void setSecondsUpgradeCost(int secondsUpgradeCost) {
        this.secondsUpgradeCost = secondsUpgradeCost;
    }
}
