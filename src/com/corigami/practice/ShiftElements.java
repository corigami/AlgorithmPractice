package com.corigami.practice;

/**
 * Algorithm to shift all instances of the selected value to the beging or end of the
 * array.
 *
 * Created by Corey Willinger on 7/9/2017.
 */
public class ShiftElements implements IAlgInterface {
    MyArray myArray;

    ShiftElements(){
        myArray = new MyArray(20,0,10);
    }

    ShiftElements(int[] array){
        myArray = new MyArray(array);
    }

    public MyArray getMyArray() {
        return myArray;
    }


    public static void main(String[] args){
        ShiftElements algToRun = new ShiftElements();
    }
    /**
     * Requests data from the user to initialize algorithm conditions
     */
    @Override
    public void getUserData() {

    }

    /**
     * Runs the algorithm example.
     */
    @Override
    public void runAlgorithm() {

    }

    /**
     * Shifts the selected value to the beging of the array.
     * @param valToShift
     */
    public void shiftToFront(int valToShift){
        int[] arrayToShift = myArray.getData();
        int pointer = arrayToShift.length-1;
        int index = arrayToShift.length -1;

        while(index >=0){
            if(arrayToShift[index] != valToShift){
                arrayToShift[pointer] = arrayToShift[index];
                pointer--;
            }
            index--;
        }
        for(int i=0; i <=pointer;i++){
            arrayToShift[i] = valToShift;
        }
    }

    /**
     * Shifts the selected value to the beging of the array.
     * @param valToShift
     */
    public void shiftToEnd(int valToShift){
        int[] arrayToShift = myArray.getData();
        int pointer = 0;
        int index = 0;

        while(index < arrayToShift.length){
            if(arrayToShift[index] != valToShift){
                arrayToShift[pointer] = arrayToShift[index];
                pointer++;
            }
            index++;
        }
        for(int i=arrayToShift.length-1; i >= pointer; i--){
            arrayToShift[i] = valToShift;
        }
    }



}
