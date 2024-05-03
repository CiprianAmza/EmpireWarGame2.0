package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "user_levels")
public class UserLevels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int mainBuildingLevel = 1;
    private int woodMineLevel = 1;
    private int maxWoodMineLevel = 10;
    private int clayMineLevel = 1;
    private int maxClayMineLevel = 10;
    private int stoneMineLevel = 1;
    private int maxStoneMineLevel = 10;
    private int ironMineLevel = 1;
    private int maxIronMineLevel = 10;
    private int foodMineLevel = 1;
    private int maxFoodMineLevel = 10;
    private int farmLevel = 1;
    private int maxFarmLevel = 10;
    private int warehouseLevel = 1;
    private int maxWarehouseLevel = 10;
    private int wallLevel = 1;
    private int maxWallLevel = 10;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMainBuildingLevel() {
        return mainBuildingLevel;
    }

    public void setMainBuildingLevel(int mainBuildingLevel) {
        this.mainBuildingLevel = mainBuildingLevel;
    }

    public int getWoodMineLevel() {
        return woodMineLevel;
    }

    public void setWoodMineLevel(int woodMineLevel) {
        this.woodMineLevel = woodMineLevel;
    }

    public int getClayMineLevel() {
        return clayMineLevel;
    }

    public void setClayMineLevel(int clayMineLevel) {
        this.clayMineLevel = clayMineLevel;
    }

    public int getStoneMineLevel() {
        return stoneMineLevel;
    }

    public void setStoneMineLevel(int stoneMineLevel) {
        this.stoneMineLevel = stoneMineLevel;
    }

    public int getIronMineLevel() {
        return ironMineLevel;
    }

    public void setIronMineLevel(int ironMineLevel) {
        this.ironMineLevel = ironMineLevel;
    }

    public int getFoodMineLevel() {
        return foodMineLevel;
    }

    public void setFoodMineLevel(int foodMineLevel) {
        this.foodMineLevel = foodMineLevel;
    }

    public int getFarmLevel() {
        return farmLevel;
    }

    public void setFarmLevel(int farmLevel) {
        this.farmLevel = farmLevel;
    }

    public int getWarehouseLevel() {
        return warehouseLevel;
    }

    public void setWarehouseLevel(int warehouseLevel) {
        this.warehouseLevel = warehouseLevel;
    }

    public int getWallLevel() {
        return wallLevel;
    }

    public void setWallLevel(int wallLevel) {
        this.wallLevel = wallLevel;
    }

    public int getMaxWoodMineLevel() {
        return maxWoodMineLevel;
    }

    public void setMaxWoodMineLevel(int maxWoodMineLevel) {
        this.maxWoodMineLevel = maxWoodMineLevel;
    }

    public int getMaxClayMineLevel() {
        return maxClayMineLevel;
    }

    public void setMaxClayMineLevel(int maxClayMineLevel) {
        this.maxClayMineLevel = maxClayMineLevel;
    }

    public int getMaxStoneMineLevel() {
        return maxStoneMineLevel;
    }

    public void setMaxStoneMineLevel(int maxStoneMineLevel) {
        this.maxStoneMineLevel = maxStoneMineLevel;
    }

    public int getMaxIronMineLevel() {
        return maxIronMineLevel;
    }

    public void setMaxIronMineLevel(int maxIronMineLevel) {
        this.maxIronMineLevel = maxIronMineLevel;
    }

    public int getMaxFoodMineLevel() {
        return maxFoodMineLevel;
    }

    public void setMaxFoodMineLevel(int maxFoodMineLevel) {
        this.maxFoodMineLevel = maxFoodMineLevel;
    }

    public int getMaxFarmLevel() {
        return maxFarmLevel;
    }

    public void setMaxFarmLevel(int maxFarmLevel) {
        this.maxFarmLevel = maxFarmLevel;
    }

    public int getMaxWarehouseLevel() {
        return maxWarehouseLevel;
    }

    public void setMaxWarehouseLevel(int maxWarehouseLevel) {
        this.maxWarehouseLevel = maxWarehouseLevel;
    }

    public int getMaxWallLevel() {
        return maxWallLevel;
    }

    public void setMaxWallLevel(int maxWallLevel) {
        this.maxWallLevel = maxWallLevel;
    }
}
