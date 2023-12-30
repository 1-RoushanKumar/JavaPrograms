package com.roushan._10_OOPS._13_Generics;

import java.util.Arrays;

//here it is a custom arraylist, Initially, the size of the list is 1.
public class CustomArrayList {
    private int[] data;
    private static int Default_Size = 1;
    private int size = 0;

    //it creating array of Default size.
    public CustomArrayList() {
        this.data = new int[Default_Size];
    }

    //it will add value after checking the element is enough for the size of the array or not
    //if the size is not enough then it will resize it then add value.
    public void add(int num) {
        if (isFull()) {
            resize();
        }
        data[size++] = num;
    }

    //it will check size.
    private boolean isFull() {
        return size == data.length;
    }

    //it will resize it.
    private void resize() {
        int[] temp = new int[data.length * 2];

        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    //Adding some properties when we want to remove some element it will replace it with zero.
    public int remove(int index) {
        data[index] = 0;
        int removed = data[--size];
        return removed;
    }

    //it print element at given index.
    public int get(int index) {
        return data[index];
    }

    //it will print size.
    public int size() {
        return size;
    }

    //setting value at given index.
    public void set(int index, int value) {
        data[index] = value;
    }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();
        list.add(3);
        list.add(6);
        list.add(9);
        list.add(89);
        list.set(2, 56);
        System.out.println(list.get(1));
        list.remove(3);

        System.out.println(list);
    }
}
//In this custom arraylist we can only able to store integer value.
//If you want to create String or float and you need to write the same code for other variables.
