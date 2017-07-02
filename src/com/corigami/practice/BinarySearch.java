package com.corigami.practice;

/**
 * Executes the Binary Search Algorithm
 *
 * Created by Corey Willinger on 6/26/2017.
 */
public class BinarySearch implements IAlgInterface{
    private int searchVal;
    private int arraySize;
    private AlgUtility util = new AlgUtility();
    private MyArray myArray;

    BinarySearch(){
        searchVal = util.genRandInt(0,100);
        arraySize = 100;
    }

    BinarySearch(int val, int size){
        searchVal = val;
        arraySize = size;
    }

    BinarySearch(int[] array, int val){
        searchVal = val;
        myArray = new MyArray(array);
        arraySize = array.length;
    }



    public static void main(String args[]){
        BinarySearch newSearch = new BinarySearch();
        newSearch.getUserData();
        newSearch.runAlgorithm();
     }


    @Override
    public void getUserData() {
        arraySize = util.getUserInt("Enter size of array to search");
        searchVal = util.getUserInt("Enter the value to search for");
        myArray = new MyArray(arraySize);
    }

    /**
     * This example firsts sorts the given algorithm and then recursively performs a bubble sort.  It then uses an
     * iterative method as an additional example.
     *
     */
    @Override
    public void runAlgorithm(){

        myArray.bubbleSort();
        myArray.print("The Array");

         System.out.println("Recursive Method:");
         int index = recursiveSearch(myArray.getData(), searchVal, 0, myArray.getSize()-1);
         if(index != -1){
             System.out.println("Your value was found at index: " + index);
         }else{
             System.out.println("Your value was not found.");
         }

         System.out.println("Iterative Method:");
         index = iterativeSearch(myArray.getData(), searchVal);
         if(index != -1){
             System.out.println("Your value was found at index: " + index);
         }else{
             System.out.println("Your value was not found.");
         }
     }

    /**
     * Searches the array using a divide and conquer method.
     * Runtime Complexity O(logN)
     * Memory Complexity O(logN)
     * @param arrayToSearch the array to search
     * @param key the value to search for.
     * @param low lower bound of array
     * @param high upper bound of array
     * @return index of match or -1 if not found
     */
     protected int recursiveSearch(int[] arrayToSearch, int key, int low, int high){
         int mid = ((high - low)/2)+low;
         int midVal = arrayToSearch[mid];
         System.out.println("low:  " + low + "   mid: " + mid + "  midVal: " + midVal + "   high: " + high);

         if( midVal == key){
             return mid;                             //value found
         }else if(low < high) {
             if (midVal > key) {
                 return recursiveSearch(arrayToSearch, key, low, mid - 1);  //value is lower half
             } else {
                 return recursiveSearch(arrayToSearch, key, mid + 1, high); //value is in upper half
             }
         }
         return -1;

     }

    /**
     * Searches the array using a divide and conquer method iteratively.
     * Runtime Complexity O(logN)
     * Memory Complexity O(1)
     * @param arrayToSearch
     * @param arrayToSearch the array to search
     * @param key the value to search for.
     * @return index of match or -1 if not found
     */
    protected int iterativeSearch(int[] arrayToSearch, int key){
         int low = 0;
         int high = arrayToSearch.length-1;

         while(low <= high){
             int mid = (high - low)/2 + low;
             int midVal = arrayToSearch[mid];
             System.out.println("low:  " + low + "   mid: " + mid + "  midVal: " + midVal + "   high: " + high);
             if(midVal == key) return mid;
             else{
                 if(midVal > key){
                     high = mid-1;
                 }else{
                     low = mid+1;
                 }
             }
         }

         return -1;
     }

}
