package com.roushan._12_StacksAndQueues;

import java.util.ArrayList;

//its taking O(1) complexity.
public class _05_c_DynamicStackUsingArrayList {
    ArrayList<Integer> data = new ArrayList<>();

    public void push(int x) {
        data.add(x);
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty!!");
        } else {
            int res = data.getLast();
            data.removeLast();
            return res;
        }
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty!!");
        } else {
            return data.getLast();
        }
    }

    public int size() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty!!");
        }
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
