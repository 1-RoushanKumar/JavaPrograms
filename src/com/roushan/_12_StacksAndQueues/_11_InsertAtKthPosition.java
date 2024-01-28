package com.roushan._12_StacksAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class _11_InsertAtKthPosition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(40);
        stack.push(50);
        System.out.println(stack);
        System.out.println("Enter index where you want to add new element and index must be smaller than size of the stack::");
        //index stating from zero.
        int k = sc.nextInt();
        System.out.println("Enter value::");
        int val = sc.nextInt();

        Stack<Integer> tempStack = new Stack<>();
        //now we only copy those element from stack to tempStack so, we can add new value in require index.
        while (stack.size() > k) {
            tempStack.push(stack.pop());
        }
        stack.push(val); //adding the new value.
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());  //printing element which is below the new element in sense of stack.
        }
        System.out.println(stack);
    }
}
