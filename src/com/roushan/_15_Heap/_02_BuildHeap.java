package com.roushan._15_Heap;

public class _02_BuildHeap {

    // Method to heapify a subtree with root at given index
    // n is a size of heap
    public static void minHeapify(int[] arr, int n, int i) {
        int smallest = i;  // Initialize smallest as root
        int left = 2 * i + 1;  // left = 2*i + 1
        int right = 2 * i + 2;  // right = 2*i + 2

        // If left child is smaller than root
        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }

        // If the right child is smaller than smallest so far
        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }

        // If smallest is not root
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            // Recursively heapify the affected sub-tree
            minHeapify(arr, n, smallest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        int n = arr.length;
        // Build the heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            minHeapify(arr, n, i);
        }
        // Print the heapified array
        System.out.println("Heapified array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

