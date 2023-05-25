package ru.gb.lesson2;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Lesson2 {

    public static void main(String[] args) {
//        sortMain();
        // [5, 3, 7, 1, 2, 9, 12, 1]

        int[] array = {1, 2, 3, 5, 6, 7, 8};
        System.out.println(binarySearch(array, 1)); // 0
        System.out.println(binarySearch(array, 2)); // 1
        System.out.println(binarySearch(array, 3)); // 2
        System.out.println(binarySearch(array, 4)); // -1
        System.out.println(binarySearch(array, 5)); // 3
        System.out.println(binarySearch(array, 6)); // 4
        System.out.println(binarySearch(array, 7)); // 5
        System.out.println(binarySearch(array, 8)); // 6
        System.out.println(binarySearch(array, 10)); // -1
    }

    private static void sortMain() {
        int[] arr = {5, 3, 7, 1, 2, 9, 12, 1};
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] array = IntStream.generate(() -> ThreadLocalRandom.current().nextInt(10_000)).limit(100_000).toArray();
        Arrays.sort(array);

        int[] copied = Arrays.copyOf(array, array.length);
        long start = System.currentTimeMillis(); // количество милисекунд с 1970 года по UTC (UNIX время)
        bubbleSort(copied);
        long end = System.currentTimeMillis();
        System.out.println("Bubble sort = " + (end - start));

        copied = Arrays.copyOf(array, array.length);
        start = System.currentTimeMillis(); // количество милисекунд с 1970 года по UTC (UNIX время)
        selectionSort(copied);
        end = System.currentTimeMillis();
        System.out.println("Selection sort = " + (end - start));
    }

    // Задача: переприсвоить 2 целых числа без использования третей переменной

    static void bubbleSort(int[] array) {
        // O(n^2) в худшем случае
        // O(n) в лучшем случае (массив отсортирован)
        for (int j = 0; j < array.length - 1; j++) {
            boolean isSorted = true;
            for (int i = 0; i < array.length - 1 - j; i++) {
                if (array[i] > array[i + 1]) {
                    isSorted = false;

                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    static void selectionSort(int[] array) {
        // O(n^2)
        for (int i = 0; i < array.length; i++) {
            int min = array[i]; // 2
            int minIndex = i; // 1
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }
            // меняем местами minIndex и i
            int tmp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = tmp;
        }
    }

    //    /** Найти индекс элемента, который равен target. Если элемента нет - вернуть -1
    static int binarySearch(int[] data, int target) {
        return binarySearchRecursive(data, target, 0, data.length);
    }

    // java return boolExpression ? ifTrue : ifFalse Тернарный оператор
    // python return ifTrue if boolExpression else ifFalse
    static int binarySearchRecursive(int[] data, int target, int left, int right) {
        // [0, n)
        // [n/2, n)
        // [n-1, n)
        // [left, right)
        // target = 5
        // [1, 2, 3, 4, 5, 6, 7, 8]
        if (left + 1 == right) {
            return data[left] == target ? left : -1;
//            if (data[left] != target) {
//                return -1;
//            } else {
//                return left; // или right
//            }
        }

        int middleIndex = (left + right) / 2;
        int middleElement = data[middleIndex];
        if (middleElement == target) {
            return middleIndex;
        } else if (middleElement < target) {
            // Ищем справа
            return binarySearchRecursive(data, target, middleIndex + 1, right);
        } else {
            // Ищем слева
            return binarySearchRecursive(data, target, 0, middleIndex);
        }
    }


}
