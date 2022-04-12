package com.withing.leetcode._41;

/**
 * @author huangweixin7
 * @date 2022/4/12 16:41:12
 * description: Solution
 */
public class Solution {

    //利用数组的下标来标定数字
    //1. 首先数组的长度为n,那么正整数最大不能超过n
    //2. 如果不超过n,那么可以用数组的下标来识别是否存在这个正整数
    //3. 将数组中对应数字的数组位置的数改成负数,但不改变其绝对值
    //4. 如果是负数,为了避免造成影响,统一设置成超过数组长度为n的数字

    public static void main(String[] args) {
        int[] arr = new int[]{0,2};
        Solution solution = new Solution();
        System.out.println(solution.firstMissingPositive(arr));
    }

    public int firstMissingPositive(int[] nums) {
        //先把数组中的负数都剔除掉,换成n+1,避免影响
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) > nums.length ) {
                continue;
            }
            //将对应数组位置的数改成负数
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        int result = 0;
        //找出不为负数的下标则为最高正整数
        for (; result < nums.length; result++) {
            if (nums[result] > 0) {
                break;
            }
        }
        return result + 1;
    }
}
