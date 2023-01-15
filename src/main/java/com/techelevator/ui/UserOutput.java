package com.techelevator.ui;

import com.techelevator.application.Main;
import com.techelevator.models.Climber;

import java.util.Date;

public class UserOutput {
    public static void displayWelcomeHeader(){
        System.out.println(" ---------------------------------------------------------------------");
        System.out.println("|                                                                     |");
        System.out.println("|                                                                     |");
        System.out.println("|                                                                     |");
        System.out.println("|                              Welcome                                |");
        System.out.println("|                                                                     |");
        System.out.println("|                                                                     |");
        System.out.println("|                                                                     |");
        System.out.println(" ---------------------------------------------------------------------");
    }

    public static void printMessage(String message){
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayTodaysExercises(Climber user){
        Date d = new Date();
        String today = Main.DAYS[d.getDay()];
        System.out.println("Today is " + today +". Your exercises for today are: \n");
        String exercisesString = user.getRoutine().get(today);
        String[] exercises = exercisesString.split(",");
        int i=1;
        for(String exercise : exercises){
            System.out.println(i+ " "+exercise+ "\n");
            i++;
        }
    }
}
