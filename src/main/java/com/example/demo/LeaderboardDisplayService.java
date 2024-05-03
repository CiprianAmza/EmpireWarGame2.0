package com.example.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LeaderboardDisplayService {


    public LeaderboardDisplayService() {}

    public List<Player> sortTheList(List<Player> myList) {
        return  myList.stream().sorted((i, j) -> {
            int a = Integer.parseInt(i.getScore()), b = Integer.parseInt(j.getScore());
            if (a == b) return 0;
            if (a < b) return 1;
            return -1;
        }).collect(Collectors.toList());
    }

    public List<Player> finalUpdate(List<Player> myList) {
        int index = 0;
        myList = this.sortTheList(myList);
        for (int i = 0; i < myList.size(); i++) {
            myList.get(i).setPosition(i+1);
        }
        return myList;
    }

    public List<Player> readDocument(String document){
        List<Player> myList = new ArrayList<>();
        try {
            File myObj = new File(document);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] splitData = data.split("   ");
                myList.add(new Player(splitData[0], splitData[1]));
            }
            myList = this.sortTheList(myList);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return myList;
    }


}
