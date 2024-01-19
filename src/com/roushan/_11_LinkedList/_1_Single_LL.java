package com.roushan._11_LinkedList;

import java.util.ArrayList;
import java.util.Collections;

public class _1_Single_LL {
    //We created a Node which contain two parameters value and the address of the next node.
    private class Node {
        private int value;
        private Node next;

        //created two construction two access these values.
        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public Node head;
    private Node tail;
    private int size;

    public _1_Single_LL() {
        this.size = 0;
    }

    //1.Inserting first node.
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    //2.Inserting last node.
    //when tail is know, then use it.
    //    public void insertLast(int val) {
//        if (tail == null) {
//            insertFirst(val);
//            return;
//        }
//        Node node = new Node(val);
//        tail.next = node;
//        tail = node;
//        node.next = null;
//        size++;
//    }

    //when tail is not given then use this.
    //This will help to find the tail.
    public Node get() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    //This will help to insertLast val.
    public void insertLast(int val) {
        if (head == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail = get();
        tail.next = node;
        tail = node;
        node.next = null;
        size++;
    }

    //3.Inserting at any index.
    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val);
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    //4.Deleting first element.
    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    //5.Deleting Last element.
    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }

        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    //6.Deleting element from any index.
    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }
        Node prev = get(index - 1);
        int val = prev.next.value;

        prev.next = prev.next.next;
        size--;
        return val;
    }

    //7. Searching element with iterative way.
    public int find(int value) {
        Node node = head;
        int pos = 0;
        while (node != null) {
            if (node.value == value) {
                return pos;
            }
            node = node.next;
            pos = pos + 1;
        }
        return -1;
    }

    //8.Searching with recursion.
    public int findRec(Node head, int value, int pos) {
        if (head == null) {
            return -1;
        }
        if (head.value == value) {
            return pos;
        }
        return findRec(head.next, value, pos + 1);
    }

    //9. Insertion in sorted list.
    public void insertInSortedList(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            head.next = null;
            return;
        }
        Node temp = head;
        if (temp.value > node.value) {
            node.next = temp;
            head = node;
            return;
        }
        while (temp.next != null) {
            if (temp.next.value > node.value) {
                node.next = temp.next;
                temp.next = node;
                return;
            }
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
    }

    //10. finding middle element.
    //Naive approach .
//    public void middleElement() {
//        if (head == null) {
//            return;
//        }
//        int count = 0;
//        Node temp = head;
//        for (; temp != null; temp = temp.next) {
//            count++;
//        }
//        temp = head;
//        for (int i = 0; i < count / 2; i++) {
//            temp = temp.next;
//        }
//        System.out.print("Middle Element is::"+temp.value);
//    }

    //Efficient approach By using two pointer slow and fast pointer
    //where slow move one node at time and fast move two node at time initially both start from head.
    public void middleElement() {
        if (head == null) {
            return;
        }
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.value);
    }

    //11.Returning nth node from the end of the list
    // first method.
//    public void returnNthNodeFromEnd(int n) {
//        if (head == null) {
//            return;
//        }
//        Node temp = head;
//        int count = 0;
//        while (temp != null) {
//            count++;
//            temp = temp.next;
//        }
//        if (n > count){
//            System.out.println("NULL");
//            return;
//        }
//        temp = head;
//        int index = count - n;
//        for (int i = 0; i < index; i++) {
//            temp = temp.next;
//        }
//        System.out.println(temp.value);
//    }

    //second method.
    //here we uses a two pointer method
    //we take first and second pointer we moved first pointer to n space ahead
    //then we take second pointer is equal to head until first is not equal to null
    //keep moving both pointer one step at a time
    //ex 10-20-30-40-null   take n = 2; hence n = 2 move first two step ahead then take second as head
    //---sec   fir          at the end it look like this.
    //---      sec   fir    now return second value .
    public void returnNthNodeFromEnd(int n) {
        if (head == null) {
            return;
        }
        Node first = head;
        for (int i = 0; i < n; i++) {
            if (first == null) {
                return;
            }
            first = first.next;
        }
        Node second = head;
        while (first != null) {
            second = second.next;
            first = first.next;
        }
        System.out.println(second.value);
    }

    //12.Reversing List
    // Naive Solution which take O(n) time and space complexity.
    //taken an arraylist adding all the value in it then start taking
    //from the last index of the arraylist and assigning into the temp
//    public void reverseList(){
//        ArrayList<Integer> arr = new ArrayList<>();
//        for(Node temp = head;temp != null; temp = temp.next){
//            arr.add(temp.value);
//        }
//        for(Node temp = head;temp != null; temp = temp.next){
//            temp.value = arr.remove(arr.size() - 1);
//        }
//    }

    //Efficient way In 35th lecture of gfg linkList.
    public void reverseList() {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    //Reverse list using recursion .This code will not working here but code is right.
//    public void reverseListRec(Node node) {
//        if (node == tail) {
//            head = tail;
//            return;
//        }
//        reverseListRec(node.next);
//        tail.next = node;
//        tail = node;
//        tail.next = null;
//    }

    //13.Removing duplicate elements.
    public void removeDuplicate() {
        if (head == null) {
            return;
        }
        Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.value == temp.next.value) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
    }

    //14.Inserting Using Recursion.
    public void insertRecur(int val, int index) {
        head = insertRec(index, val, head);
    }

    private Node insertRec(int index, int val, Node node) {
        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }
        node.next = insertRec(index - 1, val, node.next);
        return node;
    }

    //15.Sorting LinkList.
    //1st way naive approach. It will take extra O(n) of space.
    public void sort() {
        Node newHead = head;
        Node head = sorting(newHead);
    }

    public Node sorting(Node head) {
        Node temp = head;
        ArrayList<Integer> list = new ArrayList<>();
        while (temp != null) {
            list.add(temp.value);
            temp = temp.next;
        }
        Collections.sort(list);
        temp = head;
        int i = 0;
        while (temp != null) {
            temp.value = list.get(i);
            i++;
            temp = temp.next;
        }
        return head;
    }


    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("END");
    }

    //displaying value with Recursion.
    public void displayRec(Node head) {
        if (head == null) {
            return;
        } else {
            System.out.print(head.value + " -> ");
            displayRec(head.next);
        }
    }
}
//java provide inbuilt linkedList also.
