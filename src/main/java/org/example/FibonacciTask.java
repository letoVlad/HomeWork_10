package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class FibonacciTask implements Runnable {
    @Override
    public void run() {
        calculateFibonacci();
    }

    public static void calculateFibonacci() {
        Random rand = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(rand.nextInt(30) + 15);
        }

        List<String> results = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int number = list.get(i);
            results.add("Число Фибоначчи для " + number + " = " + fibonacci(number));
        }

        results.forEach(System.out::println);
    }

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}