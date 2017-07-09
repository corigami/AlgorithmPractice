package com.corigami.practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Corey Willinger on 7/9/2017.
 */
class ShiftElementsTest {
    private ShiftElements algToTest;

    @BeforeEach
    void setUp() {
        algToTest = new ShiftElements();
    }

    @Test
    @DisplayName("Default Constructor test")
    void testConstructor(){
        assertNotNull(algToTest,"Object was null");
        assertNotNull(algToTest.getMyArray(), "MyArray object was null");
        assertTrue(algToTest.getMyArray().getData().length > 0,"array was empty");
    }

    @Test
    @DisplayName("Test value left")
    void testShiftToFront(){
        int valToShift = 0;
        int[] beforeShift = new int[]{1,1,1,0,2,2,2,0,3,3,3,0,4,4,4,0};
        int[] afterShiftLeft = new int[]{0,0,0,0,1,1,1,2,2,2,3,3,3,4,4,4};
        algToTest = new ShiftElements(beforeShift);
        algToTest.shiftToFront(valToShift);
        assertArrayEquals(afterShiftLeft,beforeShift,"Array does not match.");
    }

    @Test
    @DisplayName("Test value left")
    void testShiftToEnd(){
        int valToShift = 0;
        int[] beforeShift = new int[]{1,1,1,0,2,2,2,0,3,3,3,0,4,4,4,0};
        int[] afterShiftRight = new int[]{1,1,1,2,2,2,3,3,3,4,4,4,0,0,0,0};
        algToTest = new ShiftElements(beforeShift);
        algToTest.shiftToEnd(valToShift);
        assertArrayEquals(afterShiftRight,beforeShift,"Array does not match.");
    }

}