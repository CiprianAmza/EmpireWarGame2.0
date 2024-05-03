package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "user_resources")
public class UserResources {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int currentWood = 0;
    private int currentClay = 0;
    private int currentStone = 0;
    private int currentIron = 0;
    private int currentFood = 0;
    private int currentFarmPopulation = 3;
    private int currentWarehouseSpace = 150;
    private int currentWallDefense = 0;
    private int secondsNeeded = 0;
    private int isBuilding = 2;
    private String toBeUpgraded = "";

    public String getToBeUpgraded() {
        return toBeUpgraded;
    }

    public void setToBeUpgraded(String toBeUpgraded) {
        this.toBeUpgraded = toBeUpgraded;
    }

    public int getIsBuilding() {
        return isBuilding;
    }

    public int getSecondsNeeded() {
        return secondsNeeded;
    }

    public void setIsBuilding(int isBuilding) {
        this.isBuilding = isBuilding;
    }

    public void setSecondsNeeded(int secondsNeeded) {
        this.secondsNeeded = secondsNeeded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentWood() {
        return currentWood;
    }

    public void setCurrentWood(int currentWood) {
        this.currentWood = currentWood;
    }

    public int getCurrentClay() {
        return currentClay;
    }

    public void setCurrentClay(int currentClay) {
        this.currentClay = currentClay;
    }

    public int getCurrentStone() {
        return currentStone;
    }

    public void setCurrentStone(int currentStone) {
        this.currentStone = currentStone;
    }

    public int getCurrentIron() {
        return currentIron;
    }

    public void setCurrentIron(int currentIron) {
        this.currentIron = currentIron;
    }

    public int getCurrentFood() {
        return currentFood;
    }

    public void setCurrentFood(int currentFood) {
        this.currentFood = currentFood;
    }

    public int getCurrentFarmPopulation() {
        return currentFarmPopulation;
    }

    public void setCurrentFarmPopulation(int currentFarmPopulation) {
        this.currentFarmPopulation = currentFarmPopulation;
    }

    public int getCurrentWarehouseSpace() {
        return currentWarehouseSpace;
    }

    public void setCurrentWarehouseSpace(int currentWarehouseSpace) {
        this.currentWarehouseSpace = currentWarehouseSpace;
    }

    public int getCurrentWallDefense() {
        return currentWallDefense;
    }

    public void setCurrentWallDefense(int currentWallDefense) {
        this.currentWallDefense = currentWallDefense;
    }
}
