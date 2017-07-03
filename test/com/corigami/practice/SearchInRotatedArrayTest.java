package com.corigami.practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Corey Willinger on 7/3/2017.
 */
class SearchInRotatedArrayTest {
    int[] testArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int rotateAmount = 3;
    int searchKey = 5;
    SearchInRotatedArray mySearch;

    @BeforeEach
    void setUp() {
        mySearch = new SearchInRotatedArray(testArray,searchKey,rotateAmount);
        mySearch.getMyArray().bubbleSort();
        mySearch.getMyArray().rotate(rotateAmount);
    }

    @Test
    @DisplayName("Test Recursive search algorithm for rotated arrays")
    void recursiveSearch() {
        assertEquals(rotateAmount+searchKey, mySearch.recursiveSearch(mySearch.getMyArray().getData(),
            searchKey,0,9),"Didn't find correct index");
        assertEquals(0, mySearch.recursiveSearch(mySearch.getMyArray().getData(),
                7,0,9),"Didn't find correct index");
        assertEquals(9, mySearch.recursiveSearch(mySearch.getMyArray().getData(),
                6,0,9),"Didn't find correct index");

    }

}