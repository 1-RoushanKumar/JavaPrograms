package com.roushan._12_StacksAndQueues;

public class _04_a_CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    //generally, all stacks and queue are like array from and inside.
    //if size is not given, then it makes the default size of an array internally.
    public _04_a_CustomStack() {
        this.data = new int[DEFAULT_SIZE];
    }

    //if size of the array(stack) is given by the user then this constructor will run.
    public _04_a_CustomStack(int size) {
        this.data = new int[size];
    }

    //we take a pointer which is initially -1(ie stack is empty) , and it will increase if new value is added ,
    //and it will decrease if value is removed.
    int ptr = -1;

    public boolean push(int item) {
        if (isFull()) {
            System.out.println("STACK IS FULL!!");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    public boolean isFull() {
        return ptr == data.length - 1;
    }

    public int pop() throws _04_b_StackException {
        if (isEmpty()) {
            throw new _04_b_StackException("Cannot pop from an empty stack!!");
        }
        int removed = data[ptr];
        ptr--;
        return removed;
    }

    public boolean isEmpty() {
        return ptr == -1;
    }

    public int peek() throws _04_b_StackException {
        if (isEmpty()) {
            throw new _04_b_StackException("Cannot peek from an empty stack!!");
        }
        return data[ptr];
    }
}
