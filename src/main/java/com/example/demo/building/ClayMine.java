package com.example.demo.building;

import java.util.List;

public class ClayMine {

    private List<List<Integer>> clayMineValues = List.of(List.of(25, 25, 25, 3, 15), List.of(50, 50, 50, 6, 35), List.of(75, 75, 75, 9, 60), List.of(150, 95, 130, 13, 105), List.of(99999, 99999, 99999, 9999, 165));
    private int level = 1;
    private int requestedWood, requestedClay, requestedStone, requestedPopulation, secondsUpgradeCost;

    public ClayMine() {}

    public ClayMine(int level) {
        this.level = level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRequestedWood() {
        return this.clayMineValues.get(level-1).get(0);
    }

    public int getRequestedClay() {
        return this.clayMineValues.get(level-1).get(1);
    }

    public int getRequestedStone() {
        return this.clayMineValues.get(level-1).get(2);
    }

    public int getRequestedPopulation() {
        return this.clayMineValues.get(level-1).get(3);
    }

    public int getLevel() {
        return this.level;
    }

    public int getSecondsUpgradeCost() {
        return this.clayMineValues.get(level-1).get(4);
    }
}
