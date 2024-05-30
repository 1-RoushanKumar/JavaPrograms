package com.roushan._15_Heap;

//Time complexity is O(log(n)).
public class _01_HeapInsertAndDelete {
    //MinHeap is a class that contains all the property of min head
    public static class MinHeap {
        int[] arr;
        int size;
        int capacity;

        MinHeap(int c) {
            size = 0;
            capacity = c;
            arr = new int[c];
        }

        int left(int i) {
            return (2 * i + 1);
        }

        int right(int i) {
            return (2 * i + 2);
        }

        int parent(int i) {
            return (i - 1) / 2;
        }

        public void insert(int x) {
            if (size == capacity) return;
            size++;
            arr[size - 1] = x;

            for (int i = size - 1; i != 0 && arr[parent(i)] > arr[i]; ) {
                int temp = arr[i];
                arr[i] = arr[parent(i)];
                arr[parent(i)] = temp;
                i = parent(i);
            }
        }

        public void delete() {
            arr[0] = arr[size - 1];
            size--;
            int index = 0;
            int smallest = index;
            while (index < size) {
                if (left(index) < size && arr[left(index)] < arr[smallest]) {
                    smallest = left(index);
                }
                if (right(index) < size && arr[right(index)] < arr[smallest]) {
                    smallest = right(index);
                }
                if (smallest == index) {
                    return;
                } else {
                    int temp = arr[index];
                    arr[index] = arr[smallest];
                    arr[smallest] = temp;
                    index = smallest;
                }
            }
        }
    }

    public static void main(String[] args) {
        MinHeap h = new MinHeap(11);
        h.insert(10);
        h.insert(40);
        h.insert(15);
        h.insert(20);
        h.insert(50);

        for (int i = 0; i < h.size; i++) {
            System.out.print(h.arr[i] + " ");
        }
        System.out.println();
        h.delete();
        for (int i = 0; i < h.size; i++) {
            System.out.print(h.arr[i] + " ");
        }
    }
}