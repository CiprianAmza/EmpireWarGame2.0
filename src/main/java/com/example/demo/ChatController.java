package com.example.demo;

import com.example.demo.building.Farm;
import com.example.demo.building.Warehouse;
import com.example.demo.model.ChatResource;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ChatController {

    @Autowired
    ChatResource chatResource;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    private TablePoints tablePoints = new TablePoints();

    public int[] mineProductionUpgradeValues = {50, 48, 45, 42, 40, 38, 35, 32, 30, 28, 25, 22, 20, 18, 15, 12, 10, 8, 5, 2, 1, 1, 1, 1, 1, 1},
            populationLimitValues = {150, 175, 200, 225, 250, 275, 300, 350, 425, 500},
            warehouseLimitValues = {800, 1000, 1200, 1500, 1900, 2350, 2700, 3200, 3600, 4200, 5000, 6500, 8500, 12500},
            wallDefenseValues = {0, 50, 100, 200, 300, 450, 600, 900};


    private UserStats userStats = new UserStats();
    private int speed = 1;

    @GetMapping(value="/chatsource", produces ="application/json")
    public ChatResource viewChatSource() {
        return chatResource;
    }

    @PostMapping(value="/test")
    public String test(@RequestParam Map<String, String> test) {
        System.out.println(test);
        return test + " Mesaj adaugat de mine extra";
    }

    @GetMapping(value="/resources", produces = "application/json")
    public User getAllResources(){

        LocalDateTime time = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        long newTime = time.atZone(zoneId).toEpochSecond();

        String nowUpgrading = "";


        List<User> allUsers = userRepository.findAll();
        for (User user: allUsers) {

            if (user.getResources().getIsBuilding() == 1 && newTime - user.getUpdateTimeBuilding() >= 1) {
                user.getResources().setSecondsNeeded(user.getResources().getSecondsNeeded()-1);
                if (user.getResources().getSecondsNeeded() <= 0) {
                    user.getResources().setIsBuilding(2);
                    if (user.getToBeUpgraded().equals("Wood Mine")) {
                        user.getLevels().setWoodMineLevel(user.getLevels().getWoodMineLevel() + 1);
                        user.setTotalPoints(user.getTotalPoints() + tablePoints.woodMinePoints[user.getLevels().getWoodMineLevel()]);
                        user.getResourcesPerHour().setWoodPerHour(mineProductionUpgradeValues[user.getLevels().getWoodMineLevel()]);
                    }
                    else if (user.getToBeUpgraded().equals("Clay Mine")) {
                        user.getLevels().setClayMineLevel(user.getLevels().getClayMineLevel() + 1);
                        user.setTotalPoints(user.getTotalPoints() + tablePoints.clayMinePoints[user.getLevels().getClayMineLevel()]);
                        user.getResourcesPerHour().setClayPerHour(mineProductionUpgradeValues[user.getLevels().getClayMineLevel()]);
                    }
                    else if (user.getToBeUpgraded().equals("Stone Mine")) {
                        user.getLevels().setStoneMineLevel(user.getLevels().getStoneMineLevel() + 1);
                        user.setTotalPoints(user.getTotalPoints() + tablePoints.stoneMinePoints[user.getLevels().getStoneMineLevel()]);
                        user.getResourcesPerHour().setStonePerHour(mineProductionUpgradeValues[user.getLevels().getStoneMineLevel()]);
                    }
                    else if (user.getToBeUpgraded().equals("Iron Mine")) {
                        user.getLevels().setIronMineLevel(user.getLevels().getIronMineLevel() + 1);
                        user.setTotalPoints(user.getTotalPoints() + tablePoints.ironMinePoints[user.getLevels().getIronMineLevel()]);
                        user.getResourcesPerHour().setIronPerHour(mineProductionUpgradeValues[user.getLevels().getIronMineLevel()]);

                    }else if (user.getToBeUpgraded().equals("Main Building")){
                        user.getLevels().setMainBuildingLevel(user.getLevels().getMainBuildingLevel() + 1);
                        user.setTotalPoints(user.getTotalPoints() + tablePoints.mainBuildingPoints[user.getLevels().getMainBuildingLevel()]);

                    }else if (user.getToBeUpgraded().equals("Warehouse")){

                        Warehouse warehouse = new Warehouse();
                        warehouse.setLevel(user.getLevels().getFarmLevel());

                        user.setTotalPoints(user.getTotalPoints() + tablePoints.warehousePoints[user.getLevels().getWarehouseLevel()]);
                        user.getLevels().setWarehouseLevel(user.getLevels().getWarehouseLevel() + 1);
                        user.getResources().setCurrentWarehouseSpace(Warehouse.getCapacityAtLevel(user.getLevels().getWarehouseLevel() - 1));

                    }else if (user.getToBeUpgraded().equals("Farm")){

                        user.setTotalPoints(user.getTotalPoints() + tablePoints.farmPoints[user.getLevels().getFarmLevel()]);
                        user.getLevels().setFarmLevel(user.getLevels().getFarmLevel() + 1);

                        user.getResources().setCurrentFarmPopulation(Farm.getSpaceNrAtLevel(user.getLevels().getFarmLevel()) - 1);

                    }else if (user.getToBeUpgraded().equals("Wall")) {
                        user.getLevels().setWallLevel(user.getLevels().getWallLevel() + 1);
                        user.setTotalPoints(user.getTotalPoints() + tablePoints.wallPoints[user.getLevels().getWallLevel()]);
                    }


                }
                user.setUpdateTimeBuilding(newTime);
                userRepository.save(user);
            }

            if (user.getVillagers().getVillagersForClay() > 0) {
                if (newTime - user.getUpdateTimeClay() >= userStats.getClayPerHour()) {
                    user.getResources().setCurrentClay(user.getResources().getCurrentClay() + user.getVillagers().getVillagersForClay());
                    user.getResources().setCurrentClay(Math.min(user.getResources().getCurrentClay(), Warehouse.getCapacityAtLevel(user.getLevels().getWarehouseLevel() - 1)));
                    user.setUpdateTimeClay(newTime);
                    userRepository.save(user);
                }
            }

            if (user.getVillagers().getVillagersForWood() > 0) {
                if (newTime - user.getUpdateTimeWood() >= userStats.getWoodPerHour()) {
                    user.getResources().setCurrentWood(user.getResources().getCurrentWood() + user.getVillagers().getVillagersForWood());
                    user.getResources().setCurrentWood(Math.min(user.getResources().getCurrentWood(), Warehouse.getCapacityAtLevel(user.getLevels().getWarehouseLevel() - 1)));
                    user.setUpdateTimeWood(newTime);
                    userRepository.save(user);
                }
            }

            if (user.getVillagers().getVillagersForStone() > 0) {
                if (newTime - user.getUpdateTimeStone() >= userStats.getStonePerHour()) {
                    user.getResources().setCurrentStone(user.getResources().getCurrentStone() + user.getVillagers().getVillagersForStone());
                    user.getResources().setCurrentStone(Math.min(user.getResources().getCurrentStone(), Warehouse.getCapacityAtLevel(user.getLevels().getWarehouseLevel() - 1)));
                    user.setUpdateTimeStone(newTime);
                    userRepository.save(user);
                }
            }

            if (user.getVillagers().getVillagersForFood() > 0) {
                if (newTime - user.getUpdateTimeFood() >= userStats.getFoodPerHour()) {
                    user.getResources().setCurrentFood(user.getResources().getCurrentFood() + user.getVillagers().getVillagersForFood());
                    user.getResources().setCurrentFood(Math.min(user.getResources().getCurrentFood(), Warehouse.getCapacityAtLevel(user.getLevels().getWarehouseLevel() - 1)));
                    user.setUpdateTimeFood(newTime);
                    userRepository.save(user);
                }
            }

            if (user.getVillagers().getVillagersForIron() > 0) {
                if (newTime - user.getUpdateTimeIron() >= userStats.getIronPerHour()) {
                    user.getResources().setCurrentIron(user.getResources().getCurrentIron() + user.getVillagers().getVillagersForIron());
                    user.getResources().setCurrentIron(Math.min(user.getResources().getCurrentIron(), Warehouse.getCapacityAtLevel(user.getLevels().getWarehouseLevel() - 1)));
                    user.setUpdateTimeIron(newTime);
                    userRepository.save(user);
                }
            }

            user.getResources().setCurrentFarmPopulation(Farm.getSpaceNrAtLevel(user.getLevels().getFarmLevel() - 1));
            user.getResources().setToBeUpgraded(user.getToBeUpgraded());
            userRepository.save(user);
        }

        User user = userService.getCurrentAuthenticatedUser();
        if (user != null) {
            User currentUser = userRepository.findById(user.getId()).get();

            return currentUser;
        }
        else {
            return user;
        }
    }

    @PostMapping(value = "/chatsource", produces="application/json", consumes = "application/x-www-form-urlencoded")
    public @ResponseBody ChatResource getChatResource(@RequestParam(required = false) String chat){
        System.out.println("here");
        System.out.println(chat.toString());
        //chatResource.setTotalChat(chatResource.getTotalChat() + chat.get("message"));
        return chatResource;
    }


}

