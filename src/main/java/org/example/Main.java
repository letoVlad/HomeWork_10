package org.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println(availableProcessors);
        ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors);

        long startTime = System.nanoTime();

        for (int i = 0; i < availableProcessors; i++) {
            executorService.execute(new FibonacciTask ());
        }

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);


        long endTime = System.nanoTime();
        double executionTimeInSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("Общее время выполнения: " + executionTimeInSeconds + " секунд");
    }
}

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

class MyTask implements Runnable {
    @Override
    public void run() {
        listTask();
    }

    public static void listTask() {
        Random rand = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(rand.nextInt(49) + 1);
        }

        for (int i = 0; i < 50; i++) {
            int number = list.get(i);
            System.out.println("Факториал числа " + number + " = " + factorial(number));
        }
    }

    public static BigInteger factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Вычисление факториала отрицательного числа невозможно!");
        }
        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= number; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }
}
