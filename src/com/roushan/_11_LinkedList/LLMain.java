package com.roushan._11_LinkedList;

public class LLMain {
    public static void main(String[] args) {
        LL link = new LL();
        link.insertFirst(3);
        link.insertFirst(24);
        link.insertFirst(2);
        link.insertFirst(6);
        link.display();

        System.out.println();

        link.insertLast(99);
        link.display();
        link.insertLast(990);
        System.out.println();
        link.display();
//
        link.insert(100, 3);
        System.out.println();
        link.display();
//
        link.deleteFirst();
        System.out.println();
        link.display();
//
        link.deleteLast();
        System.out.println();
        link.display();
//
//        link.delete(2);
//        System.out.println();
//        link.display();

//        System.out.println(link.find(24));
    }
}
