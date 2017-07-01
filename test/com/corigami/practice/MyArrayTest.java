package com.corigami.practice;

import com.corigami.practice.MyArray;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by Corey Willinger on 6/29/2017.
 */
public class MyArrayTest {

    private MyArray testArray;

    @org.junit.Before
    public void setUp() throws Exception {

        testArray = new MyArray(20, 0,100);

    }

    @org.junit.Test
    public void testArrayConstructor() throws Exception{
        int[] testArray = new int[10];
        MyArray myArray = new MyArray(testArray);
        assertNotNull(myArray);
    }

    @org.junit.Test
    public void rotate() throws Exception {
        int rotatateAmt = 5;
        testArray.bubbleSort();
        int newFirstVal = testArray.getDataAt(testArray.getSize()-rotatateAmt);
        int newLastVal = testArray.getDataAt(testArray.getSize()-(rotatateAmt+1));
        testArray.rotate(rotatateAmt);
        assertEquals("first index is wrong",newFirstVal,testArray.getDataAt(0));
        assertEquals("last index is wrong",newLastVal,testArray.getDataAt(testArray.getSize()-1));
    }

    @org.junit.Test
    public void rotateAmountLargerThanArray() throws Exception {
        int rotatateAmt = 25;
        int rotateMod = rotatateAmt % testArray.getSize();
        testArray.bubbleSort();
        int newFirstVal = testArray.getDataAt(testArray.getSize() - rotateMod);
        int newLastVal = testArray.getDataAt(testArray.getSize() - (rotateMod + 1));
        testArray.rotate(rotatateAmt);
        assertEquals("first index is wrong", newFirstVal, testArray.getDataAt(0));
        assertEquals("last index is wrong", newLastVal, testArray.getDataAt(testArray.getSize() - 1));
    }

}