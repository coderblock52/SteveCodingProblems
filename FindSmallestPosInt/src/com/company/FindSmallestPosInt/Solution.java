package com.company.FindSmallestPosInt;

public class Solution {
    private int lowestPosInt;

    public Solution()
    {
        lowestPosInt = 0;
    }

    public Solution(int lowestPosInt)
    {
        SetlowestPosInt(lowestPosInt);
    }

    public int GetlowestPosInt() //getter
    {
        return lowestPosInt;
    }

    public void SetlowestPosInt(int lowestPosInt) //setter
    {
        this.lowestPosInt = lowestPosInt;
    }

    public int RecursCheck(int[] arr)
    {
        int lowFound = 1; //default 1 is the lowest possible positive value
        int i = 0; //index

        if(arr.length < 1)
            return 0; //if there is no list, return 0

        if (arr.length == 1)
        {
            if(arr[0] == 1)
                return 2; //if there is one element and it is one, return 2
            else
                return 1; //otherwise 1 is always the lost positive value possible
        }


        arr = organize(arr); //organize/sort list

        if (arr[i] == 1)
            lowFound = 2; //if the first element is one, set lowest possible now to 2
        else if(arr[i] > 1) {
            SetlowestPosInt(1); //if the first element is already a positive larger than 1, return 1
            return lowestPosInt;
        }

        SetlowestPosInt(RecursCheck(i + 1, arr, lowFound)); //recurse through the list
        return lowestPosInt;
    }

    private int RecursCheck(int i, int[] arr, int lowFound)
    {
        if(i == arr.length)
            return lowFound; //if we are outside bounds, return current value

        if(arr[i] > lowFound)
            return lowFound; //if the current element is greater than current lowest value, return it
        else if(arr[i] == lowFound) //if the current number is equal to lowest found, increment by one
            ++lowFound;

        return RecursCheck(i+1, arr, lowFound);
    }

    //sort the list in ascending order to find the lowest from
    private int[] organize(int[] arr)
    {
        int swap; //swap variable for swapping index positions
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = i+1; j < arr.length; j++)
            {
                if(arr[i] > arr[j])
                {
                    swap = arr[i];
                    arr[i] = arr[j];
                    arr[j] = swap;
                }
            }
        }
        System.out.println("new array is: ");
        for(int i = 0; i <arr.length; i++)
            System.out.print(arr[i] + ", ");

        return arr;
    }

}
