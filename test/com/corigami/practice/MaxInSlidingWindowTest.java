package com.corigami.practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the MaxInSlidingWindow Algorithm
 * Created by Corey Willinger on 7/2/2017.
 */
class MaxInSlidingWindowTest {

    MaxInSlidingWindow testMax;
    int[] testArray;
    final int WINDOWSIZE = 3;
    int[] results;


    @BeforeEach
    void setUp() {
        testArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7,8,9};
        results = new int[]{2,3,4,5,6,7,8,9};
        testMax = new MaxInSlidingWindow(testArray, WINDOWSIZE);
    }

    @Test
    @DisplayName("Test Basic Find Max in Window Method")
    void findMaxInWindow() {
        testMax.findMaxInWindow(testArray,WINDOWSIZE);
        assertArrayEquals(results,testMax.getResults() ,"array does not match");
     }

    @Test
    @DisplayName("Test Find Max in Window with Heap Method")
    void findMaxInWindowWithHeap() {
        testMax.findMaxInWindowWithHeap(testArray,WINDOWSIZE);
        assertArrayEquals(results,testMax.getResults() ,"array does not match");
    }

}