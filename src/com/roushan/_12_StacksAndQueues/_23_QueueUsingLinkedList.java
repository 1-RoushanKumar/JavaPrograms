package com.roushan._12_StacksAndQueues;

public class _23_QueueUsingLinkedList {
    Nodee head = null;
    Nodee temp;
    int size = 0;

    void add(int val) {
        Nodee new_Node = new Nodee(val);
        if (head == null) {
            head = new_Node;
            head.next = null;
            temp = head;
            size++;
            return;
        }
            temp.next = new_Node;
            temp = new_Node;
            temp.next = null;
            size++;
    }

    boolean isEmpty() {
        return head == null;
    }

    void remove() {
        if (isEmpty()) {
            System.out.println("Queue is empty!!");
        } else {
            head = head.next;
            size--;
        }
    }

    int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty!!");
            return -1;
        } else {
            return head.data;
        }
    }

    int sizee() {
        return size;
    }

    void display() {
        if (head == null) {
            return;
        }
        Nodee temp1= head;
        while (temp1 != null) {
            System.out.print(temp1.data + "->");
            temp1 = temp1.next;
        }
    }

    public static void main(String[] args) {
        _23_QueueUsingLinkedList queue = new _23_QueueUsingLinkedList();
        queue.add(10);
        queue.add(5);
        queue.add(2);
        System.out.println(queue.front());
        queue.display();
        queue.remove();
        System.out.println();
        queue.display();
    }
}

class Nodee {
    public Nodee next;
    public int data;

    public Nodee(int data) {
        this.data = data;
    }

    public Nodee(Nodee next, int data) {
        this.next = next;
        this.data = data;
    }
}
