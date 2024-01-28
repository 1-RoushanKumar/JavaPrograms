package com.roushan._12_StacksAndQueues;

import java.util.Stack;

//https://www.geeksforgeeks.org/convert-infix-expression-to-postfix-expression/
//https://youtu.be/m7SGekhd1mQ

public class _21_InfixToPostFix {

    // this function will return precedence of operators for storing into the stack.
    static int prec(char c) {
        if (c == '^')
            return 3;   //3 means the highest precedence.
        else if (c == '/' || c == '*')
            return 2;   //2nd highest.
        else if (c == '+' || c == '-')
            return 1;   //last precedence.
        else
            return -1;
    }

    // Function to return associativity of operators
    static char associativity(char c) {
        if (c == '^')
            return 'R';
        return 'L'; // Default to left-associative
    }

    // function for converting infix expression to postfix expression
    static void infixToPostfix(String s) {
        //I take a stringBuilder because we know string does not create a new object for each operation.
        StringBuilder result = new StringBuilder();
        //this stack will be used to store operator.
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the character is an operand, add it to the output string.
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                result.append(c); //then we append it to the stringBuilder result.
            }
            // If the scanned character is an ‘(', push it to the stack.
            else if (c == '(') {
                stack.push(c);
            }
            // If the scanned character is an ‘)’, pop and add to the output string from the stack
            // until an ‘(' is encountered.
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                //it will pop until an ‘(' is encountered.
                stack.pop();  // when ‘(' encountered, then we will remove it, leaving the remaining element as it is
                //which is below ‘('.
            }
            // If an operator is scanned
            else {
                while (!stack.isEmpty() && (prec(s.charAt(i)) < prec(stack.peek()) ||
                        prec(s.charAt(i)) == prec(stack.peek()) &&
                                associativity(s.charAt(i)) == 'L')) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // This is pop all the remaining element from the stack and append it to the result.
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        //printing the result.
        System.out.println(result);
    }

    // Main code.
    public static void main(String[] args) {
        String exp = "a+b*(c-d)";   //infix string.
        // Function call
        infixToPostfix(exp);
    }
}
