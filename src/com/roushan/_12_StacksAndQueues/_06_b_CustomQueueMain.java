package com.roushan._12_StacksAndQueues;

public class _06_b_CustomQueueMain {
    public static void main(String[] args) throws Exception {
        _06_a_CustomQueue queue = new _06_a_CustomQueue(5);
        queue.insert(3);
        queue.insert(6);
        queue.insert(5);
        queue.insert(19);
        queue.insert(1);

        queue.display();

        System.out.println(queue.remove());
        queue.display();

        System.out.println(queue.remove());
        queue.insert(99);
        queue.display();

        System.out.println(queue.front());

    }
}
