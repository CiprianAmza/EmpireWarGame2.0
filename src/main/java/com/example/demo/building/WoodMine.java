package com.example.demo.building;

import java.util.List;

public class WoodMine {

    private List<List<Integer>> woodMineValues = List.of(List.of(25, 25, 25, 3, 15), List.of(50, 50, 50, 6, 20), List.of(75, 75, 75, 9, 25), List.of(100, 250, 155, 13, 70), List.of(200, 550, 225, 21, 160), List.of(400, 820, 470, 29, 290), List.of(99999, 99999, 99999, 9999, 500));
    private int level = 1;
    private int requestedWood, requestedClay, requestedStone, requestedPopulation, secondsUpgradeCost;

    public WoodMine() {}

    public WoodMine(int level) {
        this.level = level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRequestedWood() {
        return this.woodMineValues.get(level-1).get(0);
    }

    public int getRequestedClay() {
        return this.woodMineValues.get(level-1).get(1);
    }

    public int getRequestedStone() {
        return this.woodMineValues.get(level-1).get(2);
    }

    public int getRequestedPopulation() {
        return this.woodMineValues.get(level-1).get(3);
    }

    public int getLevel() {
        return this.level;
    }

    public int getSecondsUpgradeCost() {
        return this.woodMineValues.get(level-1).get(4);
    }

}
