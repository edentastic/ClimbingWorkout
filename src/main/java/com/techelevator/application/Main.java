package com.techelevator.application;

import com.techelevator.models.Climber;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static final String[] DAYS =new String[] {"sunday","monday","tuesday","wednesday","thursday","friday","saturday"};
    private String name;
    private Map<String,String> exerciseRoutine;
    private Climber user;
    public void run(){
        UserOutput.displayWelcomeHeader();
        String answer=UserInput.getWelcomeOption();
        System.out.println(answer);
        name=UserInput.getNameOfUser();
        if(answer.equals("1")){
            exerciseRoutine = UserInput.setupExerciseRoutine();
            user = new Climber(name,exerciseRoutine);
            user.saveToFile();
        }else{
            UserOutput.printMessage("Loading user profile...");
            File file = findClimberFileFromName(name);
            user=createClimberFromFile(file);
            UserOutput.printMessage("Profile loaded!");
        }

        //user profile fully loaded, time to start the thing
        UserOutput.displayTodaysExercises(user);




    }
    public static File findClimberFileFromName(String name){
        return new File("src/main/resources/"+name.replaceAll(" ","")+".txt");
    }
    public static Climber createClimberFromFile(File file){
        if(!file.exists()){
            System.out.println("Error -- Profile has not been created");
            System.exit(0);
        }
        String name="";
        Map<String,String> routine = new HashMap<>();
        try(Scanner inputFile = new Scanner(file)){
            boolean firstLine=true;
            while(inputFile.hasNextLine()){
                if(firstLine){
                    name=inputFile.nextLine();
                    firstLine=false;
                }else{
                    String line = inputFile.nextLine();
                    String day = line.substring(0,line.indexOf(':'));
                    String exercises = line.substring(line.indexOf(':')+1);
                    routine.put(day,exercises);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File cannot be read");
        }
    return new Climber(name,routine);
    }

}
