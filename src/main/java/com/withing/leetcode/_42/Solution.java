package com.withing.leetcode._42;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangweixin7
 * @date 2022/4/12 17:56:01
 * description: Solution
 */
public class Solution {


    public static void main(String[] args) {
        int[] water = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        Solution solution = new Solution();
        System.out.println(solution.trap(water));
    }

    public int trap(int[] height) {
        //求极值,即height[i-1]<height[i]  &&height[i]>height[i+1]
        //列成极值数组top-height[]
        //计算两两极值容水量:∑(min(height[left],height[right])-heiht[i]>0?min-height[i]:0)
        List<Integer> topHeightIndex = new ArrayList<>();
        int waterSum = 0;
        int[] expandHeight = new int[height.length + 2];
        expandHeight[0] = 0;
        expandHeight[expandHeight.length - 1] = 0;
        for (int i = 0; i < height.length; i++) {
            expandHeight[i + 1] = height[i];
        }
        for (int i = 1; i < expandHeight.length - 1; i++) {
            if (expandHeight[i] >= expandHeight[i - 1] && expandHeight[i] >= expandHeight[i + 1]) {
                topHeightIndex.add(i);
            }
        }
        if (topHeightIndex.size() < 2) {
            return 0;
        }
        for (int i = 0; i < topHeightIndex.size() - 1; ) {
            int left = topHeightIndex.get(i);
            int rightMaxIndex = i + 1;
            int rightMax = -1;
            for (int j = i + 1; j < topHeightIndex.size(); j++) {
                int right = topHeightIndex.get(j);

                if (expandHeight[left] <= expandHeight[right]) {
                    //找比left大的极值点
                    //1。找到了，计算left-right的水量
                    //2.如果没找到（到最后了），则计算最近的一块，找下一个最大
                    rightMaxIndex = j;
                    break;
                } else {
                    if (rightMax < expandHeight[right]) {
                        rightMaxIndex = j;
                        rightMax = expandHeight[right];
                    }
                }
            }
            int right = topHeightIndex.get(rightMaxIndex);
            waterSum += calWater(left, right, expandHeight);
            i = rightMaxIndex;
        }
        return waterSum;
    }

    private int calWater(int left, int right, int[] height) {
        int waterSum = 0;
        for (int i = left; i <= right; i++) {
            waterSum += Math.max(Math.min(height[left], height[right]) - height[i], 0);
        }
        return waterSum;
    }

}
