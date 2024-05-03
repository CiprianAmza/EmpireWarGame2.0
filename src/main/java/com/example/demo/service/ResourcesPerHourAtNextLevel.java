package com.example.demo.service;

import com.example.demo.building.Farm;
import com.example.demo.building.Warehouse;

import java.util.List;

public class ResourcesPerHourAtNextLevel {

    public static final List<Integer> mineProductionUpgradeValues = List.of(5, 48, 45, 42, 40, 38, 35, 32, 30, 28, 25, 22, 20, 18, 15, 12, 10, 8, 5, 2, 1, 1, 1, 1, 1, 1);
    public static final List<Integer> farmPopulationValues = List.of(150, 175, 200, 225, 250, 275, 300, 350, 425, 500);
    public static final List<Integer> warehouseSpaceValues = List.of(800, 1000, 1200, 1500, 1900, 2350, 2700, 3200, 3600, 4200, 5000, 6500, 8500, 12500);
    public static final List<Integer> wallDefenseValues = List.of(0, 50, 100, 200, 300, 450, 600, 900);


    public static int getResourcesPerHourAtNextLevel(int currentLevel,
                                                     int currentValuePerHour) {
        if (currentLevel < mineProductionUpgradeValues.size()) {
            return mineProductionUpgradeValues.get(currentLevel);
        }
        else {
            return currentValuePerHour;
        }
    }

    public static int getFarmPopulationAtNextLevel(int currentLevel,
                                                   int currentFarmPopulation) {
        if (currentLevel < Farm.farmValues.size()) {
            return Farm.getSpaceNrAtLevel(currentLevel);
        }
        else {
            return Farm.getSpaceNrAtLevel(currentLevel - 1);
        }
    }

    public static int getWarehouseSpaceAtNextLevel(int currentLevel,
                                                   int currentWarehouseSpace) {
        if (currentLevel < Warehouse.warehouseValues.size()) {
            return Warehouse.getCapacityAtLevel(currentLevel);
        }
        else {
            return Warehouse.getCapacityAtLevel(currentLevel - 1);
        }
    }

    public static int getWallDefenseAtNextLevel(int currentLevel,
                                                int currentWallDefense) {
        if (currentLevel < wallDefenseValues.size()) {
            return wallDefenseValues.get(currentLevel);
        }
        else {
            return currentWallDefense;
        }
    }
}
