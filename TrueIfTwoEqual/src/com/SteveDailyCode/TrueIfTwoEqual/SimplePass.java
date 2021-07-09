package com.SteveDailyCode.TrueIfTwoEqual;
//my simple pass method
//does not attempt to complete the assigned problem in one pass
//designed by: Myself
public class SimplePass {
    private int index; //index size for array
    private int[] numberedList; //array to check
    private int k; //k value to check against

    public SimplePass() //default constructor
    {
        index = 0;
        numberedList = new int[index];
        numberedList[0] = 0;
        k = 0;
    }

    public SimplePass(int[] numberedList, int k) //constructor with arguments
    {
       index = numberedList.length;
       this.numberedList = new int[index];
       for(int i = 0; i< index; ++i) //check each element of the array based on index size
       {
           this.numberedList[i] = numberedList[i]; //set every array element in my numbered list to given numbered list
       }
       this.k= k;
    }

    public boolean Pass() //my simple path method to running through and passing
    {
        boolean ifAdd = false; //set bool
        int sum = 0; //set sum for check
        if(numberedList.length < index) //check if array was correctly initialized
            return ifAdd; //return false if array was not initialized


        for(int i = 0; i < index-1; ++i) //iterate through whole list to test each number
        {
            for(int j=i+1; j < index; ++j) //iterate through whole list from initial position
            {
                sum = numberedList[i] + numberedList[j];
                if(sum == k) //if the sum of the two numbers is equal to desired value k
                {
                    ifAdd = true; //set bool to be true
                    return ifAdd; //return true
                }
            }
        }

        return ifAdd; //if sum has never equaled, return false
    }
}
