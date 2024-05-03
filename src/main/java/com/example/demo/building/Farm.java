package com.example.demo.building;

import com.example.demo.System.Server;

import java.util.ArrayList;
import java.util.List;

public class Farm {

    //private List<List<Integer>> farmValues = List.of(List.of(10, 40, 5, 0, 45), List.of(18, 72, 25, 0, 67), List.of(80, 130, 75, 0, 101), List.of(160, 225, 115, 0, 151), List.of(225, 300, 155, 0, 227), List.of(355, 470, 215, 0, 341), List.of(525, 640, 285, 0, 512), List.of(870, 1030, 455, 0, 768), List.of(99999, 99999, 99999, 9999, 600));
    public static ArrayList<List<Integer>> farmValues = new ArrayList<>();

    private double resourcesRate = Server.resourcesRate,
                    timeRate = Server.timeRate;
    private int nrOfLevels = Server.farmNrLevels;
    private int level = 1;
    private int requestedWood, requestedClay, requestedStone, requestedPopulation, secondsUpgradeCost, freePlaces;

    public Farm() {
        List<Integer> firstLevel = List.of(10, 40, 5, 1, 45, 4);
        farmValues.add(firstLevel);

        for (int i = 0; i < nrOfLevels; i++){
            List<Integer> lastLevel = farmValues.get(farmValues.size()-1);
            int woodNeeded = lastLevel.get(0),
                    clayNeeded = lastLevel.get(1),
                    stoneNeeded = lastLevel.get(2),
                    ironNeeded = lastLevel.get(3),
                    timeNeeded = lastLevel.get(4),
                    farmFreePlaces = lastLevel.get(5);
            List<Integer> newLevel = List.of(
                    (int) (woodNeeded * resourcesRate),
                    (int) (clayNeeded * resourcesRate),
                    (int) (stoneNeeded * resourcesRate),
                    (int) (ironNeeded * resourcesRate),
                    (int) (timeNeeded * timeRate),
                    (int) (farmFreePlaces * resourcesRate)
            );
            System.out.println(newLevel);
            farmValues.add(newLevel);
        }

    }

    public Farm(int level) {
        this.level = level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRequestedWood() {
        return this.farmValues.get(level-1).get(0);
    }

    public int getRequestedClay() {
        return this.farmValues.get(level-1).get(1);
    }

    public int getRequestedStone() {
        return this.farmValues.get(level-1).get(2);
    }

    public int getRequestedPopulation() {
        return this.farmValues.get(level-1).get(3);
    }

    public int getLevel() {
        return this.level;
    }

    public int getSecondsUpgradeCost() {
        return this.farmValues.get(level-1).get(4);
    }

    public int getFreePlaces() {
        return this.farmValues.get(this.level).get(5);
    }

    public static int getSpaceNrAtLevel(int level) {
        return farmValues.get(level).get(5);
    }

}
