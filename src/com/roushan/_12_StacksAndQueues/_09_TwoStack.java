package com.roushan._12_StacksAndQueues;

import java.io.*;
import java.util.*;

//Implementing two stack.In this question we have one array we need to make two stack using this one array.
class TwoStacks {
    int cap;     //it is size of the array.
    int top1, top2;   //top1 will point to the first element and top2 will point towards the last element of array.
    int []arr;

    //this constructor will create an array of length n and initially top1 = -1 and top 2 = cap;
    TwoStacks(int n) {
        arr = new int[n];
        cap = n;
        top1 = -1;
        top2 = cap;
    }

    //push1 will create stack of some part of the array.
    void push1(int x) {
        if (top1 < top2 - 1) {
            top1++;
            arr[top1] = x;
        } else {
            System.out.println("Stack Overflow");
            System.exit(1);
        }
    }

    //push2 will create stack of some part of the array.
    void push2(int x) {
        if (top1 < top2 - 1) {
            top2--;
            arr[top2] = x;
        } else {
            System.out.println("Stack Overflow");
            System.exit(1);
        }
    }

    int pop1() {
        if (top1 >= 0) {
            int x = arr[top1];
            top1--;
            return x;
        } else {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return 0;
    }

    int pop2() {
        if (top2>=0) {
            int x = arr[top2];
            top2++;
            return x;
        } else {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return 0;
    }
}

class GFG {

    public static void main(String[] args) {

        TwoStacks ts = new TwoStacks(5);
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11);
        ts.push2(7);
        System.out.println("Popped element from stack1 is: " + ts.pop1());
        ts.push2(40);
        System.out.println("Popped element from stack2 is: " + ts.pop2());

    }
}
//one more approach of doing this is dividing array in two parts
//but this is not good because
//suppose we have an array [][][][][][] of length 6 we divide 3 for the first stack(push1) and other 3 for
//second stack(push2) but when we only need to push one element in push2 then 2 remaining space will get wasted
//jabki us khali space ko push1 use kar sakta tha agar push1 pas aur element hoga tab.
//so for space efficient approach we use above approach.

//One more question very important:
//Divide array in n number stacks.
//Https://www.codingninjas.com/studio/problems/n-stacks-in-an-array_1164271