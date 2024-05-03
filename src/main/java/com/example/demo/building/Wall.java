package com.example.demo.building;

import java.util.List;

public class Wall {

    private List<List<Integer>> wallValues = List.of(List.of(525, 325, 125, 10, 200), List.of(1050, 700, 250, 20, 500), List.of(1655, 1230, 500, 30, 850), List.of(99999, 99999, 99999, 9999, 2400));
    private int level = 1;
    private int requestedWood, requestedClay, requestedStone, requestedPopulation, secondsUpgradeCost;

    public Wall() {}

    public Wall(int level) {
        this.level = level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRequestedWood() { return this.wallValues.get(level-1).get(0); }

    public int getRequestedClay() {
        return this.wallValues.get(level-1).get(1);
    }

    public int getRequestedStone() {
        return this.wallValues.get(level-1).get(2);
    }

    public int getRequestedPopulation() { return this.wallValues.get(level-1).get(3); }

    public int getLevel() {return this.level; }

    public int getSecondsUpgradeCost() {
        return this.wallValues.get(level-1).get(4);
    }
}