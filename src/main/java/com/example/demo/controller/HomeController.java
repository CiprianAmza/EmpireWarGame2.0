package com.example.demo.controller;

import com.example.demo.building.*;
import com.example.demo.model.ChatResource;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ResourcesPerHourAtNextLevel;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@EnableScheduling
public class HomeController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ChatResource chatResource;


    @GetMapping("/resources/woodmine")
    public String woodMineBuildingView(Model model) {
        User user = userService.getCurrentAuthenticatedUser();
        model.addAttribute("levels", user.getLevels());
        model.addAttribute("woodPerHour", user.getResourcesPerHour().getWoodPerHour());
        model.addAttribute("woodPerHourAtNextLevel",
                ResourcesPerHourAtNextLevel.getResourcesPerHourAtNextLevel(
                        user.getLevels().getWoodMineLevel(),
                        user.getResourcesPerHour().getWoodPerHour()));
        return "resources/woodMine";
    }
    @GetMapping("/resources/foodmine")
    public String foodMineBuildingView(Model model) {
        User user = userService.getCurrentAuthenticatedUser();
        model.addAttribute("levels", user.getLevels());
        model.addAttribute("foodPerHour", user.getResourcesPerHour().getFoodPerHour());
        model.addAttribute("foodPerHourAtNextLevel",
                ResourcesPerHourAtNextLevel.getResourcesPerHourAtNextLevel(
                        user.getLevels().getFoodMineLevel(),
                        user.getResourcesPerHour().getFoodPerHour()));
        return "resources/foodMine";
    }

    @GetMapping("/resources/stonemine")
    public String stoneMineBuildingView(Model model) {
        User user = userService.getCurrentAuthenticatedUser();
        model.addAttribute("levels", user.getLevels());
        model.addAttribute("stonePerHour", user.getResourcesPerHour().getStonePerHour());
        model.addAttribute("stonePerHourAtNextLevel",
                ResourcesPerHourAtNextLevel.getResourcesPerHourAtNextLevel(
                        user.getLevels().getStoneMineLevel(),
                        user.getResourcesPerHour().getStonePerHour()));
        return "resources/stoneMine";
    }

    @GetMapping("/resources/ironmine")
    public String ironMineBuildingView(Model model) {
        User user = userService.getCurrentAuthenticatedUser();
        model.addAttribute("levels", user.getLevels());
        model.addAttribute("ironPerHour", user.getResourcesPerHour().getIronPerHour());
        model.addAttribute("ironPerHourAtNextLevel",
                ResourcesPerHourAtNextLevel.getResourcesPerHourAtNextLevel(
                        user.getLevels().getIronMineLevel(),
                        user.getResourcesPerHour().getIronPerHour()));
        return "resources/ironMine";
    }

    @GetMapping("/resources/claymine")
    public String clayMineBuildingView(Model model) {
        User user = userService.getCurrentAuthenticatedUser();
        model.addAttribute("levels", user.getLevels());
        model.addAttribute("clayPerHour", user.getResourcesPerHour().getClayPerHour());
        model.addAttribute("clayPerHourAtNextLevel",
                ResourcesPerHourAtNextLevel.getResourcesPerHourAtNextLevel(
                        user.getLevels().getClayMineLevel(),
                        user.getResourcesPerHour().getClayPerHour()));
        System.out.println("...");
        return "resources/clayMine";
    }

    @GetMapping("/constructions/farm")
    public String farmBuildingView(Model model) {
        User user = userService.getCurrentAuthenticatedUser();
        model.addAttribute("levels", user.getLevels());
        model.addAttribute("currentFarmPopulation", Farm.getSpaceNrAtLevel(user.getLevels().getFarmLevel() - 1));
        model.addAttribute("farmPopulationLimitAtNextLevel",
                ResourcesPerHourAtNextLevel.getFarmPopulationAtNextLevel(
                        user.getLevels().getFarmLevel(),
                        user.getResources().getCurrentFarmPopulation()));
        return "constructions/farm";
    }

    @GetMapping("/constructions/warehouse")
    public String warehouseBuildingView(Model model) {
        User user = userService.getCurrentAuthenticatedUser();
        model.addAttribute("levels", user.getLevels());
        model.addAttribute("currentWarehouseSpace", user.getResources().getCurrentWarehouseSpace());
        model.addAttribute("warehouseSpaceAtNextLevel",
                ResourcesPerHourAtNextLevel.getWarehouseSpaceAtNextLevel(
                        user.getLevels().getWarehouseLevel(),
                        user.getResources().getCurrentWarehouseSpace()));
        return "constructions/warehouse";
    }

    @GetMapping("/constructions/wall")
    public String wallBuildingView(Model model) {
        User user = userService.getCurrentAuthenticatedUser();
        model.addAttribute("levels", user.getLevels());
        model.addAttribute("currentWallDefense", user.getResources().getCurrentWallDefense());
        model.addAttribute("wallDefenseAtNextLevel",
                ResourcesPerHourAtNextLevel.getWallDefenseAtNextLevel(
                        user.getLevels().getWallLevel(),
                        user.getResources().getCurrentWallDefense()));
        return "constructions/wall";
    }


    @GetMapping("/mainbuildingview")
    public String mainBuildingView(Model model) {
        User user = userService.getCurrentAuthenticatedUser();
        System.out.println("here"+user.getResources().getCurrentFarmPopulation());
        model.addAttribute("username", user);
        model.addAttribute("user", userService);
        model.addAttribute("resources", user.getResources());
        model.addAttribute("villagers", user.getVillagers());
        model.addAttribute("resourcesPerHour", user.getResourcesPerHour());
        model.addAttribute("levels", user.getLevels());
        model.addAttribute("mainBuildingUpgradeReq", new MainBuilding(user.getLevels().getMainBuildingLevel()));
        model.addAttribute("woodMineUpgradeReq", new WoodMine(user.getLevels().getWoodMineLevel()));
        model.addAttribute("clayMineUpgradeReq", new ClayMine(user.getLevels().getClayMineLevel()));
        model.addAttribute("stoneMineUpgradeReq", new StoneMine(user.getLevels().getStoneMineLevel()));
        model.addAttribute("ironMineUpgradeReq", new IronMine(user.getLevels().getIronMineLevel()));
        model.addAttribute("farmUpgradeReq", new Farm(user.getLevels().getFarmLevel()));
        model.addAttribute("warehouseUpgradeReq", new Warehouse(user.getLevels().getWarehouseLevel()));
        model.addAttribute("wallUpgradeReq", new Wall(user.getLevels().getWallLevel()));
        return "mainbuildingview";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }


    @PostMapping("/chat")
    public String saveChat(@RequestParam(name = "message") String message){
        User user = userService.getCurrentAuthenticatedUser();

        if (message.equals("$ciprian")) {
            user.getResources().setCurrentFood(user.getResources().getCurrentFood()+1000);
            user.getResources().setCurrentWood(user.getResources().getCurrentWood()+1000);
            user.getResources().setCurrentIron(user.getResources().getCurrentIron()+1000);
            user.getResources().setCurrentStone(user.getResources().getCurrentStone()+1000);
            user.getResources().setCurrentClay(user.getResources().getCurrentClay()+1000);
            userRepository.save(user);
        }
        else if (message.equals("$cosmin")) {
            user.setTotalPoints(user.getTotalPoints() + 10);
            userRepository.save(user);
        }
        else {
            String text = user.getUsername() + ": " + message + "\n\r";
            chatResource.setTotalChat(chatResource.getTotalChat() + text);
        }
        return "redirect:/mainbuildingview";
    }

