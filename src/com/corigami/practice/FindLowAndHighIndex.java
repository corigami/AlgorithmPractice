package com.corigami.practice;

/**
 * Given a sorted array of integers, return the low and high index of the given key.
 * Returns -1 if not found. The array length can be in millions with lots of duplicates.
 * Created by Corey Willinger on 7/2/2017.
 */
public class FindLowAndHighIndex implements IAlgInterface{
    private enum IndexType {LOW,HIGH}
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

    FindLowAndHighIndex(int[] array, int key){
        myArray = new MyArray(array);
        arraySize = array.length;
        myArray.bubbleSort();
        this.key = key;
    }

    FindLowAndHighIndex(int size, int minVal, int maxVal){
        key = util.genRandInt(minVal, maxVal);
        myArray = new MyArray(size, minVal,maxVal);
        arraySize = size;
        myArray.bubbleSort();
    }

    public static void main(String[] args){

        FindLowAndHighIndex searchAlgorithm = new FindLowAndHighIndex();
        searchAlgorithm.runAlgorithm();
    }


    @Override
    public void getUserData() {
       arraySize = util.getUserInt("Enter the size of the array");
       key = util.getUserInt("Enter the key to search for (0 - 10)");
    }

    @Override
    public void runAlgorithm() {
    //TODO Finish runAlgorithm()
    }

    /**
     * Finds lowest index of key in an array
     * @param key value to be found
     * @return index of first occurrence, or -1 if not found
     */
    public int findLowIndex(int key){
        return findIndex(key, IndexType.LOW);
    }

    /**
     * Finds highest index of key in an array
     * @param key value to be found
     * @return index of last occurrence, or -1 if not found
     */
    public int findHighIndex(int key){
        return findIndex(key, IndexType.HIGH);
    }


    /**
     * Uses a modified binary search algorithm to find low index of group of like integers.
     * @param key the interger value we are searching for the low index of occurance in the array.
     * @return index of first occurrence, or -1 if not found
     */
    protected int findIndex(int key, IndexType type){
        int[] arrayToSearch = myArray.getData();
        int low = 0;
        int high = arrayToSearch.length-1;
        int mid;
        int midValue;
        int offset = (type == IndexType.LOW) ? -1 : 1;  //set our offset direct (low or high index)

        while(low <= high){
            mid = (high - low)/2 + low;
            midValue = arrayToSearch[mid];
            if(midValue == key){
                if((mid == 0 && type == IndexType.LOW) ||                         //if mid is the key and we are the beginning
                    (mid == arrayToSearch.length-1 && type == IndexType.HIGH) ||  // mid is the key and we are at the end
                    (arrayToSearch[mid + offset] != key) ){                       //mid is the key and the prev/next elem is not the key
                        return mid;
                }else{
                    if(type==IndexType.LOW){
                        high = mid+offset;
                    }
                    else {
                        low = mid+offset;
                    }

                }
            }else if(midValue > key){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;   // no key found
    }
}
