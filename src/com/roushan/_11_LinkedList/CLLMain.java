package com.roushan._11_LinkedList;

public class CLLMain {
    public static void main(String[] args) {

        CircularLL link = new CircularLL();
        link.insert(45);
        link.insert(5);
        link.insert(4);
        link.display();

        link.delete(5);
        System.out.println();
        link.display();
    }
}
