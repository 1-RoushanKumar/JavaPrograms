package com.roushan._15_Heap;

import java.util.Arrays;

//here we have given a min heap and the index of some element, and we need to replace the element with a required element.
public class _03_DecreaseKey {
    public static void main(String[] args) {
        int[] arr = {10, 20, 40, 80, 100, 70};
        decrease(arr, 3, 5);
        System.out.println(Arrays.toString(arr));
    }

    public static void decrease(int[] arr, int i, int newElement) {

        arr[i] = newElement;
        int parent = (i - 1) / 2;
        while (i != 0 && arr[parent] > arr[i]) {
            int temp = arr[i];
            arr[i] = arr[parent];
            arr[parent] = temp;
            i = parent;
            parent = (i - 1) / 2;
        }
    }
}
