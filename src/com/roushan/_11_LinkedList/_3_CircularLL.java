package com.roushan._11_LinkedList;

public class _3_CircularLL {
    private class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }

    }

    private Node head;

    //Naive-This approach will take O(n) time complexity.
//    public void insertFirst(int val) {
//        Node node = new Node(val);
//        if (head == null) {
//            head = node;
//            head.next = node;
//            return;
//        }
//        Node temp = head;
//        while (temp.next != head) {
//            temp = temp.next;
//        }
//        node.next = temp.next;
//        temp.next = node;
//        head = node;
//    }

    //Efficient-InsertFirst with only O(1) time complexity.
    //Suppose given 4->5->6->7 ,and we need to insert 3 at the beginning
    //What we do - we insert this value after head for this we don't need any loop.
    //then it become 4->3->5->6->7 after that we swap only the value of the nodes not node
    //i.e. swapping the head value with new node value and head node (but head node will not change )
    //then we get 3->4->5->6->7.
    public void insertFirst(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            head.next = node;
            return;
        }
        node.next = head.next;
        head.next = node;
        int temp = head.val;
        head.val = head.next.val;
        head.next.val = temp;
    }

    //same as above only make head = head.next because value is added to last.
    public void insertLast(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            head.next = node;
            return;
        }
        node.next = head.next;
        head.next = node;
        int temp = head.val;
        head.val = head.next.val;
        head.next.val = temp;
        head = head.next;
    }

    public void insert(int index, int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            head.next = node;
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
        temp.next = node;
    }

    //it will take O(n) time complexity.
//    public void deleteHead() {
//        if (head == null || head.next == head) {
//            head = null;
//            return;
//        }
//        Node temp = head;
//        while (temp.next != head) {
//            temp = temp.next;
//        }
//        temp.next = temp.next.next;
//        head = temp.next;
//    }

    //efficient way to deleteHead in O(1) time complexity.
    //suppose given list 10->20->30->40 first we make head value as same as is head next value
    //then it become 20->20->30->40 now we delete tha head.next value by moving one step ahead
    //(ie head.next=head.next.next) then it become 20->30->40.
    public void deleteHead() {
        if (head == null || head.next == head) {
            head = null;
            return;
        }
        head.val = head.next.val;
        head.next = head.next.next;
    }

    public void deleteIndex(int index) {
        if (head == null || head.next == head) {
            head = null;
            return;
        }
        if (index == 0) {
            head.val = head.next.val;
            head.next = head.next.next;
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public void delete(int val) {
        if (head == null || head.next == null) {
            return;
        }
        Node temp = head;
        if (temp.val == val) {
            head.val = head.next.val;
            head.next = head.next.next;
            return;
        }
        while (temp.next != head) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Require value is not present!");
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

        System.out.println("END");
    }
}
