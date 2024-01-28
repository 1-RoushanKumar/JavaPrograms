package com.roushan._12_StacksAndQueues;

//this will take only O(1) time complexity.
public class _30_DequeDoublyLinkedListImplementation {
    ListNode head;
    ListNode tail;
    int size;

    public _30_DequeDoublyLinkedListImplementation() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    boolean isEmpty() {
        if (head == null || tail == null) {
            System.out.println("Queue is empty!!");
            return true;
        } else {
            return false;
        }
    }

    void insertFront(int val) {
        ListNode new_node = new ListNode(val);
        if (head == null) {
            new_node.next = null;
            new_node.prev = null;
            head = new_node;
            tail = new_node;
            size++;
            return;
        }
        new_node.next = head;
        head.prev = new_node;
        new_node.prev = null;
        head = new_node;
        size++;
    }

    void insertRear(int val) {
        ListNode new_node = new ListNode(val);
        if (head == null) {
            new_node.next = null;
            new_node.prev = null;
            head = new_node;
            tail = new_node;
            size++;
            return;
        }
        tail.next = new_node;
        new_node.next = null;
        new_node.prev = tail;
        tail = new_node;
        size++;
    }

    int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return head.data;
    }

    int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return tail.data;
    }

    void deleteFront() {
        if (isEmpty()) {
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }

    void deleteRear() {
        if (isEmpty()) {
            return;
        }
        if (tail.prev == null) {
            tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    int getSize() {
        return size;
    }

    //this optional
    void display() {
        if (isEmpty()) {
            return;
        }
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        _30_DequeDoublyLinkedListImplementation deque = new _30_DequeDoublyLinkedListImplementation();
        deque.insertFront(45);
        deque.insertFront(56);
        System.out.println(deque.getFront());
        System.out.println(deque.getRear());
        System.out.println(deque.getSize());
        deque.insertRear(99);
        deque.insertFront(12);
        deque.display();
        System.out.println("\n" + deque.getFront());
        System.out.println(deque.getRear());
        deque.deleteFront();
        deque.deleteRear();
        deque.display();
//        System.out.println();
////        deque.deleteRear();
//        deque.display();
        System.out.println();
//        deque.deleteRear();
        deque.deleteFront();
        deque.display();
        deque.deleteFront();
        deque.display();
        deque.deleteFront();

    }
}

class ListNode {
    public ListNode next;
    public ListNode prev;
    public int data;

    public ListNode(int data) {
        this.data = data;
    }

    public ListNode(ListNode next, ListNode prev, int data) {
        this.next = next;
        this.prev = prev;
        this.data = data;
    }
}
