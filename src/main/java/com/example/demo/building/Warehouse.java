package com.example.demo.building;

import com.example.demo.System.Server;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    // private List<List<Integer>> warehouseValues = List.of(List.of(25, 25, 25, 0, 30), List.of(50, 50, 50, 0, 120), List.of(75, 75, 75, 0, 350), List.of(99999, 99999, 99999, 9999, 500));
    public static ArrayList<List<Integer>> warehouseValues = new ArrayList<>();

    private double resourcesRate = Server.resourcesRate,
            timeRate = Server.timeRate;
    private int nrOfLevels = Server.warehouseNrLevels;

    private int level = 1;
    private int requestedWood, requestedClay, requestedStone, requestedPopulation, secondsUpgradeCost, currentCapacity;

    public Warehouse() {
        List<Integer> firstLevel = List.of(45, 15, 30, 1, 20, 150);
        warehouseValues.add(firstLevel);

        for (int i = 0; i < nrOfLevels; i++) {
            List<Integer> lastLevel = warehouseValues.get(warehouseValues.size() - 1);
            int woodNeeded = lastLevel.get(0),
                    clayNeeded = lastLevel.get(1),
                    stoneNeeded = lastLevel.get(2),
                    ironNeeded = lastLevel.get(3),
                    timeNeeded = lastLevel.get(4),
                    resourcesCapacitiy = lastLevel.get(5);
            List<Integer> newLevel = List.of(
                    (int) (woodNeeded * resourcesRate),
                    (int) (clayNeeded * resourcesRate),
                    (int) (stoneNeeded * resourcesRate),
                    (int) (ironNeeded * resourcesRate),
                    (int) (timeNeeded * timeRate),
                    (int) (resourcesCapacitiy * resourcesRate)
            );
            System.out.println(newLevel);
            warehouseValues.add(newLevel);
        }

    }

    public Warehouse(int level) {
        this.level = level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRequestedWood() { return this.warehouseValues.get(level-1).get(0); }

    public int getRequestedClay() {
        return this.warehouseValues.get(level-1).get(1);
    }

    public int getRequestedStone() {
        return this.warehouseValues.get(level-1).get(2);
    }

    public int getRequestedPopulation() { return this.warehouseValues.get(level-1).get(3); }

    public int getLevel() {return this.level; }

    public int getSecondsUpgradeCost() {
        return this.warehouseValues.get(level-1).get(4);
    }

    public int getCurrentCapacity() {
        return warehouseValues.get(this.level).get(5);
    }

    public static int getCapacityAtLevel(int level) {
        return warehouseValues.get(level).get(5);
    }
}