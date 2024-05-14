package com.roushan._16_Hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class _01_ImplementationOfChaining {
    public static void main(String[] args) {
        MyHash table = new MyHash(7);
        table.insert(70);
        table.insert(71);
        table.insert(9);
        table.insert(56);
        table.insert(72);
        table.printHashTable();
        boolean flag = table.search(56);
        System.out.println(flag);
        table.remove(56);
        table.printHashTable();
        flag = table.search(56);
        System.out.println(flag);
    }
}
class MyHash {
    int Bucket;
    ArrayList<LinkedList<Integer>> table;
    public MyHash(int bucket) {
        Bucket = bucket;
        table = new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < bucket; i++) {
            table.add(new LinkedList<Integer>());
        }
    }
    void insert(int key) {
        int i = key % Bucket;
        table.get(i).add(key);
    }
    void remove(int key) {
        int i = key % Bucket;
        table.get(i).remove((Integer) key); // Here, you're removing the index instead of the key
    }
    boolean search(int key) {
        int i = key % Bucket;
        return table.get(i).contains(key);
    }
    void printHashTable() {
        for (int i = 0; i < Bucket; i++) {
            System.out.print("Bucket " + i + ": ");
            for (Integer key : table.get(i)) {
                System.out.print(key + " -> ");
            }
            System.out.println("null");
        }
    }
}