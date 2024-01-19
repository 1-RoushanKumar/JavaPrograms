package com.roushan._12_StacksAndQueues;

public class _07_b_CircularQueueMain {
    public static void main(String[] args) throws Exception {
        _07_a_CircularQueue queue = new _07_a_CircularQueue();
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
