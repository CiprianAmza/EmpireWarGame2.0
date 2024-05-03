package com.example.demo.building;

import java.util.List;

public class FoodMine {

    private List<List<Integer>> foodMineValues = List.of(List.of(25, 25, 25, 3), List.of(50, 50, 50, 6), List.of(75, 75, 75, 9), List.of(150, 95, 130, 13), List.of(99999, 99999, 99999, 9999));
    private int level = 1;
    private int requestedWood, requestedClay, requestedStone, requestedPopulation;

    public FoodMine() {}

    public FoodMine(int level) {
        this.level = level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRequestedWood() {
        return this.foodMineValues.get(level-1).get(0);
    }

    public int getRequestedClay() {
        return this.foodMineValues.get(level-1).get(1);
    }

    public int getRequestedStone() {
        return this.foodMineValues.get(level-1).get(2);
    }

    public int getRequestedPopulation() {
        return this.foodMineValues.get(level-1).get(3);
    }

    public int getLevel() {
        return this.level;
    }
}
