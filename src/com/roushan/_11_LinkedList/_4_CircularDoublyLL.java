package com.roushan._11_LinkedList;

//GFG LinkList 31th lecture.
public class _4_CircularDoublyLL {
    private class Node {
        private int val;
        private Node next;
        private Node prev;

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

    public void insertFirst(int val) {
        Node node = new Node(val);
        if (head == null) {
            node.next = node;
            node.prev = node;
            head = node;
            return;
        }
        node.prev = head.prev;
        node.next = head;
        head.prev.next = node;
        head.prev = node;
        head = node;
    }

    public void insertLast(int val) {
        Node node = new Node(val);
        if (head == null) {
            node.next = node;
            node.prev = node;
            head = node;
            return;
        }
        head.prev.next = node;
        node.prev = head.prev;
        node.next = head;
        head.prev = node;
    }

    public void insert(int index, int val) {
        Node node = new Node(val);
        if (head == null) {
            node.next = node;
            node.prev = node;
            head = node;
            return;
        }
        if (index == 0) {
            insertFirst(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next.prev = node;
        temp.next = node;
        node.prev = temp;
    }

    public void display() {
        if (head == null) {
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        _4_CircularDoublyLL link = new _4_CircularDoublyLL();
        link.insertFirst(45);
        link.insertFirst(44);
        link.insertFirst(43);
        link.insertFirst(42);
        link.insertFirst(41);
        link.display();
        link.insertLast(99);
        link.display();
        link.insert(6,100);
        link.display();
    }
}

