package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String toBeUpgraded = "";
    private boolean active;
    private String roles;
    private long updateTimeWood = 1, updateTimeFood = 1, updateTimeIron = 1, updateTimeClay = 1, updateTimeStone = 1, updateTimeBuilding = 1;
    private int totalPoints = 0, leaderboardPosition = 0, availableVillagers = 3;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_resources_id", referencedColumnName = "id")
    private UserResources resources;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_levels_id", referencedColumnName = "id")
    private UserLevels levels;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_villagers_id", referencedColumnName = "id")
    private UserVillagers villagers;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "resources_per_hour_id", referencedColumnName = "id")
    private ResourcesPerHour resourcesPerHour;

    public User() {}

    public User(String username, String password, String email, String firstName, String lastName, long updateTimeWood, long updateTimeFood, long updateTimeClay, long updateTimeStone, long updateTimeIron, int totalPoints, String toBeUpgraded) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = true;
        this.roles = "USER";
        this.resources = new UserResources();
        this.levels = new UserLevels();
        this.villagers = new UserVillagers();
        this.resourcesPerHour = new ResourcesPerHour();
        this.updateTimeFood = updateTimeFood;
        this.updateTimeClay = updateTimeClay;
        this.updateTimeIron = updateTimeIron;
        this.updateTimeStone = updateTimeStone;
        this.updateTimeWood = updateTimeWood;
        this.totalPoints = totalPoints;
        this.toBeUpgraded = toBeUpgraded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setToBeUpgraded(String toBeUpgraded) {
        this.toBeUpgraded = toBeUpgraded;
    }

    public String getToBeUpgraded() {
        return toBeUpgraded;
    }

    public String getRoles() {
        return roles;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getLeaderboardPosition() {
        return leaderboardPosition;
    }

    public void setLeaderboardPosition(int leaderboardPosition) {
        this.leaderboardPosition = leaderboardPosition;
    }

    public long getUpdateTimeBuilding() {
        return updateTimeBuilding;
    }

    public void setUpdateTimeBuilding(long updateTimeBuilding) {
        this.updateTimeBuilding = updateTimeBuilding;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserResources getResources() {
        return resources;
    }

    public UserLevels getLevels() {
        return levels;
    }

    public UserVillagers getVillagers() {
        return villagers;
    }

    public ResourcesPerHour getResourcesPerHour() {
        return resourcesPerHour;
    }

    public void setResources(UserResources resources) {
        this.resources = resources;
    }

    public void setLevels(UserLevels levels) {
        this.levels = levels;
    }

    public void setVillagers(UserVillagers villagers) {
        this.villagers = villagers;
    }

    public void setResourcesPerHour(ResourcesPerHour resourcesPerHour) {
        this.resourcesPerHour = resourcesPerHour;
    }

    public long getUpdateTimeClay() {
        return updateTimeClay;
    }

    public long getUpdateTimeFood() {
        return updateTimeFood;
    }

    public long getUpdateTimeIron() {
        return updateTimeIron;
    }

    public long getUpdateTimeWood() {
        return updateTimeWood;
    }

    public long getUpdateTimeStone() {
        return updateTimeStone;
    }

    public void setUpdateTimeClay(long updateTimeClay) {
        this.updateTimeClay = updateTimeClay;
    }

    public void setUpdateTimeFood(long updateTimeFood) {
        this.updateTimeFood = updateTimeFood;
    }

    public void setUpdateTimeIron(long updateTimeIron) {
        this.updateTimeIron = updateTimeIron;
    }

    public void setUpdateTimeStone(long updateTimeStone) {
        this.updateTimeStone = updateTimeStone;
    }

    public void setUpdateTimeWood(long updateTimeWood) {
        this.updateTimeWood = updateTimeWood;
    }

    public int getAvailableVillagers() {
        return availableVillagers;
    }

    public void setAvailableVillagers(int availableVillagers) {
        this.availableVillagers = availableVillagers;
    }
}
