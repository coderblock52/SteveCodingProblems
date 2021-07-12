package com.company;
/*
Challenge Problem:
Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.
 */

import com.company.FindSmallestPosInt.GenRandArray;
import com.company.FindSmallestPosInt.Solution;

public class Main {

    public static void main(String[] args) {
        int[] intArray; //array to check against
        GenRandArray generate = new GenRandArray(); //generate randomization class
        int result; //the lowest positive integer not in the array result
        Solution findResult = new Solution();

        intArray = generate.GenerateArray(); //generate array randomly

        result = findResult.RecursCheck(intArray);

        System.out.println("\nthe lowest possible int not in the array is: " + result);

    }
}