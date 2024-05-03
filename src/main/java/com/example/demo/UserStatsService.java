package com.example.demo;


import com.example.demo.model.User;
import com.example.demo.model.UserResources;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;


@Service
@Getter
@Setter
public class UserStatsService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    private UserStats userStats = new UserStats();
    private int speed = 1;


    public void updateResourceValues(){
        LocalDateTime time = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        long newTime = time.atZone(zoneId).toEpochSecond();

        List<User> allUsers = userRepository.findAll();
        for (User user: allUsers) {

            if (user.getVillagers().getVillagersForClay() > 0) {
                if (newTime - user.getUpdateTimeClay() >= userStats.getClayPerHour()) {
                    user.getResources().setCurrentClay(user.getResources().getCurrentClay() + user.getVillagers().getVillagersForClay());
                    user.getResources().setCurrentClay(Math.min(user.getResources().getCurrentClay(), userStats.getWarehouseLimit()));
                    user.setUpdateTimeClay(newTime);
                    userRepository.save(user);
                }
            }

            if (user.getVillagers().getVillagersForWood() > 0) {
                if (newTime - user.getUpdateTimeWood() >= userStats.getWoodPerHour()) {
                    user.getResources().setCurrentWood(user.getResources().getCurrentWood() + user.getVillagers().getVillagersForWood());
                    user.getResources().setCurrentWood(Math.min(user.getResources().getCurrentWood(), userStats.getWarehouseLimit()));
                    user.setUpdateTimeWood(newTime);
                    userRepository.save(user);
                }
            }

            if (user.getVillagers().getVillagersForStone() > 0) {
                if (newTime - user.getUpdateTimeStone() >= userStats.getStonePerHour()) {
                    user.getResources().setCurrentStone(user.getResources().getCurrentStone() + user.getVillagers().getVillagersForStone());
                    user.getResources().setCurrentStone(Math.min(user.getResources().getCurrentStone(), userStats.getWarehouseLimit()));
                    user.setUpdateTimeStone(newTime);
                    userRepository.save(user);
                }
            }

            if (user.getVillagers().getVillagersForFood() > 0) {
                if (newTime - user.getUpdateTimeFood() >= userStats.getFoodPerHour()) {
                    user.getResources().setCurrentFood(user.getResources().getCurrentFood() + user.getVillagers().getVillagersForFood());
                    user.getResources().setCurrentFood(Math.min(user.getResources().getCurrentFood(), userStats.getWarehouseLimit()));
                    user.setUpdateTimeFood(newTime);
                    userRepository.save(user);
                }
            }

            if (user.getVillagers().getVillagersForIron() > 0) {
                if (newTime - user.getUpdateTimeIron() >= userStats.getIronPerHour()) {
                    user.getResources().setCurrentIron(user.getResources().getCurrentIron() + user.getVillagers().getVillagersForIron());
                    user.getResources().setCurrentIron(Math.min(user.getResources().getCurrentIron(), userStats.getWarehouseLimit()));
                    user.setUpdateTimeIron(newTime);
                    userRepository.save(user);
                }
            }
        }
    }

}
