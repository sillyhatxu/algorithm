package com.sillyhat.algorithm.leetcode.easy;

import lombok.extern.slf4j.Slf4j;
import java.util.HashMap;
import java.util.Map;

/**
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 You may assume that each input would have exactly one solution, and you may not use the same element twice.
 Example:
 Given nums = [2, 7, 11, 15], target = 9,
 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 */

@Slf4j
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i + 1;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {32,15,2,7,8,12,5,23,10,22,27};
        int target = 29;
        TwoSum twoSum = new TwoSum();
        int[] index = twoSum.twoSum(numbers,target);
        log.info("index : {}",index);
    }
}
