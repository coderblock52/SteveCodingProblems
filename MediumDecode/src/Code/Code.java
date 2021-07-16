package Code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Code {
    private final String[][]  mapping; //used string data type as string should be easier
                        //to parse than integer

    private List<String> result;

    public Code()
    {
        /*
        HashMap<Integer, String> foo = new HashMap<>();
        foo.put(1, "a");
        String theLetterA = foo.get(1);
        //alternative solution for hash map - to be reimplemented later
*/

        result = null; //value will be initialized upon start of decoder
        mapping = new String[][] { //map all numbers to their letters
                {"a", "1"},
                {"b", "2"},
                {"c", "3"},
                {"d", "4"},
                {"e", "5"},
                {"f", "6"},
                {"g", "7"},
                {"h", "8"},
                {"i", "9"},
                {"j", "10"},
                {"k", "11"},
                {"l", "12"},
                {"m", "13"},
                {"n", "14"},
                {"o", "15"},
                {"p", "16"},
                {"q", "17"},
                {"r", "18"},
                {"s", "19"},
                {"t", "20"},
                {"u", "21"},
                {"v", "22"},
                {"w", "23"},
                {"x", "24"},
                {"y", "25"},
                {"z", "26"},
        };
    }
    //method to print the cipher in case I wanted to
       public void printCipher()
       {
           //
           System.out.println("a = " + mapping[0][1]);
           System.out.println("b = " + mapping[1][1]);
           System.out.println("c = " + mapping[2][1]);
           System.out.println("d = " + mapping[3][1]);
           System.out.println("e = " + mapping[4][1]);
           System.out.println("f = " + mapping[5][1]);
           System.out.println("g = " + mapping[6][1]);
           System.out.println("h = " + mapping[7][1]);
           System.out.println("i = " + mapping[8][1]);
           System.out.println("j = " + mapping[9][1]);
           System.out.println("k = " + mapping[10][1]);
           System.out.println("l = " + mapping[11][1]);
           System.out.println("m = " + mapping[12][1]);
           System.out.println("n = " + mapping[13][1]);
           System.out.println("o = " + mapping[14][1]);
           System.out.println("p = " + mapping[15][1]);
           System.out.println("q = " + mapping[16][1]);
           System.out.println("r = " + mapping[17][1]);
           System.out.println("s = " + mapping[18][1]);
           System.out.println("t = " + mapping[19][1]);
           System.out.println("u = " + mapping[20][1]);
           System.out.println("v = " + mapping[21][1]);
           System.out.println("w = " + mapping[22][1]);
           System.out.println("x = " + mapping[23][1]);
           System.out.println("y = " + mapping[24][1]);
           System.out.println("z = " + mapping[25][1]);

       }




       //method to decode and find all solutions
       public int decode(String todecode) { //pass string to be decoded
        int length = todecode.length(); //get length of string for improved access time
        if(length == 0) //if the string is empty, just return 0
            return 0;
        else if(length ==1) //if there is only one element, return there is only 1 combination
            return 1;

       result = new ArrayList<>(); //initialize String list array

           //tests playing around with List
//        result.add("myself");
//        result.add("is");
//        result.add("me");
//        for(int i =0; i < result.size(); i++)
//            System.out.print(result.get(i));

           int counter = decoderecurse(todecode, length, 0, ""); //return value provided by recursive function, counter variable is what is returned up recursion
           System.out.println("Final resulting list is: " + result);
           return counter;
       }

       //recurse through numbers and find all combinations
       private int decoderecurse(String todecode, int length, int index, String curr)
       {
           System.out.println("index: " + index); //note the index - for testing and tracking purposes
           //last number in the list check case
           if(index >= length) { //if we are out of bounds from jumping 2 indexes or at the end of the list
               result.add(curr); //add the list we've been building to the List
               System.out.println(result); //print results - for testing and tracking purposes
               return 1; //return that we found 1 complete combination/tree
           }

           int counter  = 0; //counter used in this iteration to keep track of combinations found

           //single number check case
//           String myLetterIndex = Character.toString(todecode.charAt(index)); //grab single character, convert to String
//           String myLetterIndex = todecode.substring(index, index+1);
           int mapIndex = Integer.parseInt(todecode.substring(index, index+1)); //convert string value to int
//           System.out.println(mapping[mapIndex-1][1] + " " + mapping[mapIndex-1][0]); //display map index based on int // print grabbed mapIndex value in Mapping - for testing and tracking purposes
           String currdouble = curr; //hold onto current list
           curr += mapping[mapIndex-1][0]; //give curr mapping's string associated with given index, which tracks all characters found, to be passed down

           counter += decoderecurse(todecode, length, index+1, curr); //recurse down after checking single number case (in "123", it would be 1 or 2 or 3)


           //double number check case
           if(index + 2 > length) //if we have reached last or second to last element, we will reach out of bounds if continue
           {
               System.out.println("exit index: " + index + " with length: " + length);
               return counter; //return current counter total
           }

           System.out.println("index at double: " + index); //note the index - for testing and tracking purposes
//           myLetterIndex = todecode.substring(index,index+2); //grab two numbers
           mapIndex = Integer.parseInt(todecode.substring(index, index+2)); //reuse sub-index vars to get new place of next index to check based on two nums instead of one (in "123", this would be "12" or "23")
           if(mapIndex > mapping.length) //if the mapIndex grabbed goes out of bounds for the mapping, then return count as there are no doubles to consider here
               return counter;
           System.out.println(mapping[mapIndex-1][1] + " " + mapping[mapIndex-1][0]); //print out mapping variable found - for testing and tracking purposes

           currdouble += mapping[mapIndex-1][0]; //assign new value to earlier held currdouble
                                                 //this is to prevent double assigning to the same
                                                 //String variable

           return counter += decoderecurse(todecode, length, index+2, currdouble); //recurse down after checking double number case for another double number (in "123", we would jump from "1" to "23")
       }
}
