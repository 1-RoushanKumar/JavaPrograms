package com.roushan._16_Hashing;

public class _02_ImplementationOfOpenAddressing {
    public static void main(String[] args) {
        MyHash2 table = new MyHash2(10); // Create a hash table with capacity 10
        table.insert(10);
        table.insert(22);
        table.insert(37);
        table.insert(29);
        table.insert(31);
        table.insert(42);

        System.out.println("Printing hash table:");
        table.printHashTable();

        System.out.println("Searching for key 22: " + table.search(22));
        System.out.println("Searching for key 15: " + table.search(15));

        System.out.println("Deleting key 22...");
        table.erase(22);

        System.out.println("Searching for key 22: " + table.search(22));

        System.out.println("Printing hash table after deletion:");
        table.printHashTable();
    }
}

class MyHash2 {
    int[] arr;
    int cap, size;

    public MyHash2(int cap) {
        this.cap = cap;  //cap is table size
        size = 0;
        arr = new int[cap]; // Initialize the array
        for (int i = 0; i < cap; i++) {
            arr[i] = -1;    //-1 means slot is empty.
        }
    }

    int hash(int key) {
        return key % cap;
    }

    boolean search(int key) {
        int h = hash(key);
        int i = h;
        while (arr[i] != -1) {
            if (arr[i] == key) {
                return true;
            }
            i = (i + 1) % cap;
            if (i == h) {
                return false;
            }
        }
        return false;
    }

    boolean insert(int key) {
        if (size == cap) {
            return false;
        }
        int i = hash(key);
        while (arr[i] != -1 && arr[i] != -2 && arr[i] != key) {
            i = (i + 1) % cap;
        }
        if (arr[i] == key) {
            return false;
        } else {
            arr[i] = key;
            size++;
            return true;
        }
    }

    boolean erase(int key) {
        int h = hash(key);
        int i = h;
        while (arr[i] != -1) {
            if (arr[i] == key) {
                arr[i] = -2;  //-2 indicate or mark that we delete that slot key.
                return true;
            }
            i = (i + 1) % cap;
            if (i == h) {
                return false;
            }
        }
        return false;
    }

    void printHashTable() {
        for (int i = 0; i < cap; i++) {
            System.out.println("Index " + i + ": " + arr[i]);
        }
    }
}
//it is a simple implementation of hash using linear probing.
//in this case we assume -1 and -2 can not be key due to this reason we
//used -2 as marking of delete and -1 which represent empty slot.
//but what when input key is -2 and -1.
//The fact is in the library we do not use actual key to store in slot, we
//use their pointer and reference of the key. But how do we handle deletion
//the library implementation create a dummy nodes,inside their class when we delete
//something we store there reference or pointer in that dummy node. Every time when we check for deleted we
//check this dummy node.
