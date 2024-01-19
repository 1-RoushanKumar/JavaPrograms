package com.roushan._12_StacksAndQueues;

import java.util.Stack;

public class _01_InbuiltStackExample {
    public static void main(String[] args) {
        Stack<Integer> stt = new Stack<>();
        stt.push(15);
        stt.push(16);
        stt.push(17);
        stt.push(18);
        stt.push(19);
        stt.push(20);

        //value which pushed last will come first ie(last in first out(lifo)).
        System.out.println(stt.pop());
        System.out.println(stt.pop());
        System.out.println(stt.pop());
        System.out.println(stt.pop());
        System.out.println(stt.pop());
        System.out.println(stt.pop());
//        System.out.println(stt.pop());   //it will show empty stack exception.


    }
}
