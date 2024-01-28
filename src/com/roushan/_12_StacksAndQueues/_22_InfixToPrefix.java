package com.roushan._12_StacksAndQueues;

import java.util.Stack;

//https://www.geeksforgeeks.org/convert-infix-prefix-notation/
//Overall, time complexity of this code is O(n).
public class _22_InfixToPrefix {

    // Function to return precedence of operators for storing into the stack.
    static int prec(char c) {
        if (c == '^')
            return 3;   // 3 means the highest precedence.
        else if (c == '/' || c == '*')
            return 2;   // 2nd highest.
        else if (c == '+' || c == '-')
            return 1;   // Last precedence.
        else
            return -1;
    }

    // Function to return associativity of operators
    static char associativity(char c) {
        if (c == '^')
            return 'R';
        return 'L'; // Default to left-associative
    }

    // Function for converting infix expression to prefix expression
    // we reverse the given string.Then we use almost similar operation like infix to postfix.
    //when answer is received then we finally reverse the answer to the require result.
    static void infixToPrefix(String s) {
        StringBuilder temp = new StringBuilder(s);
        temp = temp.reverse();
        //adjusting reversed parenthesis.
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == ')') {
                temp.setCharAt(i, '(');
            } else if (temp.charAt(i) == '(') {
                temp.setCharAt(i, ')');
            }
        }
        // I take a StringBuilder because we know a string does not create a new object for each operation.
        StringBuilder result = new StringBuilder();
        // This stack will be used to store operators.
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < temp.length(); i++) {
            char c = temp.charAt(i);

            // If the character is an operand, add it to the output string.
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                result.append(c); // Append it to the StringBuilder result.
            }
            // If the scanned character is an ‘(', push it to the stack.
            else if (c == '(') {
                stack.push(c);
            }
            // If the scanned character is an ‘)', pop and add to the output string from the stack
            // until an ‘(' is encountered.
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                // Pop until an ‘(' is encountered.
                stack.pop();  // When ‘(' is encountered, remove it, leaving the remaining element as it is below ‘('.
            }
            // If an operator is scanned
            else {
                while (!stack.isEmpty() && (prec(c) < prec(stack.peek()) ||
                        prec(c) == prec(stack.peek()) && associativity(c) == 'L')) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop all the remaining elements from the stack and append them to the result.
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        // Printing the result.
        System.out.println(result.reverse());
    }

    // Main code.
    public static void main(String[] args) {
        String exp = "(A+B)+C-(D-E)^F";   // Infix string.
        // Function call
        infixToPrefix(exp);
    }
}
