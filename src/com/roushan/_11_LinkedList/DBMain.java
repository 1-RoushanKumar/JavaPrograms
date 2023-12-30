package com.roushan._11_LinkedList;

public class DBMain {
    public static void main(String[] args) {
        DB link = new DB();
        link.insertFirst(45);
        link.insertFirst(85);
        link.insertFirst(12);
        link.insertFirst(96);
        link.insertFirst(50);

        link.display();
        link.insertLast(979);
        System.out.println();
        link.display();

        link.insert(3, 99);
        System.out.println();
        link.display();
    }
}
