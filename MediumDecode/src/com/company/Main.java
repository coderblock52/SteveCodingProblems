package com.company;
import Code.Code;

/*
Challenge Description:
Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.
 */
public class Main {

    public static void main(String[] args) {
        Code mycode = new Code();
        String todecode = "111234";

        int counter = mycode.decode(todecode);
        System.out.println("number of solutions is: " + counter);
    }
}
