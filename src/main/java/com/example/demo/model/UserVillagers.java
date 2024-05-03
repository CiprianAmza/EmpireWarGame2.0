package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "user_villagers")
public class UserVillagers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int villagersForClay = 0;
    private int villagersForWood = 0;
    private int villagersForStone = 0;
    private int villagersForIron = 0;
    private int villagersForFood = 0;
    private int totalVillagers = 3;

    private int availableVillagers = 3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVillagersForClay() {
        return villagersForClay;
    }

    public void setVillagersForClay(int villagersForClay) {
        this.villagersForClay = villagersForClay;
    }

    public int getVillagersForWood() {
        return villagersForWood;
    }

    public void setVillagersForWood(int villagersForWood) {
        this.villagersForWood = villagersForWood;
    }

    public int getVillagersForStone() {
        return villagersForStone;
    }

    public void setVillagersForStone(int villagersForStone) {
        this.villagersForStone = villagersForStone;
    }

    public int getVillagersForIron() {
        return villagersForIron;
    }

    public void setVillagersForIron(int villagersForIron) {
        this.villagersForIron = villagersForIron;
    }

    public int getVillagersForFood() {
        return villagersForFood;
    }

    public void setVillagersForFood(int villagersForFood) {
        this.villagersForFood = villagersForFood;
    }

    public int getTotalVillagers() {
        return this.totalVillagers;
    }

    public void setTotalVillagers(int totalVillagers) {
        this.totalVillagers = totalVillagers;
    }

    public void setAvailableVillagers(int availableVillagers) {
        this.availableVillagers = availableVillagers;
    }

    public int getAvailableVillagers() {
        return availableVillagers;
    }
}
