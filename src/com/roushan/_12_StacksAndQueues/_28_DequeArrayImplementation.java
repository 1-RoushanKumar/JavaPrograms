package com.roushan._12_StacksAndQueues;

public class _28_DequeArrayImplementation {
    private int[] arr;
    private int size;
    private int cap;

    public _28_DequeArrayImplementation(int capacity) {
        this.cap = capacity;
        this.arr = new int[cap];
        this.size = 0;
    }

    boolean isFull() {
        if (size == cap) {
            System.out.println("Queue is Full!!");
            return true;
        } else {
            return false;
        }
    }

    boolean isEmpty() {
        if (size == 0) {
            System.out.println("Queue is Empty!!");
            return true;
        } else {
            return false;
        }
    }

    //in this approach, insertFront and delete from will take O(n) time complexity and remaining all will take O(1).
    void insertFront(int x) {
        if (isFull()) {
            return;
        }
        for (int i = size - 1; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }
        arr[0] = x;
        size++;
    }

    void insertRear(int x) {
        if (isFull()) {
            return;
        }
        arr[size] = x;
        size++;
    }

    void deleteFront() {
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    void deleteRear() {
        if (isEmpty()) {
            return;
        }
        size--;
    }

    int getRear() {
        if (isEmpty()) {
            return -1;
        } else {
            return arr[size - 1];
        }
    }

    int getFront() {
        if (isEmpty()) {
            return -1;
        } else {
            return arr[0];
        }
    }

    void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        _28_DequeArrayImplementation dequeue = new _28_DequeArrayImplementation(5);
        dequeue.insertFront(1);
        dequeue.insertFront(2);
        dequeue.insertFront(3);
        dequeue.insertFront(4);
        dequeue.display();
        System.out.println();
        dequeue.insertRear(0);
        dequeue.display();
        System.out.println();
        dequeue.insertFront(45);
        System.out.println(dequeue.size);
        System.out.println(dequeue.getFront());
        System.out.println(dequeue.getRear());
        dequeue.deleteFront();
        dequeue.display();
        System.out.println();
        dequeue.deleteRear();
        dequeue.display();
    }
}
