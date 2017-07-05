package com.corigami.practice;

import java.util.*;
/**
 * Driver program for algorithm examples.
 *
 * Created by Corey Willinger on 7/1/2017.
 */
public class AlgDriver {

    public static void main(String[] args) {
        IAlgInterface algToRun = null;
        final String HEADER = "Menu item \tAlgorithm";
        AlgUtility util = new AlgUtility();
        int userChoice;
        boolean userContinue = true;
        Vector<IAlgInterface> algorithms = new Vector<>();

        algorithms.add(new BinarySearch());
        algorithms.add(new MaxInSlidingWindow());
        algorithms.add(new SearchInRotatedArray());
        algorithms.add(new FindSmallestInSetOfArrays());
      //  algorithms.add(new FindSmallestInSetOfArrays());

        do {
            System.out.println(HEADER);
            System.out.println("----------------------");
            for(int i=0; i < algorithms.size();i++){
                System.out.println((i+1) + "\t\t\t" + algorithms.get(i).getClass().getSimpleName());
            }
            System.out.println("----------------------");
            userChoice = util.getUserInt("Which algorithm would you like to run(1-" + algorithms.size() + ", -1 to exit)?");
            if(userChoice== -1){
                userContinue=false;
            }
            if(userContinue){
                algToRun = algorithms.get(userChoice-1);
                algToRun.getUserData();
                algToRun.runAlgorithm();
                System.out.println("\n\n");
            }

        }while(userContinue);
    }
}
