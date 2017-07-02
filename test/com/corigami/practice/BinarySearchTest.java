package com.corigami.practice;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the Binary Search Algorithm
 * Created by Corey Willinger on 7/1/2017.
 */


class BinarySearchTest {
    BinarySearch testSearch;
    int[] testArray;
    @BeforeEach
    void setUp() {
        testArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7,8,9};
        testSearch = new BinarySearch(testArray, 0);//key value is not required for testing
    }

    @Test
    @DisplayName("Test Recursive Binary Search Method")
    void recursiveSearch() {
        assertEquals(0,testSearch.recursiveSearch(testArray,0,0,9),"did not find first entry");
        testSearch = new BinarySearch(testArray, 9);
        assertEquals(9,testSearch.recursiveSearch(testArray,9,0,9),"did not find last entry");
    }


    @Test
    @DisplayName("Test Iterative Binary Search Method")
    void iterativeSearch() {
        assertEquals(0,testSearch.iterativeSearch(testArray,0),"did not find first entry");
        assertEquals(9,testSearch.iterativeSearch(testArray,9),"did not find last entry");
    }

}



