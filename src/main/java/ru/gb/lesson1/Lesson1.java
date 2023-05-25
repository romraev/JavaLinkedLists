package ru.gb.lesson1;

public class Lesson1 {

    public static void main(String[] args) {
        // O(n) O(n^2) O(logn) ...
        // O(2^n)

        // O(n) + O(n) = O(2n)

        // 1000 -> 2000
        // 4000 -> 8000


        System.out.println(fibonacciFast(6));
    }

    private static void linear(int[] array) {
        // Нужно найти максимальный элемент в массиве
        int max = array[0];
        for (int i = 1; i < array.length; i++) { // O(n)
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("Max = " + max);

        int sumEven = 0;
        for (int i = 0; i < array.length; i = i + 2) {
            sumEven += array[i];
        }
        System.out.println("Sum even = " + sumEven);
        // 1000 -> 500
        // 100_000 -> 50_000
        // 10_000_000 -> 5_000_000
    }

    private static void square(int[][] array) {
        // просуммировать диагональные элементы

        int sum = 0;
        // O(n^2 / 2)
        for (int i = 0; i < array.length; i++) { // O(n)
            sum += array[i][i];
            for (int j = 0; j < array.length; j++) { // O(n/2)
                if (i == j) {
                    sum += array[i][i];
                    break;
                }
            }
        }
        System.out.println("Diagonal elements sum = " + sum);


        // 1 -> 1
        // 10 -> 10 * 10 = 100 / 2 = 50
        // 100 -> 100 * 100 = 10_000 / 2 = 5_000
    }

    private static void logarithm(int[] array) {
        // суммируем элементы с индексами
        // 0, 1, 2, 4, 8, 16, 32, ..
        int sum = array[0];
        for (int i = 1; i < array.length; i = i * 2) {
            sum += array[i];
        }
        System.out.println("sum = " + sum);

        // 100 -> 8
        // 1000 -> 11

        // 9 -> 128
        // 10 -> 256
        // 11 -> 512
        // 12 -> 1024

    }

    // O(e^n)
    private static int fibonacciRecursive(int n) {
        // 0 1 1 2 3 5 8 13 21 ...
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        // f(10) = f(9) + f(8) = (f(8) + f(7)) + (f(7) + f(6))
        return fibonacciRecursive(n - 2) + fibonacciRecursive(n - 1);
    }

    // O(n)
    private static int fibonacciFast(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }





}