package com.example.demo.building;

import java.util.List;

public class StoneMine {


    private List<List<Integer>> stoneMineValues = List.of(List.of(25, 25, 25, 3, 60), List.of(50, 50, 50, 6, 90), List.of(75, 75, 75, 9, 150), List.of(190, 235, 90, 13, 290), List.of(335, 470, 190, 17, 445), List.of(510, 720, 300, 21, 600), List.of(99999, 99999, 99999, 9999, 840));
    private int level = 1;
    private int requestedWood, requestedClay, requestedStone, requestedPopulation, secondsUpgradeCost;

    public StoneMine() {}

    public StoneMine(int level) {
        this.level = level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRequestedWood() {return this.stoneMineValues.get(level-1).get(0);}

    public int getRequestedClay() {
        return this.stoneMineValues.get(level-1).get(1);
    }

    public int getRequestedStone() {
        return this.stoneMineValues.get(level-1).get(2);
    }

    public int getRequestedPopulation() {
        return this.stoneMineValues.get(level-1).get(3);
    }

    public int getLevel() {
        return this.level;
    }

    public int getSecondsUpgradeCost() {
        return this.stoneMineValues.get(level-1).get(4);
    }
}
