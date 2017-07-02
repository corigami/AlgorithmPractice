package com.corigami.practice;

/**
 * Given a sorted array of integers, return the low and high index of the given key.
 * Returns -1 if not found. The array length can be in millions with lots of duplicates.
 * Created by Corey Willinger on 7/2/2017.
 */
public class FindLowAndHighIndex implements IAlgInterface{
    private AlgUtility util = new AlgUtility();
    private MyArray myArray;
    private int key;
    private int arraySize;

    FindLowAndHighIndex(){
        key = util.genRandInt(0,10);
        myArray = new MyArray(100,0,10);
        arraySize = 100;
        myArray.bubbleSort();
    }

    FindLowAndHighIndex(int size, int minVal, int maxVal){
        key = util.genRandInt(minVal, maxVal);
        myArray = new MyArray(size, minVal,maxVal);
        arraySize = size;
        myArray.bubbleSort();
    }


    @Override
    public void getUserData() {
    //TODO Finish getUserData()
    }

    @Override
    public void runAlgorithm() {
    //TODO Finish runAlgorithm()
    }

}
