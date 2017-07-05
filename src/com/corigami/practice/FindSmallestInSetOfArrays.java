package com.corigami.practice;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * This program demonstrates how to search through any number of arrays given for the lowest matching number.
 *
 * Created by Corey Willinger on 6/30/2017.
 */
public class FindSmallestInSetOfArrays implements IAlgInterface
{
    AlgUtility util = new AlgUtility();
    private int numArrays;
    private int arraySize;
    MyArray[] myArrays;                 //array to store arrays
    int[] pointers;                     //keeps track of pointers for each array


    FindSmallestInSetOfArrays(MyArray[] arrays){
        myArrays = arrays;
        numArrays = myArrays.length;
        pointers = new int[numArrays];
    }

    FindSmallestInSetOfArrays(){
        numArrays = util.genRandInt(3,6);
        pointers = new int[numArrays];
        myArrays = new MyArray[numArrays];
        for(int i=0; i <numArrays;i++){
            myArrays[i] = new MyArray(util.genRandInt(17,20));
            myArrays[i].fill();
            myArrays[i].bubbleSort();
        }
    }

    /**
     * Main method: executes the program using default parameters
     * @param args
     */
    public static void main(String args[]){
        FindSmallestInSetOfArrays findSmall = new FindSmallestInSetOfArrays();
        findSmall.runAlgorithm();
    }

    @Override
    public void getUserData() {

        numArrays = util.getUserInt("Enter then number of Arrays to check");
        arraySize = util.getUserInt("Enter size of Array");
        myArrays = new MyArray[numArrays];
        pointers = new int[numArrays];
        for(int i=0; i < numArrays; i++){
            myArrays[i] = new MyArray(arraySize);
            myArrays[i].bubbleSort();
            myArrays[i].print("Array " + i);
        }
    }

    @Override
    public void runAlgorithm() {
        int result = searchForSmallest();
        if(result != -1){
            System.out.println("Matched value: " + result);
            util.print("Indexes that match: ", pointers);
        }else{
            System.out.println("Reached End - No common numbers in all arrays");
        }
    }

    /**
     * Searches through all of the arrays looking for the small value that is in all
     * arrays.
     * @return Smallest value that is in all arrays, or -1 if none is found
     */
    public int searchForSmallest(){
        boolean reachedEnd= false;
        boolean matchFound=false;
        int lowArray;

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
            }
            if(matchFound){
                pointers[lowArray]--;
                return myArrays[0].getData()[pointers[0]];
            }
        }
        return -1;
    }
}
