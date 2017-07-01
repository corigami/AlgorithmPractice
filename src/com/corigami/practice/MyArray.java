package com.corigami.practice;

import java.util.Random;
import java.util.ArrayDeque;

/**
 * Created by Corey Willinger on 6/26/2017.
 */

public class MyArray {
    private final int MIN;
    private final int MAX;
    private final int SIZE;
    private int[] data;

    AlgUtility util = new AlgUtility();

    MyArray(){
       this(20,0,100);
    }

    MyArray(int size){
        this(size, 0,100);
    }

    MyArray(int min, int max){
        this(20, min, max);
    }

    MyArray(int size, int min, int max){
        SIZE = size;
        MIN = min;
        MAX = max;
        data = new int[SIZE];
        fill();
    }

    MyArray(int[] data){
        this.data = data;
        SIZE = data.length;
        MIN = 0;
        MAX = 100;
    }


    /**
     * Fills array with random values
     */
    public void fill(){
        util = new AlgUtility();
        Random random = util.genRandom();
        for(int i=0; i < SIZE; i++){
            data[i] = random.nextInt((MAX - MIN) + 1) + MIN;
        }
    }

    /**
     * Prints the contents of the array
     * @param header String header to precede the array.
     */
    public void print(String header){
        System.out.println(header + ":");
        System.out.print("[");
        for(int i = 0; i < SIZE; i++){
            System.out.print(data[i]);
            if(i != SIZE - 1) {
                System.out.print(", ");
            }
            else {
                System.out.println("]");
            }
        }
    }

    /**
     * returns contents of array
     * @return array of integers
     */
    public int[] getData(){
        return data;
    }

    public int getDataAt(int i){
        return data[i];
    }

    /**
     * Returns the size of the array
     * @return
     */
    public int getSize(){
        return SIZE;
    }

    protected void bubbleSort(){
        for(int i = 0; i < SIZE; i++){
            for(int j=1; j < SIZE-i; j++){
                if(data[j]< data[j-1]){
                    swap(j-1, j);
                }
            }
        }
    }

    /**
     * Rotates the contents of the array by a set value.
     * @param val
     */
    protected void rotate(int val){
        ArrayDeque<Integer> window = new ArrayDeque<>();
        val %= (SIZE);
        for(int i = 0; i <= val-1; i++){
            window.addFirst(data[i]);
        }

        for(int i = val; i < data.length; i++){
            window.addFirst(data[i]);
            data[i]=window.removeLast();
        }

        for(int i = 0; i <val; i++){
            data[i] = window.removeLast();
        }
    }

     private void swap(int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
