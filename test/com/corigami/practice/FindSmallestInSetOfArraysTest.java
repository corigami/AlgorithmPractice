package com.corigami.practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Basic unit tests.  Checks for positive and negative responses.  Assumes all ints in the arrays
 * are positive.  Also tests correct handling of array of different lengths.
 * Created by Corey Willinger on 7/5/2017.
 */
class FindSmallestInSetOfArraysTest {
    FindSmallestInSetOfArrays testSearch;
    MyArray testArray1;
    MyArray testArray2;
    MyArray testArray3;
    MyArray testArray4;
    MyArray[] myTestArrays;


    @BeforeEach
    void setUp() {
        testArray1 = new MyArray(new int[]{0, 2, 4, 6,8, 10, 12, 14,16,18});
        testArray2 = new MyArray(new int[]{1,3,9,12,15,18});
        testArray3 = new MyArray(new int[]{0,1,4,8,12,16,20,24,28,32,36,40,44});
        testArray4 = new MyArray(new int[]{0, 1, 3, 5, 7, 9});
    }

    /**
     * Checks for the known match of 12 in arrays 1,2, and 3.
     */
    @Test
    @DisplayName("Test for match")
    void testForKnownMatch() {
        myTestArrays = new MyArray[]{testArray1, testArray2, testArray3};
        testSearch = new FindSmallestInSetOfArrays(myTestArrays);
        assertEquals(12, testSearch.searchForSmallest());
    }


    /**
     * Verifies the correct response that no match exists in arrays 1,2, and 4
     */
    @Test
    @DisplayName("Test for noMatch")
    void testForNoMatch() {
        myTestArrays = new MyArray[]{testArray1, testArray2, testArray4};
        testSearch = new FindSmallestInSetOfArrays(myTestArrays);
        assertEquals(-1, testSearch.searchForSmallest());
    }

}