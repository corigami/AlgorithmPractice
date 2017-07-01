package com.corigami.practice;
import java.util.*;

/**
 * Created by Corey Willinger on 6/26/2017.
 */
public class AlgUtility {

    Scanner input = new Scanner(System.in);

    /**
     * Generates an array of ints with the given parameters.
     * @param size
     * @param min
     * @param max
     * @return
     */
    public int[] genArray(int size, int min, int max){
      Random random = genRandom();
        int[] array = new int[size];

        for(int i=0; i < size; i++){
            array[i] = genRandInt(min, max);
        }

        return array;
    }

    public Random genRandom(){
        Random newRand = new Random();
        newRand.setSeed(System.currentTimeMillis());
        return newRand;
    }

    public int genRandInt(int min, int max){
        Random newRand = genRandom();
        return newRand.nextInt((max - min) + 1) + min;
    }

    public int getUserInt(String message){
        System.out.print(message + ": ");
        return input.nextInt();
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
