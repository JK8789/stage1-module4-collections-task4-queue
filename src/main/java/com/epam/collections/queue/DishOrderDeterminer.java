package com.epam.collections.queue;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        ArrayDeque<Integer> queue = IntStream.rangeClosed(1, numberOfDishes).boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));
        List<Integer> list = new ArrayList<>();
        int ind = 1;
        while (!queue.isEmpty()) {
            if (ind == everyDishNumberToEat) {
                list.add(queue.remove());
                ind = 1;
            } else {
                ind++;
                queue.add(queue.remove());
            }
        }
        return list;

    }

    public static void main(String[] args) {
        DishOrderDeterminer dishOrderDeterminer = new DishOrderDeterminer();
        System.out.println(dishOrderDeterminer.determineDishOrder(3, 3));
    }
}
