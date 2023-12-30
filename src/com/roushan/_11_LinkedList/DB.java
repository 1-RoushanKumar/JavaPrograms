package com.roushan._11_LinkedList;

//we are doing it without using tail pointer(but you can also do it with tail pointer)
public class DB {
    private class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node head;
    private Node prev;
    private int size;

    public DB() {
        this.size = 0;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        size++;
    }

    public void insertLast(int val) {
        Node node = new Node(val);
        if (head == null) {
//            insertFirst(val);    //or
            node.prev = null;
            head = node;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        node.next = null;
        last.next = node;
        node.prev = last;
        size++;
    }

    public void insert(int index, int val) {
        Node node = new Node(val);
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        node.prev = temp;
        if (node.next != null) {
            node.next.prev = node;
        }
        size++;
    }

    public void display() {
        Node node = head;
        Node last = null;    //this is only used in reversing order.
        while (node != null) {
            System.out.print(node.val + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println("End");

        System.out.println("Printing in Reverse::");
        while (last != null) {
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.println("Start");
    }
}
