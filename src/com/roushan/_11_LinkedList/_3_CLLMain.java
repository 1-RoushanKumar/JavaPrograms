package com.roushan._11_LinkedList;

public class _3_CLLMain {
    public static void main(String[] args) {

        _3_CircularLL link = new _3_CircularLL();
        link.insertFirst(45);
        link.insertFirst(5);
        link.insertFirst(4);
        link.display();
        link.insertLast(90);
        link.display();
        //in this case we assume index <= node size.
        link.insert(5, 99);
        link.display();
        link.insert(5, 100);
        link.display();
        link.deleteHead();
        link.display();
        link.deleteIndex(2);
        link.display();
        link.delete(101);
        link.display();
    }
}
