package com.example.demo;

import javax.persistence.criteria.CriteriaBuilder;

public class Player {
    private String name, score;
    private Integer position;

    Player(String name, String score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getPosition() {
        return position;
    }

    public String getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
