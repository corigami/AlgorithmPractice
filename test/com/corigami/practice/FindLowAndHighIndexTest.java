package com.corigami.practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Corey Willinger on 7/7/2017.
 */
class FindLowAndHighIndexTest {
    FindLowAndHighIndex testSearch;
    int[] testArray;
    int key;

    @Test
    @DisplayName("Find Low index at beginning")
    void findLowIndex1() {
        key = 0;
        testArray = new int[]{0, 0,0,0,0,0,1,1,1,1,1,1,2,2,2,2,2,2,2};
        testSearch = new FindLowAndHighIndex(testArray,key);//key value is not required for testing
        assertEquals(0,testSearch.findLowIndex(key),"Didn't find correct index");
    }

    @Test
    @DisplayName("Find Low index in middle")
    void findLowIndex2() {
        key = 1;
        testArray = new int[]{0, 0,0,0,0,0,1,1,1,1,1,1,2,2,2,2,2,2,2};
        testSearch = new FindLowAndHighIndex(testArray,key);//key value is not required for testing
        assertEquals(6,testSearch.findLowIndex(key),"Didn't find correct index");
    }

    @Test
    @DisplayName("Find Low index at end")
    void findLowIndex3() {
        key = 2;
        testArray = new int[]{0, 0,0,0,0,0,1,1,1,1,1,1,2,2,2,2,2,2,2};
        testSearch = new FindLowAndHighIndex(testArray,key);//key value is not required for testing
        assertEquals(12,testSearch.findLowIndex(key),"Didn't find correct index");
    }

    @Test
    @DisplayName("Index not found test")
    void findLowIndex4() {
        key = 4;
        testArray = new int[]{0, 0,0,0,0,0,1,1,1,1,1,1,2,2,2,2,2,2,2};
        testSearch = new FindLowAndHighIndex(testArray,key);//key value is not required for testing
        assertEquals(-1,testSearch.findLowIndex(key),"Didn't find correct index");
    }

    @Test
    @DisplayName("Find High index at beginning")
    void findHighIndex1() {
        key = 0;
        testArray = new int[]{0, 0,0,0,0,0,1,1,1,1,1,1,2,2,2,2,2,2,2};
        testSearch = new FindLowAndHighIndex(testArray,key);//key value is not required for testing
        assertEquals(5,testSearch.findHighIndex(key),"Didn't find correct index");
    }

    @Test
    @DisplayName("Find High index in middle")
    void findHighIndex2() {
        key = 1;
        testArray = new int[]{0, 0,0,0,0,0,1,1,1,1,1,1,2,2,2,2,2,2,2};
        testSearch = new FindLowAndHighIndex(testArray,key);//key value is not required for testing
        assertEquals(11,testSearch.findHighIndex(key),"Didn't find correct index");
    }

    @Test
    @DisplayName("Find High index at end")
    void findHighIndex3() {
        key = 2;
        testArray = new int[]{0, 0,0,0,0,0,1,1,1,1,1,1,2,2,2,2,2,2,2};
        testSearch = new FindLowAndHighIndex(testArray,key);//key value is not required for testing
        assertEquals(18,testSearch.findHighIndex(key),"Didn't find correct index");
    }

    @Test
    @DisplayName("Index not found test")
    void findHighIndex4() {
        key = 4;
        testArray = new int[]{0, 0,0,0,0,0,1,1,1,1,1,1,2,2,2,2,2,2,2};
        testSearch = new FindLowAndHighIndex(testArray,key);//key value is not required for testing
        assertEquals(-1,testSearch.findHighIndex(key),"Didn't find correct index");
    }


}