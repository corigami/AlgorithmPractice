package com.corigami.practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for AlgUtility class
 * Created by Corey Willinger on 7/9/2017.
 */
class AlgUtilityTest {
        AlgUtility algUtilityToTest;
    @BeforeEach
    void setUp() {
        algUtilityToTest = new AlgUtility();
    }

    @Test
    @DisplayName("Test basic function")
    void genArray1() {
        int[] testArray = algUtilityToTest.genArray(1000, 0,100);
        assertNotNull(testArray,"Array is null");
        assertEquals(1000, testArray.length, "Size does not match");
        for (int x: testArray){
            assertTrue(x >= 0,"Element is less than min");
            assertTrue(x <= 100,"Element is greater than max");
        }
    }

    @Test
    @DisplayName("Array Generator  - Negative Values Test ")
    void genArray2() {
        int[] testArray = algUtilityToTest.genArray(100, -100,100);
        for (int x: testArray){
            assertAll(
                    ()->assertTrue(x >= -100, "value below range"),
                    ()->assertTrue(x <= 100, "value is above range")
            ); }
    }

    @Test
    @DisplayName("Test Random Object generator")
    void genRandom() {
        Random testRand = algUtilityToTest.genRandom();
        assertNotNull(testRand);
    }

    @Test
    @DisplayName("Random Interger Test 0-100")
    void genRandInt1() {
        int temp = algUtilityToTest.genRandInt(0,100);
        assertAll(
                ()->assertTrue(temp >= 0, "value below range"),
                ()->assertTrue(temp <= 100, "value is above range")
        );
    }
}