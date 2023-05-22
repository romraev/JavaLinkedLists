package ru.gb.lesson1;

import java.util.Arrays;

public class DuplicatesOnSortedArray {

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Дано: отсортированный по возрастанию массив с повторяющимися элементами,
     * например 0,1,0,1,1,2,2,3,3,4
     * Нужно: "Схлопнуть" повторяющиеся элементы В ЭТОМ ЖЕ массиве
     * Оставшиеся элементы могут быть любыми
     * Должно получиться так 0,1,2,3,4,_,_,_,_,_
     * <p>
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
     */
    public static void removeDuplicates(int[] array) {
        int i = 0;
        for (int j = 1; j < array.length; j++) {
            if (array[j] != array[i]) {
                i += 1;
                array[i] = array[j];
                System.out.println(array[j]);
            }
        }
    }

}
