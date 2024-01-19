package com.roushan._11_LinkedList;

public class _2_DBMain {
    public static void main(String[] args) {
        _2_DoublyLL link = new _2_DoublyLL();
        link.insertFirst(39);
        link.insertFirst(32);
        link.insertFirst(30);
        link.insertFirst(38);

        link.display();

        link.insertLast(56);
        System.out.println();
        link.display();

        link.insert(2, 31);
        System.out.println();
        link.display();
        System.out.println();
        link.reverse();
    }
}
