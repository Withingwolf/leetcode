package com.withing.leetcode._31;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author huangweixin7
 * @date 2020/8/4 21:44:57
 * description: Solution
 */
public class Solution {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        int i = nums.length - 2;
        boolean impossible = false;
        while (nums[i] >= nums[i + 1]) {
            if (i == 0) {
                impossible = true;
                break;
            }
            i--;
        }
        if (!impossible) {
            int j = nums.length - 1;
            while (j > i && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
            reverse(nums, i + 1);
        } else {
            reverse(nums, 0);
        }
    }

    private void reverse(int[] nums, int i) {
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test1() {
        int[] nums = {1, 2, 4, 3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test2() {
        int[] nums = {4, 3, 2, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test3() {
        int[] nums = {1, 2, 3, 4};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test4() {
        int[] nums = {2,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test5() {
        int[] nums = {1,5,5};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void testSwap() {
        int[] nums = {1, 5, 8, 4, 7, 6, 5, 3, 1};
        swap(nums, 1, 3);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void testReverse() {
        int[] nums = {1, 3, 4, 2};
        reverse(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

}
