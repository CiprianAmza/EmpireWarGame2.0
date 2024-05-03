package com.example.demo;

import org.springframework.scheduling.annotation.Async;

import java.util.List;


public class UserStats {

    private String townName = "My first town!!", name = " ";
    private List<Integer> mineProductionUpgradeValues = List.of(5, 48, 45, 42, 40, 38, 35, 32, 30, 28, 25, 22, 20, 18, 15, 12, 10, 8, 5, 2, 1, 1, 1, 1, 1, 1),
            populationLimitValues = List.of(150, 175, 200, 225, 250, 275, 300, 350, 425, 500),
            warehouseLimitValues = List.of(800, 1000, 1200, 1500, 1900, 2350, 2700, 3200, 3600, 4200, 5000, 6500, 8500, 12500),
            wallDefenseValues = List.of(0, 50, 100, 200, 300, 450, 600, 900);

    private int currentWood = 500,
        currentClay         = 500,
        currentStone        = 500,
        currentIron         = 500,
        currentFood         = 50,
        currentPopulation   = 10,
        populationLimit     = 150,
        warehouseLimit      = 800,
        woodPerHour         = 5,
        clayPerHour         = 5,
        stonePerHour        = 5,
        ironPerHour         = 5,
        foodPerHour         = 5,
        townDefensive       = 0,
        mainBuildingLevel   = 1,
        woodMineLevel       = 1,
        clayMineLevel       = 1,
        stoneMineLevel      = 1,
        ironMineLevel       = 1,
        foodMineLevel       = 1,
        farmLevel           = 1,
        warehouseLevel      = 1,
        wallLevel           = 1,
        maxWoodMineLevel,
        woodPerHourAtNextLevel,
        maxClayMineLevel,
        clayPerHourAtNextLevel,
        maxStoneMineLevel,
        stonePerHourAtNextLevel,
        maxIronMineLevel,
        ironPerHourAtNextLevel,
        maxFoodMineLevel,
        foodPerHourAtNextLevel,
        maxFarmLevel,
        farmPopulationLimitAtNextLevel,
        maxWarehouseLevel,
        warehouseLimitAtNextLevel,
        maxWallLevel,
        wallDefenseAtNextLevel,
        villagersForClay    = 0,
        villagersForWood    = 0,
        villagersForStone   = 0,
        villagersForIron    = 0,
        villagersForFood    = 0,
        totalVillagers      = 3;

    UserStats(){}


    public List<Integer> getMineProductionUpgradeValues() {
        return mineProductionUpgradeValues;
    }

    public List<Integer> getPopulationLimitValues() {
        return populationLimitValues;
    }

    public List<Integer> getWallDefenseValues() {
        return wallDefenseValues;
    }

    public List<Integer> getWarehouseLimitValues() {
        return warehouseLimitValues;
    }

    public void setMineProductionUpgradeValues(List<Integer> mineProductionUpgradeValues) {
        this.mineProductionUpgradeValues = mineProductionUpgradeValues;
    }

    public void setPopulationLimitValues(List<Integer> populationLimitValues) {
        this.populationLimitValues = populationLimitValues;
    }

    public void setWallDefenseValues(List<Integer> wallDefenseValues) {
        this.wallDefenseValues = wallDefenseValues;
    }

    public void setWarehouseLimitValues(List<Integer> warehouseLimitValues) {
        this.warehouseLimitValues = warehouseLimitValues;
    }

    public int getFoodPerHour() {
        return foodPerHour;
    }