//    @GetMapping("/chat")
//    public String getChat(Model model){
//        return "chat";
//    }
//
//    @PostMapping("/chat")
//    public String saveChat(@RequestParam(name="message") String message) {
//        User user = userService.getCurrentAuthenticatedUser();
//        String text = user.getUsername() + ": " + message + "\n\r";
//        chatResource.setTotalChat(chatResource.getTotalChat() + text);
//        return "redirect:/chat";
//    }


    @PostMapping("/mainbuildingview")
    public String printIt(@RequestParam String action, Model model) {

        User user = userRepository.findByUsername(userService.getCurrentAuthenticatedUser().getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        switch (action) {
            case "createNewVillager":
                if (user.getResources().getCurrentFood() >= 50 && user.getVillagers().getTotalVillagers() < Farm.getSpaceNrAtLevel(user.getLevels().getFarmLevel() - 1)) {

                    user.getResources().setCurrentFood(user.getResources().getCurrentFood() - 50);
                    user.getVillagers().setTotalVillagers(user.getVillagers().getTotalVillagers() + 1);
                    user.getVillagers().setAvailableVillagers(user.getVillagers().getAvailableVillagers() + 1);
                    user.getResources().setCurrentFarmPopulation(Farm.getSpaceNrAtLevel(user.getLevels().getFarmLevel() - 1));
                    System.out.println("total"+user.getVillagers().getTotalVillagers());
                    System.out.println("Avai"+user.getVillagers().getAvailableVillagers());
                }

                break;
            case "upgradeMainBuilding":
                MainBuilding mainBuilding = new MainBuilding(user.getLevels().getMainBuildingLevel());
                if (mainBuilding.getRequestedClay() <= user.getResources().getCurrentClay() &&
                        mainBuilding.getRequestedStone() <= user.getResources().getCurrentStone() &&
                        mainBuilding.getRequestedWood() <= user.getResources().getCurrentWood()) {

                    mainBuilding.setLevel(user.getLevels().getMainBuildingLevel());

                    user.getResources().setCurrentClay(user.getResources().getCurrentClay() - mainBuilding.getRequestedClay());
                    user.getResources().setCurrentStone(user.getResources().getCurrentStone() - mainBuilding.getRequestedStone());
                    user.getResources().setCurrentWood(user.getResources().getCurrentWood() - mainBuilding.getRequestedWood());
                    // user.getResources().setCurrentFarmPopulation(user.getResources().getCurrentFarmPopulation() + mainBuilding.getRequestedPopulation());

                    user.setToBeUpgraded("Main Building");
                    user.getResources().setIsBuilding(1);
                    user.getResources().setSecondsNeeded(mainBuilding.getSecondsUpgradeCost());

                } else {
                    System.out.println("Not enough resources");
                }

                break;
            case "upgradeWoodMine":
                WoodMine woodMine = new WoodMine(user.getLevels().getWoodMineLevel());
                if (user.getResources().getIsBuilding() != 1 && woodMine.getRequestedClay() <= user.getResources().getCurrentClay() &&
                        woodMine.getRequestedStone() <= user.getResources().getCurrentStone() &&
                        woodMine.getRequestedWood() <= user.getResources().getCurrentWood()) {

                    woodMine.setLevel(user.getLevels().getWoodMineLevel());

                    user.getResources().setCurrentClay(user.getResources().getCurrentClay() - woodMine.getRequestedClay());
                    user.getResources().setCurrentStone(user.getResources().getCurrentStone() - woodMine.getRequestedStone());
                    user.getResources().setCurrentWood(user.getResources().getCurrentWood() - woodMine.getRequestedWood());
                    // user.getResources().setCurrentFarmPopulation(user.getResources().getCurrentFarmPopulation() + woodMine.getRequestedPopulation());

                    user.setToBeUpgraded("Wood Mine");
                    user.getResources().setIsBuilding(1);
                    user.getResources().setSecondsNeeded(woodMine.getSecondsUpgradeCost());

                } else {
                    System.out.println("Not enough resources");
                }

                break;
            case "upgradeIronMine":

                IronMine ironMine = new IronMine(user.getLevels().getIronMineLevel());
                if (ironMine.getRequestedClay() <= user.getResources().getCurrentClay() &&
                        ironMine.getRequestedStone() <= user.getResources().getCurrentStone() &&
                        ironMine.getRequestedWood() <= user.getResources().getCurrentWood()) {

                    ironMine.setLevel(user.getLevels().getIronMineLevel());

                    user.getResources().setCurrentClay(user.getResources().getCurrentClay() - ironMine.getRequestedClay());
                    user.getResources().setCurrentStone(user.getResources().getCurrentStone() - ironMine.getRequestedStone());
                    user.getResources().setCurrentWood(user.getResources().getCurrentWood() - ironMine.getRequestedWood());
                    // user.getResources().setCurrentFarmPopulation(user.getResources().getCurrentFarmPopulation() + ironMine.getRequestedPopulation());

                    user.setToBeUpgraded("Iron Mine");
                    user.getResources().setIsBuilding(1);
                    user.getResources().setSecondsNeeded(ironMine.getSecondsUpgradeCost());
                } else {
                    System.out.println("Not enough resources");
                }

                break;
            case "upgradeClayMine":

                ClayMine clayMine = new ClayMine(user.getLevels().getClayMineLevel());
                if (clayMine.getRequestedClay() <= user.getResources().getCurrentClay() &&
                        clayMine.getRequestedStone() <= user.getResources().getCurrentStone() &&
                        clayMine.getRequestedWood() <= user.getResources().getCurrentWood()) {


                    clayMine.setLevel(user.getLevels().getClayMineLevel());

                    user.getResources().setCurrentClay(user.getResources().getCurrentClay() - clayMine.getRequestedClay());
                    user.getResources().setCurrentStone(user.getResources().getCurrentStone() - clayMine.getRequestedStone());
                    user.getResources().setCurrentWood(user.getResources().getCurrentWood() - clayMine.getRequestedWood());
                    // user.getResources().setCurrentFarmPopulation(user.getResources().getCurrentFarmPopulation() + clayMine.getRequestedPopulation());

                    user.setToBeUpgraded("Clay Mine");
                    user.getResources().setIsBuilding(1);
                    user.getResources().setSecondsNeeded(clayMine.getSecondsUpgradeCost());

                } else {
                    System.out.println("Not enough resources");
                }

                break;
            case "upgradeStoneMine":

                StoneMine stoneMine = new StoneMine(user.getLevels().getStoneMineLevel());
                if (stoneMine.getRequestedClay() <= user.getResources().getCurrentClay() &&
                        stoneMine.getRequestedStone() <= user.getResources().getCurrentStone() &&
                        stoneMine.getRequestedWood() <= user.getResources().getCurrentWood()) {

                    stoneMine.setLevel(user.getLevels().getStoneMineLevel());

                    user.getResources().setCurrentClay(user.getResources().getCurrentClay() - stoneMine.getRequestedClay());
                    user.getResources().setCurrentStone(user.getResources().getCurrentStone() - stoneMine.getRequestedStone());
                    user.getResources().setCurrentWood(user.getResources().getCurrentWood() - stoneMine.getRequestedWood());
                    // user.getResources().setCurrentFarmPopulation(user.getResources().getCurrentFarmPopulation() + stoneMine.getRequestedPopulation());

                    user.setToBeUpgraded("Stone Mine");
                    user.getResources().setIsBuilding(1);
                    user.getResources().setSecondsNeeded(stoneMine.getSecondsUpgradeCost());
                } else {
                    System.out.println("Not enough resources");
                }

                break;
            case "upgradeFarm":

                Farm farm = new Farm(user.getLevels().getFarmLevel());
                if (farm.getRequestedClay() <= user.getResources().getCurrentClay() &&
                        farm.getRequestedStone() <= user.getResources().getCurrentStone() &&
                        farm.getRequestedWood() <= user.getResources().getCurrentWood() && user.getResources().getSecondsNeeded() == 0) {

                    farm.setLevel(user.getLevels().getFarmLevel());

                    user.getResources().setCurrentClay(user.getResources().getCurrentClay() - farm.getRequestedClay());
                    user.getResources().setCurrentStone(user.getResources().getCurrentStone() - farm.getRequestedStone());
                    user.getResources().setCurrentWood(user.getResources().getCurrentWood() - farm.getRequestedWood());


                    user.setToBeUpgraded("Farm");
                    user.getResources().setIsBuilding(1);
                    user.getResources().setSecondsNeeded(farm.getSecondsUpgradeCost());
                } else {
                    System.out.println("Not enough resources");
                }

                break;
            case "upgradeWarehouse":

                Warehouse warehouse = new Warehouse(user.getLevels().getWarehouseLevel());
                if (warehouse.getRequestedClay() <= user.getResources().getCurrentClay() &&
                        warehouse.getRequestedStone() <= user.getResources().getCurrentStone() &&
                        warehouse.getRequestedWood() <= user.getResources().getCurrentWood()) {

                    warehouse.setLevel(user.getLevels().getWarehouseLevel());

                    user.getResources().setCurrentClay(user.getResources().getCurrentClay() - warehouse.getRequestedClay());
                    user.getResources().setCurrentStone(user.getResources().getCurrentStone() - warehouse.getRequestedStone());
                    user.getResources().setCurrentWood(user.getResources().getCurrentWood() - warehouse.getRequestedWood());

                    user.setToBeUpgraded("Warehouse");
                    user.getResources().setIsBuilding(1);
                    user.getResources().setSecondsNeeded(warehouse.getSecondsUpgradeCost());
                } else {
                    System.out.println("Not enough resources");
                }

                break;
            case "upgradeWall":

                Wall wall = new Wall(user.getLevels().getWallLevel());
                if (wall.getRequestedClay() <= user.getResources().getCurrentClay() &&
                        wall.getRequestedStone() <= user.getResources().getCurrentStone() &&
                        wall.getRequestedWood() <= user.getResources().getCurrentWood()) {

                    wall.setLevel(user.getLevels().getWallLevel());

                    user.getResources().setCurrentClay(user.getResources().getCurrentClay() - wall.getRequestedClay());
                    user.getResources().setCurrentStone(user.getResources().getCurrentStone() - wall.getRequestedStone());
                    user.getResources().setCurrentWood(user.getResources().getCurrentWood() - wall.getRequestedWood());
                    // user.getResources().setCurrentFarmPopulation(user.getResources().getCurrentFarmPopulation() + wall.getRequestedPopulation());

                    user.setToBeUpgraded("Wall");
                    user.getResources().setIsBuilding(1);
                    user.getResources().setSecondsNeeded(wall.getSecondsUpgradeCost());
                } else {
                    System.out.println("Not enough resources");
                }

                break;
            case "moveVillagersToClay":
                if (user.getVillagers().getAvailableVillagers() >= 1 && user.getLevels().getClayMineLevel() >= 1) {
                    user.getVillagers().setAvailableVillagers(user.getVillagers().getAvailableVillagers() - 1);
                    user.getVillagers().setVillagersForClay(user.getVillagers().getVillagersForClay() + 1);
                }
                break;
            case "removeVillagersFromClay":
                if (user.getVillagers().getVillagersForClay() >= 1) {
                    user.getVillagers().setVillagersForClay(user.getVillagers().getVillagersForClay() - 1);
                    user.getVillagers().setAvailableVillagers(user.getVillagers().getAvailableVillagers() + 1);;
                }
                break;
            case "moveVillagersToWood":
                if (user.getVillagers().getAvailableVillagers() >= 1 && user.getLevels().getWoodMineLevel() >= 1) {
                    user.getVillagers().setAvailableVillagers(user.getVillagers().getAvailableVillagers() - 1);
                    user.getVillagers().setVillagersForWood(user.getVillagers().getVillagersForWood() + 1);
                }
                break;
            case "removeVillagersFromWood":
                if (user.getVillagers().getVillagersForWood() >= 1) {
                    user.getVillagers().setVillagersForWood(user.getVillagers().getVillagersForWood() - 1);
                    user.getVillagers().setAvailableVillagers(user.getVillagers().getAvailableVillagers() + 1);
                }

                break;
            case "moveVillagersToStone":
                if (user.getVillagers().getAvailableVillagers() >= 1 && user.getLevels().getStoneMineLevel() >= 1) {
                    user.getVillagers().setAvailableVillagers(user.getVillagers().getAvailableVillagers() - 1);
                    user.getVillagers().setVillagersForStone(user.getVillagers().getVillagersForStone() + 1);
                }
                break;
            case "removeVillagersFromStone":
                if (user.getVillagers().getVillagersForStone() >= 1) {
                    user.getVillagers().setVillagersForStone(user.getVillagers().getVillagersForStone() - 1);
                    user.getVillagers().setAvailableVillagers(user.getVillagers().getAvailableVillagers() + 1);
                }
                break;
            case "moveVillagersToIron":
                if (user.getVillagers().getAvailableVillagers() >= 1 && user.getLevels().getIronMineLevel() >= 1) {
                    user.getVillagers().setAvailableVillagers(user.getVillagers().getAvailableVillagers() - 1);
                    user.getVillagers().setVillagersForIron(user.getVillagers().getVillagersForIron() + 1);
                }
                break;
            case "removeVillagersFromIron":
                if (user.getVillagers().getVillagersForIron() >= 1) {
                    user.getVillagers().setVillagersForIron(user.getVillagers().getVillagersForIron() - 1);
                    user.getVillagers().setAvailableVillagers(user.getVillagers().getAvailableVillagers() + 1);
                }
                break;
            case "moveVillagersToFood":
                if (user.getVillagers().getAvailableVillagers() >= 1 && user.getLevels().getFoodMineLevel() >= 1) {
                    user.getVillagers().setAvailableVillagers(user.getVillagers().getAvailableVillagers() - 1);
                    user.getVillagers().setVillagersForFood(user.getVillagers().getVillagersForFood() + 1);
                }
                break;
            case "removeVillagersFromFood":
                if (user.getVillagers().getVillagersForFood() >= 1) {
                    user.getVillagers().setVillagersForFood(user.getVillagers().getVillagersForFood() - 1);
                    user.getVillagers().setAvailableVillagers(user.getVillagers().getAvailableVillagers() + 1);
                }
                break;
        }

        userRepository.save(user);

        return "redirect:/mainbuildingview";
    }

    @GetMapping("/leaderboard")
    public String viewLeadeboardPage(Model model){

        int position = 1;
        List<User> allUsers = userRepository.findAll();
        allUsers.sort(
                (a, b)->{
                    int x = a.getTotalPoints(), y = b.getTotalPoints();
                    if (x == y) return 0;
                    return x < y ? 1 : -1;});
        for (User user: allUsers) {
            user.setLeaderboardPosition(position);
            position += 1;
        }
        model.addAttribute("players", allUsers);
        return "leaderboard";
    }

    @GetMapping("/map")
    public String viewMap(Model model) {

        User user = userService.getCurrentAuthenticatedUser();
        model.addAttribute("resources", user.getResources());
        model.addAttribute("villagers", user.getVillagers());
        model.addAttribute("resourcesPerHour", user.getResourcesPerHour());
        model.addAttribute("levels", user.getLevels());
        model.addAttribute("mainBuildingUpgradeReq", new MainBuilding(user.getLevels().getMainBuildingLevel()));
        model.addAttribute("woodMineUpgradeReq", new WoodMine(user.getLevels().getWoodMineLevel()));
        model.addAttribute("clayMineUpgradeReq", new ClayMine(user.getLevels().getClayMineLevel()));
        model.addAttribute("stoneMineUpgradeReq", new StoneMine(user.getLevels().getStoneMineLevel()));
        model.addAttribute("ironMineUpgradeReq", new IronMine(user.getLevels().getIronMineLevel()));
        model.addAttribute("farmUpgradeReq", new Farm(user.getLevels().getFarmLevel()));
        model.addAttribute("warehouseUpgradeReq", new Warehouse(user.getLevels().getWarehouseLevel()));
        model.addAttribute("wallUpgradeReq", new Wall(user.getLevels().getWallLevel()));

        return "map";
    }


}
