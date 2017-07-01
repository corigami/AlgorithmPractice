package com.corigami.practice;

import java.util.PriorityQueue;
import java.util.ArrayDeque;

/**
 * Created by Corey Willinger on 6/28/2017.
 */
public class MaxInSlidingWindow {


    public static void main(String args[]){
        runAlgorithm();
    }

    public static void runAlgorithm() {
        AlgUtility util = new AlgUtility();
        MyArray myArray = new MyArray(util.getUserInt("Enter size of array to search"));
        int windowSize = util.getUserInt("Enter window size of array");
        myArray.print("The Array");

        System.out.println("Double Linked List Method:");
        findMaxInWindow(myArray.getData(),windowSize );

        System.out.println("Heap Method:");
        findMaxInWindowWithHeap(myArray.getData(),windowSize );
    }

    /**
     * Searches the array and finds the maximum value for every window size.  Uses a doubly linked list to store the
     *      current window so items can be removed or added to the head or tail.
     * Runtime Complexity O(n)
     * Memory Complexity O(w)
     * @param arrayToSearch the array to search through
     * @param winSize size of the window to evaluate.
     */
    static void  findMaxInWindow(int[] arrayToSearch, int winSize){
        ArrayDeque<Integer> window = new ArrayDeque<>();
        int winNum = 1;

        //go through the array and only add the highest index to the window for the initial window size
        for(int i = 0; i < winSize; i++){
            while(!window.isEmpty() && arrayToSearch[i] >= arrayToSearch[window.peekLast()]){
                window.removeLast();
            }

            window.addLast(i);
        }
        System.out.println("Window " + winNum++ + ": " + arrayToSearch[window.peekFirst()]);

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
            System.out.println("Window " + winNum++ + ": " + arrayToSearch[window.peekFirst()]);
        }

    }

    static void findMaxInWindowWithHeap(int[] arrayToSearch, int winSize){
        PriorityQueue<Integer> window = new PriorityQueue<>((x,y) -> y-x);
        int winNum = 1;

        //go through the array and only add the items in the window to the heap
        for(int i = 0; i < winSize; i++){
            window.add(arrayToSearch[i]);
            }

        System.out.println("Window " + winNum++ + ": " + window.peek());

        // for each move, remove oldest object and add newest to the heap
        for(int i = winSize; i < arrayToSearch.length; i++){
            window.remove(arrayToSearch[i-winSize]);
            window.add(arrayToSearch[i]);
            System.out.println("Window " + winNum++ + ": " + window.peek());
        }
    }

}
