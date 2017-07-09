package com.corigami.practice;
import java.util.*;

/**
 * Created by Corey Willinger on 6/26/2017.
 */
public class AlgUtility {

    Scanner input = new Scanner(System.in);

    /**
     * Generates an array of ints with the given parameters.
     * @param size size of array
     * @param min minimum value to use for random nuumbers
     * @param max maximum value to use for nandom numbers
     * @return array filled with random numbers
     */
    public int[] genArray(int size, int min, int max){
      Random random = genRandom();
        int[] array = new int[size];

        for(int i=0; i < size; i++){
            array[i] = genRandInt(min, max);
        }

        return array;
    }

    /**
     * returns a new Random object
     * @return Random object with seed set to current system time
     */
    public Random genRandom(){
        Random newRand = new Random();
        newRand.setSeed(System.currentTimeMillis());
        return newRand;
    }

    /**
     * Generates a random integer
     * @param min minimum value to return
     * @param max maximum value to return
     * @return random value between min and bax
     */
    public int genRandInt(int min, int max){
        Random newRand = genRandom();
        return newRand.nextInt((max - min) + 1) + min;
    }


    /**
     * Prompts the user to enter a value.
     * @param message
     * @return
     */
    public int getUserInt(String message){
        int value;
        System.out.print(message + ": ");
        try{
            value =  input.nextInt();
            return value;
        }catch (Exception e){
            System.out.println("You didn't enter a proper integer, please try again.");
            return getUserInt(message);
        }

    }

    /**
     * Prints the contents of the array
     * @param header String header to precede the array.
     */
    public void print(String header, int[] arrayToPrint){
        System.out.println(header + ":");
        System.out.print("[");
        for(int i = 0; i < arrayToPrint.length; i++){
            System.out.print(arrayToPrint[i]);
            if(i != arrayToPrint.length - 1) {
                System.out.print(", ");
            }
            else {
                System.out.println("]");
            }
        }
    }
}
