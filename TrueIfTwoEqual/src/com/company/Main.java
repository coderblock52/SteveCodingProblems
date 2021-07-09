package com.company;

import com.SteveDailyCode.TrueIfTwoEqual.SimplePass;

/*
Challenge description:
Given a list of numbers and a number k, return whether any two numbers from the list add up to k

example: given [10,4,9,7] and k of 17, return true since 10+7 = 17

bonus: do it in one pass

PROVIDED BY: Daily Coding Problems
 */
public class Main {

    public static void main(String[] args) {
        int[] listToCheck = {1, 2, 3};
        int k = 3;
        SimplePass simpletest = new SimplePass(listToCheck, k);

        boolean test = simpletest.Pass();
        System.out.println("the return value is " + test);
    }
}
