package com.roushan._12_StacksAndQueues;

public class _05_b_DynamicStackMain {
    public static void main(String[] args) throws Exception {
//        _05_a_DynamicStack stack = new _05_a_DynamicStack(5);
//        _05_c_DynamicStackUsingArrayList stack = new _05_c_DynamicStackUsingArrayList();
        _05_d_DynamicStackUsingLinkedList stack = new _05_d_DynamicStackUsingLinkedList();
        stack.push(5);
        stack.push(15);
        stack.push(25);
        stack.push(35);
        stack.push(45);

        System.out.println("Size is::" + stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("Peek Element is::" + stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
