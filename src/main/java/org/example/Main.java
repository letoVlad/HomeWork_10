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




