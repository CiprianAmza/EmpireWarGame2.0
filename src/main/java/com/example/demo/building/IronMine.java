package com.example.demo.building;

import java.util.List;

public class IronMine {

    private List<List<Integer>> ironMineValues = List.of(List.of(25, 25, 25, 3, 600), List.of(50, 50, 50, 6, 900), List.of(75, 75, 75, 9, 1800), List.of(150, 95, 130, 13, 2700), List.of(99999, 99999, 99999, 9999, 5000));
    private int level = 1;
    private int requestedWood, requestedClay, requestedStone, requestedPopulation, secondsUpgradeCost;

    public IronMine() {}

    public IronMine(int level) {
        this.level = level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRequestedWood() {
        return this.ironMineValues.get(level-1).get(0);
    }

    public int getRequestedClay() {
        return this.ironMineValues.get(level-1).get(1);
    }

    public int getRequestedStone() {
        return this.ironMineValues.get(level-1).get(2);
    }

    public int getRequestedPopulation() {
        return this.ironMineValues.get(level-1).get(3);
    }

    public int getLevel() {
        return this.level;
    }

    public int getSecondsUpgradeCost() {
        return this.ironMineValues.get(level-1).get(4);
    }
}
