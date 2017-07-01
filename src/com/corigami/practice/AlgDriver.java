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
        do {
            System.out.println(HEADER);
            System.out.println("----------------------");
            System.out.println("1\tBinary Search");
            System.out.println("2\tMax in Sliding Window");
            System.out.println("3\tSearch in Rotated Array");
            System.out.println("4\tFindSmallestInSetOfArrays");
            System.out.println("----------------------");
            userChoice = util.getUserInt("Which algorithm would you like to run? (-1 to exit)");

            switch(userChoice){
                case 1:
                    algToRun = new BinarySearch();
                    break;
                case -1:
                default:
                    userContinue=false;
            }
            if(userContinue){
                algToRun.getUserData();
                algToRun.runAlgorithm();
                System.out.println("\n\n");
            }

        }while(userContinue);
    }
}
