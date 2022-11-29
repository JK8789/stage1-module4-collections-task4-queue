package com.epam.collections.queue;

import java.util.*;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> mixedDeque = new ArrayDeque<>();
        Deque<Integer> newFirstQueue = new LinkedList<>(firstQueue);
        Deque<Integer> newSecondQueue = new LinkedList<>(secondQueue);
        if (newFirstQueue.size() >= 2 && newSecondQueue.size() >= 2) {
            mixedDeque.add(newFirstQueue.poll());
            mixedDeque.add(newFirstQueue.poll());
            mixedDeque.add(newSecondQueue.poll());
            mixedDeque.add(newSecondQueue.poll());
        }
        while (!newFirstQueue.isEmpty()) {
            newFirstQueue.add(mixedDeque.pollLast());
            mixedDeque.add(newFirstQueue.poll());
            if (!newFirstQueue.isEmpty()) {
                mixedDeque.add(newFirstQueue.poll());
            }
            newSecondQueue.add(mixedDeque.pollLast());
            mixedDeque.add(newSecondQueue.poll());
            if (!newSecondQueue.isEmpty()) {
                mixedDeque.add(newSecondQueue.poll());
            }
        }
        return mixedDeque;
    }

    public static void main(String[] args) {
        LinkedList<Integer> firstList = new LinkedList<>(List.of(1, 5, 7, 6));
        LinkedList<Integer> secondList = new LinkedList<>(List.of(2, 5, 8, 3));
        //                        List.of(1, 5, 2, 7, 8, 5, 6, 3))
        ArrayDequeCreator arrayDequeCreator = new ArrayDequeCreator();
        arrayDequeCreator.createArrayDeque(firstList, secondList);
    }
}
