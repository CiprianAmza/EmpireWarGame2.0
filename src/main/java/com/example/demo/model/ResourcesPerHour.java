package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "resources_per_hour")
public class ResourcesPerHour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int woodPerHour = 5;
    private int clayPerHour = 5;
    private int stonePerHour = 5;
    private int ironPerHour = 5;
    private int foodPerHour = 5;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWoodPerHour() {
        return woodPerHour;
    }

    public void setWoodPerHour(int woodPerHour) {
        this.woodPerHour = woodPerHour;
    }

    public int getClayPerHour() {
        return clayPerHour;
    }

    public void setClayPerHour(int clayPerHour) {
        this.clayPerHour = clayPerHour;
    }

    public int getStonePerHour() {
        return stonePerHour;
    }

    public void setStonePerHour(int stonePerHour) {
        this.stonePerHour = stonePerHour;
    }

    public int getIronPerHour() {
        return ironPerHour;
    }

    public void setIronPerHour(int ironPerHour) {
        this.ironPerHour = ironPerHour;
    }

    public int getFoodPerHour() {
        return foodPerHour;
    }

    public void setFoodPerHour(int foodPerHour) {
        this.foodPerHour = foodPerHour;
    }
}
