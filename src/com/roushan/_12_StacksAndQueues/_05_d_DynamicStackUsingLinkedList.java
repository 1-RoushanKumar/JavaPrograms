package com.roushan._12_StacksAndQueues;

//it also taking O(1) time complexity.
public class _05_d_DynamicStackUsingLinkedList {
    Node head = null;
    int size = 0;

    public void push(int x) {
        Node temp = new Node(x);
        temp.next = head;
        head = temp;
        size++;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty!!");
        } else {
            int res = head.val;
            head = head.next;
            size--;
            return res;
        }
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty!!");
        } else {
            return head.val;
        }
    }

    int size() {
        return size;
    }

    public boolean isEmpty() {
        return (head == null);
    }
}

class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
