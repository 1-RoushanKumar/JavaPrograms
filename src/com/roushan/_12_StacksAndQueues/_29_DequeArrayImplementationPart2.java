package com.roushan._12_StacksAndQueues;

//using circular array approach.
//this approach is an efficient way to implement dequeue using an array.
//here all operation will take O(1) time complexity.
public class _29_DequeArrayImplementationPart2 {
    int[] arr;
    int front;
    int cap;
    int size;

    public _29_DequeArrayImplementationPart2(int capacity) {
        this.arr = new int[capacity];
        this.front = 0;
        this.cap = capacity;
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

    void insertFront(int x) {
        if (isFull()) {
            return;
        }
        front = (front + cap - 1) % cap;
        arr[front] = x;
        size++;
    }

    void insertRear(int x) {
        if (isFull()) {
            return;
        }
        int new_rear = (front + size) % cap;
        arr[new_rear] = x;
        size++;
    }

    void deleteFront() {
        if (isEmpty()) {
            return;
        }
        front = (front + 1) % cap;
        size--;
    }

    void deleteRear() {
        if (isEmpty()) {
            return;
        }
        size--;
    }

    int getFront() {
        if (isEmpty()) {
            return -1;
        } else {
            return arr[front];
        }
    }

    int getRear() {
        if (isEmpty()) {
            return -1;
        } else {
            return arr[(front + size - 1) % cap];
        }
    }

    public static void main(String[] args) {
        _29_DequeArrayImplementationPart2 dequeue = new _29_DequeArrayImplementationPart2(6);
        dequeue.insertFront(10);
        dequeue.insertRear(60);
        System.out.println(dequeue.getFront());
        System.out.println(dequeue.getRear());
        dequeue.insertFront(20);
        dequeue.insertFront(30);
        dequeue.insertFront(40);
        dequeue.insertRear(50);
        dequeue.insertRear(70);  //this will show the queue is full.
        System.out.println(dequeue.getFront());
        dequeue.deleteFront();
        System.out.println(dequeue.getFront());

    }
}
