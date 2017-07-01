package com.corigami.practice;

import javax.swing.plaf.synth.SynthTextAreaUI;

/**
 * This program demonstrates how to search through any number of arrays given for the lowest matching number.
 *
 * Created by Corey Willinger on 6/30/2017.
 */
public class FindSmallestInSetOfArrays {
    public static void main(String args[]){
        runAlgorithm();
    }

    private static void runAlgorithm() {

        AlgUtility util = new AlgUtility();
        boolean reachedEnd= false;
        boolean matchFound=false;

        int numArrays = util.getUserInt("Enter then number of Arrays to check");
        int arraySize = util.getUserInt("Enter size of Array");
        MyArray[] myArrays = new MyArray[numArrays];
        int[] pointers = new int[numArrays];

        for(int i=0; i < numArrays; i++){
            myArrays[i] = new MyArray(arraySize);
            myArrays[i].bubbleSort();
            myArrays[i].print("Array " + i);
        }
        int lowArray =0;

           while(!matchFound && !reachedEnd){
               matchFound = true;
               lowArray =0;
                for(int i= 0; i <pointers.length-1; i++){
                    int val1 = myArrays[i].getData()[pointers[i]];
                    int val2 = myArrays[i+1].getData()[pointers[i+1]];
                    if( val1 != val2 ){
                        matchFound = false;
                        if(val2 < val1){
                            lowArray = i + 1;
                        }
                    }
               }
               if(pointers[lowArray] < myArrays[lowArray].getSize()-1){
                   pointers[lowArray]++;
               }else{
                   reachedEnd = true;
                   System.out.println("Reached End");

               }
                if(matchFound){
                    pointers[lowArray]--;
                    System.out.println("Matched value: " + myArrays[0].getData()[pointers[0]]);
                    util.print("Indexes that match: ", pointers);
                }
           }
    }
}
