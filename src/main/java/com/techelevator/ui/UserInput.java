package com.techelevator.ui;

import com.techelevator.application.Main;
import com.techelevator.models.Climber;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInput {
    private static Scanner input = new Scanner(System.in);

    public static String getWelcomeOption(){
        boolean done=false;
        String answer="";
        while(!done) {
            System.out.println("Are you setting up your training plan? Or have you already created one?\n");
            System.out.println("1. I need to set up my training plan\n");
            System.out.println("2. I already have one\n");
            System.out.print("Please enter 1 or 2>>> ");
            answer = input.nextLine();
            if(answer.equals("1") || answer.equals("2")){
                done=true;
            } else{
                System.out.println("Please be sure to only enter 1 or 2 in order to make your selection");
            }
        }
        return answer;
    }

    public static String getNameOfUser(){
        boolean done=false;
        System.out.print("Great! Let's start off with your name>>>");
        String name = input.nextLine();
        System.out.println();
        while (!done) {
            System.out.println("You said name is " + name + ". Is that correct? y/n");
            String moveOn = input.nextLine();
            if(moveOn.equalsIgnoreCase("y")){
                done=true;
            } else if(moveOn.equalsIgnoreCase("n")){
                System.out.print("Please type in your name>>>");
                name=input.nextLine();
            }else{
                System.out.println("Please be sure to only type in a y or n to answer the question");
            }
        }
        return name;
    }

    public static Map<String, String> setupExerciseRoutine(){
        Map<String,String> routine = new HashMap<>();
        for(String day : Main.DAYS){
            String activities="";
            boolean done=false;
            boolean firstTime=true;
            while(!done) {
                if(!firstTime){
                    activities+=", ";
                }
                System.out.println("What exercise would you like to add for " + day + "?\n");
                System.out.println("1. Pull\n");
                System.out.println("2. Core\n");
                System.out.println("3. Aerobic\n");
                System.out.println("4. Antagonist\n");
                System.out.println("5. Rest\n");
                String answer = input.nextLine();
                if (answer.equals("1")) {
                    activities+="Pull";
                } else if (answer.equals("2")) {
                    activities+="Core";
                } else if (answer.equals("3")) {
                    activities+="Aerobic";
                } else if (answer.equals("4")) {
                    activities+="Antagonist";
                } else if (answer.equals("5")) {
                    activities+="Rest";
                } else {
                    System.out.println("Please be sure to enter a numeric option\n");
                    continue;
                }
                System.out.println("Would you like to add another exercise? y/n");
                String moveOn=input.nextLine();
                if(!moveOn.equalsIgnoreCase("y")){
                    done=true;
                }
                firstTime=false;
            }
            routine.put(day,activities);
        }
        return routine;
    }

    public static boolean isFirstTimeThisWeek(){
        Date d= new Date();
        String today= Main.DAYS[(int)d.getDay()];
        System.out.println("Today is "+today+". Are you signing in for the first time this week? y/n");
        String yesOrNo = input.nextLine();
        if(yesOrNo.equalsIgnoreCase("y")){
            return true;
        }else{
            return false;
        }
    }

    public static String[] markExerciseComplete(Climber user){
        System.out.println("Would you like to mark any exercises as complete? y/n");
        String yesOrNo= input.nextLine();
        if (yesOrNo.equalsIgnoreCase("N")){
            return user.getTodaysExercises();
        }else if(yesOrNo.equalsIgnoreCase("y")) {
            System.out.println("Which exercise have you completed?");
            String exerciseCompleted = input.nextLine();
            int index=-1;
            try {
                index = Integer.parseInt(exerciseCompleted);
                for (int i = 0; i < user.getTodaysExercises().length; i++) {

                }

            } catch (Exception e) {
                System.out.println("Invalid Choice");
            }
        }
        return user.getTodaysExercises();
    }

}
