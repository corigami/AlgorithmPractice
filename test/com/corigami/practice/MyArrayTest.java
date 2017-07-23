package com.corigami.practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * Created by Corey Willinger on 6/29/2017.
 */
class MyArrayTest {
    MyArray testArray;

    @BeforeEach
    void setUp(){
        testArray = new MyArray(20, 0,100);
    }

    @Test
    @DisplayName("Test constructor")
    void testArrayConstructor() {
        int[] testArray = new int[10];
        MyArray myArray = new MyArray(testArray);
        assertNotNull(myArray);
    }

    @Test
    @DisplayName("Test Rotate Function")
    void rotate(){
        int rotatateAmt = 5;
        testArray.bubbleSort();
        int newFirstVal = testArray.getDataAt(testArray.getSize()-rotatateAmt);
        int newLastVal = testArray.getDataAt(testArray.getSize()-(rotatateAmt+1));
        testArray.rotate(rotatateAmt);
        assertAll(
                ()->assertEquals("first index is wrong",newFirstVal,testArray.getDataAt(0)),
                ()->assertEquals("last index is wrong",newLastVal,testArray.getDataAt(testArray.getSize()-1))
        );
    }

    @Test
    @DisplayName("Test if Rotate is larger than Array")
    void rotateAmountLargerThanArray() {
        int rotatateAmt = 25;
        int rotateMod = rotatateAmt % testArray.getSize();
        testArray.bubbleSort();
        int newFirstVal = testArray.getDataAt(testArray.getSize() - rotateMod);
        int newLastVal = testArray.getDataAt(testArray.getSize() - (rotateMod + 1));
        testArray.rotate(rotatateAmt);
        assertEquals("first index is wrong", newFirstVal, testArray.getDataAt(0));
        assertEquals("last index is wrong", newLastVal, testArray.getDataAt(testArray.getSize() - 1));
    }

    @Test
    @DisplayName("Test Quick sort")
    void quickSortTest(){
        testArray.quickSort();
        int[] values = testArray.getData();
        for (int i = 1; i < values.length; i++){
            assertTrue(values[i-1] <= values[i]);
        }
    }


}