    public int getCurrentFood() {
        return currentFood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFoodPerHour(int foodPerHour) {
        this.foodPerHour = foodPerHour;
    }

    public void setCurrentFood(int currentFood) {
        this.currentFood = currentFood;
    }

    public void setFoodMineLevel(int foodMineLevel) {
        this.foodMineLevel = foodMineLevel;
    }


    public String getTownName() {
        return this.townName;
    }


    public void setIronMineLevel(int ironMineLevel) {
        this.ironMineLevel = ironMineLevel;
    }

    public void setCurrentIron(int currentIron) {
        this.currentIron = currentIron;
    }

    public void setIronPerHour(int ironPerHour) {
        this.ironPerHour = ironPerHour;
    }

    public int getFoodMineLevel() {
        return foodMineLevel;
    }

    public int getVillagersForClay() {
        return villagersForClay;
    }

    public int getVillagersForFood() {
        return villagersForFood;
    }

    public int getTotalVillagers() {
        return totalVillagers;
    }

    public int getVillagersForIron() {
        return villagersForIron;
    }

    public int getVillagersForStone() {
        return villagersForStone;
    }

    public int getVillagersForWood() {
        return villagersForWood;
    }

    public void setTotalVillagers(int totalVillagers) {
        this.totalVillagers = totalVillagers;
    }

    public void setVillagersForWood(int villagersForWood) {
        this.villagersForWood = villagersForWood;
    }

    public void setVillagersForStone(int villagersForStone) {
        this.villagersForStone = villagersForStone;
    }

    public void setVillagersForIron(int villagersForIron) {
        this.villagersForIron = villagersForIron;
    }

    public void setVillagersForFood(int villagersForFood) {
        this.villagersForFood = villagersForFood;
    }

    public void setVillagersForClay(int villagersForClay) {
        this.villagersForClay = villagersForClay;
    }

    public int getMaxWallLevel() {return this.wallDefenseValues.size();}

    public int getMaxIronMineLevel() {return this.mineProductionUpgradeValues.size();}

    public int getMaxFarmLevel() {
        return this.populationLimitValues.size();
    }

    public int getMaxWarehouseLevel() {
        return this.warehouseLimitValues.size();
    }

    public int getMaxFoodMineLevel() {return this.warehouseLimitValues.size(); }

    public int getMaxWoodMineLevel() {
        return this.mineProductionUpgradeValues.size();
    }

    public int getMaxClayMineLevel() {
        return this.mineProductionUpgradeValues.size();
    }

    public int getMaxStoneMineLevel() {return this.mineProductionUpgradeValues.size();}

    public int getIronMineLevel() {return ironMineLevel;}


    public int getFoodPerHourAtNextLevel() {
        if (this.foodMineLevel < this.mineProductionUpgradeValues.size()) {
            return this.mineProductionUpgradeValues.get(this.foodMineLevel);
        }
        else {
            return this.foodPerHour;
        }
    }

    public int getIronPerHourAtNextLevel() {
        if (this.ironMineLevel < this.mineProductionUpgradeValues.size()) {
            return this.mineProductionUpgradeValues.get(this.ironMineLevel);
        }
        else {
            return this.ironPerHour;
        }
    }

    public int getWallDefenseAtNextLevel() {
        if (this.wallLevel < this.wallDefenseValues.size()) {
            return this.wallDefenseValues.get(this.wallLevel);
        }
        else {
            return this.townDefensive;
        }
    }

    public int getWarehouseLimitAtNextLevel() {
        if (this.warehouseLevel < this.warehouseLimitValues.size()) {
            return this.warehouseLimitValues.get(this.warehouseLevel);
        }
        else {
            return this.warehouseLimit;
        }
    }

    public int getFarmPopulationLimitAtNextLevel() {
        if (this.farmLevel < this.populationLimitValues.size()) {
            return this.populationLimitValues.get(this.farmLevel);
        }
        else {
            return this.populationLimit;
        }
    }

    public int getWoodPerHourAtNextLevel() {
        if (this.woodMineLevel < this.mineProductionUpgradeValues.size()) {
            return this.mineProductionUpgradeValues.get(this.woodMineLevel);
        }
        else {
            return this.woodPerHour;
        }
    }

    public int getClayPerHourAtNextLevel() {
        if (this.clayMineLevel < this.mineProductionUpgradeValues.size()) {
            return this.mineProductionUpgradeValues.get(this.clayMineLevel);
        }
        else {
            return this.clayPerHour;
        }
    }

    public int getStonePerHourAtNextLevel() {
        if (this.stoneMineLevel < this.mineProductionUpgradeValues.size()) {
            return this.mineProductionUpgradeValues.get(this.stoneMineLevel);
        }
        else {
            return this.stonePerHour;
        }
    }

    public void setMaxWoodMineLevel(int maxWoodMineLevel) {
        this.maxWoodMineLevel = maxWoodMineLevel;
    }

    public void setWoodPerHourAtNextLevel(int woodPerHourAtNextLevel) {
        this.woodPerHourAtNextLevel = woodPerHourAtNextLevel;
    }

    public int getIronPerHour() {return ironPerHour;}

    public int getCurrentIron() {return currentIron;}

    public int getCurrentClay() {
        return currentClay;
    }

    public int getCurrentStone() {
        return currentStone;
    }

    public int getCurrentPopulation() {
        return currentPopulation;
    }

    public int getCurrentWood() {
        return currentWood;
    }

    public int getPopulationLimit() {
        return populationLimit;
    }

    public int getWarehouseLimit() {
        return warehouseLimit;
    }

    public int getClayPerHour() {
        return clayPerHour;
    }

    public int getStonePerHour() {
        return stonePerHour;
    }

    public int getWoodPerHour() {
        return woodPerHour;
    }

    public int getTownDefensive() {
        return this.townDefensive;
    }

    public void setCurrentClay(int currentClay) {
        this.currentClay = currentClay;
    }

    public void setCurrentStone(int currentStone) {
        this.currentStone = currentStone;
    }

    public void setTownDefensive(int townDefensive) {
        this.townDefensive = townDefensive;
    }

    public void setCurrentPopulation(int currentPopulation) {
        this.currentPopulation = currentPopulation;
    }

    public void setCurrentWood(int currentWood) {
        this.currentWood = currentWood;
    }

    public void setClayPerHour(int clayPerHour) {
        this.clayPerHour = clayPerHour;
    }

    public void setStonePerHour(int stonePerHour) {
        this.stonePerHour = stonePerHour;
    }

    public void setPopulationLimit(int populationLimit) {
        this.populationLimit = populationLimit;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public void setWarehouseLimit(int warehouseLimit) {
        this.warehouseLimit = warehouseLimit;
    }

    public void setWoodPerHour(int woodPerHour) {
        this.woodPerHour = woodPerHour;
    }

    public int getFarmLevel() {
        return farmLevel;
    }

    public int getMainBuildingLevel() {
        return mainBuildingLevel;
    }

    public int getClayMineLevel() {
        return clayMineLevel;
    }

    public int getStoneMineLevel() {
        return stoneMineLevel;
    }

    public int getWallLevel() {
        return wallLevel;
    }

    public int getWarehouseLevel() {
        return warehouseLevel;
    }

    public int getWoodMineLevel() {
        return woodMineLevel;
    }

    public void setFarmLevel(int farmLevel) {
        this.farmLevel = farmLevel;
    }

    public void setClayMineLevel(int clayMineLevel) {
        this.clayMineLevel = clayMineLevel;
    }

    public void setStoneMineLevel(int stoneMineLevel) {
        this.stoneMineLevel = stoneMineLevel;
    }

    public void setMainBuildingLevel(int mainBuildingLevel) {
        this.mainBuildingLevel = mainBuildingLevel;
    }

    public void setWallLevel(int wallLevel) {
        this.wallLevel = wallLevel;
    }

    public void setWarehouseLevel(int warehouseLevel) {
        this.warehouseLevel = warehouseLevel;
    }

    public void setWoodMineLevel(int woodMineLevel) {
        this.woodMineLevel = woodMineLevel;
    }

}
