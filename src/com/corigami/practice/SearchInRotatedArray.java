package com.corigami.practice;

import java.util.Scanner;

/**
 * Created by Corey Willinger on 6/29/2017.
 */
public class SearchInRotatedArray { //TODO refactor for testing and menu interface

    public static void main(String args[]){
        runAlgorithm();
    }

    public static void runAlgorithm() {

        MyArray myArray;
        int searchVal;
        int shiftVal;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size of array to search: ");
        myArray = new MyArray(input.nextInt());
        System.out.print("Enter the value to search for:");
        searchVal = input.nextInt();
        System.out.print("Enter the amount to shift rotate array:");
        shiftVal = input.nextInt();
        myArray.bubbleSort();
        myArray.rotate(shiftVal);
        myArray.print("The Array");

        System.out.println("Recursive Method:");
        int index = divideAndConquer(myArray.getData(), searchVal, 0, myArray.getSize()-1);
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
    static int divideAndConquer(int[] arrayToSearch, int key, int low, int high){
        int mid = ((high - low)/2)+low;
        int midVal = arrayToSearch[mid];
        System.out.println("low:  " + low + "   mid: " + mid + "  midVal: " + midVal + "   high: " + high);

        if( midVal == key){
            return mid;                             //value found
        }


        if(arrayToSearch[low] < arrayToSearch[mid] && key < arrayToSearch[mid] && key >= arrayToSearch[low]) {
            return divideAndConquer(arrayToSearch, key, low, mid - 1);  //value is lower half
        }else if(arrayToSearch[mid] < arrayToSearch[high] && key > arrayToSearch[mid] && key <=arrayToSearch[high]){
            return divideAndConquer(arrayToSearch, key, mid + 1, high); //value is in upper half
        }else if(arrayToSearch[low] > arrayToSearch[mid]) {
            return divideAndConquer(arrayToSearch, key, low, mid - 1);
        }else if(arrayToSearch[high] < arrayToSearch[mid]){
            return divideAndConquer(arrayToSearch, key, mid + 1, high);
        }

        return -1;

    }

}
