package com.corigami.practice;

/**
 * Demonstrates using a binary search on a rotated array.
 *
 * Created by Corey Willinger on 6/29/2017.
 */
public class SearchInRotatedArray implements IAlgInterface {
    private int searchVal;
    private int arraySize;
    private int shiftVal;

    private AlgUtility util = new AlgUtility();
    private MyArray myArray;

    SearchInRotatedArray(){
        searchVal = util.genRandInt(0,100);
        arraySize = 100;
        shiftVal = util.genRandInt(0,100);
        myArray = new MyArray(arraySize);
    }

    SearchInRotatedArray(int[] array, int val){
        searchVal = val;
        myArray = new MyArray(array);
        arraySize = array.length;
    }

    SearchInRotatedArray(int val, int size){
        searchVal = val;
        arraySize = size;
        shiftVal = util.genRandInt(0,100);
        myArray = new MyArray(arraySize);
    }

    /**
     * Main method: executes the program using default parameters
     * @param args
     */
    public static void main(String args[]){
        SearchInRotatedArray newSearch = new SearchInRotatedArray();
        newSearch.runAlgorithm();
    }

    @Override
    public void getUserData(){
        arraySize = util.getUserInt("Enter size of array to search");
        searchVal = util.getUserInt("Enter the value to search for");
        shiftVal = util.getUserInt("Enter the amount to shift the array");
        myArray = new MyArray(arraySize);
    }

    @Override
    public void runAlgorithm() {
        myArray.bubbleSort();
        myArray.rotate(shiftVal);
        myArray.print("The Array");

        System.out.println("Recursive Method:");
        int index = recusriveSearch(myArray.getData(), searchVal, 0, myArray.getSize()-1);
        if(index != -1){
            System.out.println("Your value was found at index: " + index);
        }else{
            System.out.println("Your value was not found.");
        }
    }

    /**
     * Searches the array using a divide and conquer method.  This method has additional check to handle the condition
     * of low and high numbers crossing in the middle of the array.
     * Runtime Complexity O(logN)
     * Memory Complexity O(logN)
     * @param arrayToSearch the array to search
     * @param key the value to search for.
     * @param low lower bound of array
     * @param high upper bound of array
     * @return index of match or -1 if not found
     */
    public int recusriveSearch(int[] arrayToSearch, int key, int low, int high){
        int mid = ((high - low)/2)+low;
        int midVal = arrayToSearch[mid];
        System.out.println("low:  " + low + "   mid: " + mid + "  midVal: " + midVal + "   high: " + high);

        if( midVal == key){
            return mid;                             //value found
        }


        if(arrayToSearch[low] < arrayToSearch[mid] && key < arrayToSearch[mid] && key >= arrayToSearch[low]) {
            return recusriveSearch(arrayToSearch, key, low, mid - 1);  //value is lower half
        }else if(arrayToSearch[mid] < arrayToSearch[high] && key > arrayToSearch[mid] && key <=arrayToSearch[high]){
            return recusriveSearch(arrayToSearch, key, mid + 1, high); //value is in upper half
        }else if(arrayToSearch[low] > arrayToSearch[mid]) {
            return recusriveSearch(arrayToSearch, key, low, mid - 1);
        }else if(arrayToSearch[high] < arrayToSearch[mid]){
            return recusriveSearch(arrayToSearch, key, mid + 1, high);
        }

        return -1;

    }

}
