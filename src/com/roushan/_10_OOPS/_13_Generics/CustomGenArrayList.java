package com.roushan._10_OOPS._13_Generics;

import java.util.ArrayList;
import java.util.Arrays;
//https://youtu.be/OY2lPr8h93U?list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&t=1175
// https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html#createObjects

public class CustomGenArrayList<T> {

    private Object[] data;
    private static int DEFAULT_SIZE = 1;
    private int size = 0; // also working as index value

    public CustomGenArrayList() {
        data = new Object[DEFAULT_SIZE];
    }

    public void add(T num) {
        if (isFull()) {
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        Object[] temp = new Object[data.length * 2];

        // copy the current items in the new array
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    private boolean isFull() {
        return size == data.length;
    }

    public T remove() {
        T removed = (T) (data[--size]);
        return removed;
    }

    public T get(int index) {
        return (T) data[index];
    }

    public int size() {
        return size;
    }

    public void set(int index, T value) {
        data[index] = value;
    }

    @Override
    public String toString() {
        return "CustomGenArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        CustomGenArrayList<Integer> list = new CustomGenArrayList<>();
        for (int i = 0; i < 14; i++) {
            list.add(2 * i);
        }

        System.out.println(list);
        CustomGenArrayList<String> list1 = new CustomGenArrayList<>();
        list1.add("Rocky");
        list1.add("Raja");
        System.out.println(list1);

    }
}
