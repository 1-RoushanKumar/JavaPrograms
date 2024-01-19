package com.roushan._12_StacksAndQueues;

public class _04_c_CustomStackMain {
    public static void main(String[] args) throws Exception {
        _04_a_CustomStack stack = new _04_a_CustomStack(5);

        stack.push(5);
        stack.push(15);
        stack.push(25);
        stack.push(35);
        stack.push(45);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.pop()); //it will show exception we added 5 value only after popping 5 elements 
                                         //stack is now empty to there are nothing to remove.
    }
}
