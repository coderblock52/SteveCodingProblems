package com.company.FindSmallestPosInt;
import java.util.Random;

//code found at
//https://www.tutorialspoint.com/generate-a-random-array-of-integers-in-java

public class GenRandArray {
    public int[] arr;

    public int[] GenerateArray() {
        Random rd = new Random(); // creating Random object
        arr = new int[7];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt() % 10; // storing random integers in an array
            System.out.println(arr[i]); // printing each array element
        }

        return arr;
    }
}