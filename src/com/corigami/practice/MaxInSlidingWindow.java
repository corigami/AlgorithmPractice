package com.corigami.practice;

import java.util.PriorityQueue;
import java.util.ArrayDeque;

/**
 * Created by Corey Willinger on 6/28/2017.
 */
public class MaxInSlidingWindow implements IAlgInterface {
    private AlgUtility util = new AlgUtility();
    private MyArray myArray;
    private int windowSize;
    private int arraySize;
    private int[] results;  //used for testing

    MaxInSlidingWindow(){
        windowSize = util.genRandInt(3,5);
        myArray = new MyArray();
        arraySize = myArray.getSize();
        results = new int[arraySize-windowSize+1];
    }

    MaxInSlidingWindow(int[] array, int WinSize){
        windowSize = WinSize;
        myArray = new MyArray(array);
        arraySize = array.length;
        results = new int[arraySize-windowSize+1];
    }

    MaxInSlidingWindow(int arraySize, int winSize){
        windowSize = winSize;
        arraySize = arraySize;
        results = new int[arraySize-windowSize+1];
    }

    public int[] getResults() {
        return results;
    }


    public static void main(String args[]){
        MaxInSlidingWindow maxInSlide = new MaxInSlidingWindow();
        maxInSlide.getUserData();
        maxInSlide.runAlgorithm();
    }

    /**
     * Give the user an option to override the default random values
     * used in the default constructor.
     */
    @Override
    public void getUserData() {
        arraySize = util.getUserInt("Enter size of array to search");
        windowSize = util.getUserInt("Enter window size of array");
        results = new int[arraySize-windowSize+1];
        myArray = new MyArray(arraySize);
    }

    public void runAlgorithm() {
        myArray.print("The Array");

        System.out.println("Double Linked List Method:");
        findMaxInWindow(myArray.getData(),windowSize );

        for(int i = 0; i <results.length; i++){
            System.out.println("Window " + i + ": " + results[i]);
        }


        System.out.println("Heap Method:");
        findMaxInWindowWithHeap(myArray.getData(),windowSize );

        for(int i = 0; i <results.length; i++){
            System.out.println("Window " + i + ": " + results[i]);
        }
    }

    /**
     * Searches the array and finds the maximum value for every window size.  Uses a doubly linked list to store the
     *      current window so items can be removed or added to the head or tail.
     * Runtime Complexity O(n)
     * Memory Complexity O(w)
     * @param arrayToSearch the array to search through
     * @param winSize size of the window to evaluate.
     */
    public void findMaxInWindow(int[] arrayToSearch, int winSize){
        ArrayDeque<Integer> window = new ArrayDeque<>();
        int winNum = 0;

        //go through the array and only add the highest index to the window for the initial window size
        for(int i = 0; i < winSize; i++){
            while(!window.isEmpty() && arrayToSearch[i] >= arrayToSearch[window.peekLast()]){
                window.removeLast();
            }
            window.addLast(i);
        }
        results[winNum++] = arrayToSearch[window.peekFirst()];

        for(int i = winSize; i < arrayToSearch.length; i++){
            //remove any indices from the window that are less than newest element.
            while(!window.isEmpty() && arrayToSearch[i] > arrayToSearch[window.peekLast()]){
                window.removeLast();
            }

            //remove the first element if it is no longer win the window
            if(!window.isEmpty() && window.peekFirst() <= i - winSize){
                window.removeFirst();
            }

            //add the current element to the tail of the window
            window.addLast(i);
            results[winNum++] = arrayToSearch[window.peekFirst()];
        }
    }

    public void findMaxInWindowWithHeap(int[] arrayToSearch, int winSize){
        PriorityQueue<Integer> window = new PriorityQueue<>((x,y) -> y-x);
        int winNum = 0;

        //go through the array and only add the items in the window to the heap
        for(int i = 0; i < winSize; i++){
            window.add(arrayToSearch[i]);
            }
        results[winNum++] = window.peek();

        // for each move, remove oldest object and add newest to the heap
        for(int i = winSize; i < arrayToSearch.length; i++){
            window.remove(arrayToSearch[i-winSize]);
            window.add(arrayToSearch[i]);
            results[winNum++] = window.peek();
        }
    }

}
