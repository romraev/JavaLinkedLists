package ru.gb.lesson1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        // leetcode.com
        int[] nums = {2, 0, 2};
        System.out.println(Arrays.toString(twoSum(nums, 4)));
    }

    /**
     * nums = [2,7,11,15], target = 9
     * => {0, 1}
     */
    // O(n)
    public static int[] twoSum(int[] nums, int target) {
        // i, j : nums[i] + nums[j] = target
        // target - nums[i] = nums[j]

        // i -> target - nums[i]

        // 2, 0, 2  --- 4
        // 2 -> 2
        // 0 -> 1
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int toFind = target - nums[i];

            Integer found = map.get(toFind); // O(1)
            if (found != null && found != i) {
                return new int[]{i, found};
            }
        }
        throw new IllegalArgumentException();
    }

}
