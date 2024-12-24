package org.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyTask implements Runnable {
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
