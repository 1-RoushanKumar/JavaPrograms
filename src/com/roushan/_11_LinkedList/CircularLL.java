package com.roushan._11_LinkedList;

public class CircularLL {
    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

    }

    private Node head;
    private Node tail;

    public void insert(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void delete(int val) {
        Node node = head;
        if (node == null) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        do {
            Node n = node.next;
            if (n.val == val) {
                node.next = n.next;
                break;
            }
            node = node.next;
        } while (node != head);
    }

    public void display() {
        Node node = head;
        if (head != null) {
            do {
                System.out.print(node.val + " -> ");
                if (node.next != null) {
                    node = node.next;
                }
            } while (node != head);
            System.out.println("HEAD");
        }
    }
}
