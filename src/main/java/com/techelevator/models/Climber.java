package com.techelevator.models;

import com.techelevator.application.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Climber {
    private String name;
    private Map<String,String> routine = new HashMap<>();

    public Climber(String name, Map<String, String> routine) {
        this.name = name;
        this.routine = routine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getRoutine() {
        return routine;
    }

    public void setRoutine(Map<String, String> routine) {
        this.routine = routine;
    }

    public String[] getTodaysExercises(){
        Date d = new Date();
        String today = Main.DAYS[d.getDay()];
        return routine.get(today).split(",");
    }

    public void saveToFile(){
        String nameNoSpaces=name.replaceAll(" ","");
        File file= new File("src/main/resources/"+nameNoSpaces+".txt");
        try(PrintWriter writer = new PrintWriter(file)){
            writer.println(name);
            for(Map.Entry<String,String> day : routine.entrySet()){
                writer.println(day.getKey() + ":" + day.getValue().replaceAll(" ",""));
            }
        }catch (FileNotFoundException e) {
            System.out.println("Cannot write file");
        }
    }
}
