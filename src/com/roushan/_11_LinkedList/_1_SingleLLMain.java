package com.roushan._11_LinkedList;

public class _1_SingleLLMain {
    public static void main(String[] args) {
        _1_Single_LL link = new _1_Single_LL();
//        link.insertFirst(3);
//        link.insertFirst(24);
//        link.insertFirst(2);
//        link.insertFirst(6);
//        link.display();
//        System.out.println();
//
//        link.insertLast(99);
//        link.display();
//        link.insertLast(990);
//        System.out.println();
//        link.display();
////
//        link.insert(100, 3);
//        System.out.println();
//        link.display();
////
//        link.deleteFirst();
//        System.out.println();
//        link.display();
////
//        link.deleteLast();
//        System.out.println();
//        link.display();
//
//        System.out.println();
//        link.displayRec(link.head);
//
//        link.delete(2);
//        System.out.println();
//        link.display();
//        System.out.println();
//        System.out.println("Position of 3 is::" + link.find(3));
//        System.out.println("Position of 99 is::"+link.findRec(link.head, 99,0));

        //inserting in sorted list.
        link.insertFirst(40);
        link.insertFirst(30);
        link.insertFirst(20);
        link.insertFirst(10);
        link.display();
        link.insertInSortedList(36);
        System.out.println();
        link.display();
        System.out.println();
        link.middleElement();
//        System.out.println();
        link.returnNthNodeFromEnd(2); //where it here value of n start form 1;
//        link.reverseList();
//        link.display();
        link.insertFirst(10);
        link.insertLast(40);
        link.insert(20, 3);
        link.display();
        link.removeDuplicate();
        System.out.println();
        link.display();

        link.insertRecur(56, 2);
        System.out.println();
        link.display();
        link.sort();
        System.out.println();
        link.display();
    }
}
