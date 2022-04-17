package com.withing.leetcode._735;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author huangweixin7
 * @date 2022/4/16 17:29:47
 * description: Solution
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = new int[]{-2, -1, 1, 2};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.asteroidCollision(array)));
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < asteroids.length; i++) {
            int right = asteroids[i];
            boolean rightP = asteroids[i] > 0;
            if (stack.isEmpty()) {
                if (!rightP) {
                    result.add(right);
                    continue;
                } else {
                    stack.add(asteroids[i]);
                    continue;
                }
            }
            int left = stack.peek();
            boolean leftP = left > 0;
            if (leftP ^ rightP) {
                if (Math.abs(left) > Math.abs(right)) {
                    continue;
                } else if (Math.abs(left) == Math.abs(right)) {
                    stack.pop();
                    continue;
                }
                while (true) {
                    if (stack.isEmpty()) {
                        if (!rightP) {
                            result.add(right);
                            break;
                        } else {
                            stack.add(asteroids[i]);
                            break;
                        }
                    }
                    if (Math.abs(stack.peek()) < Math.abs(right)) {
                        stack.pop();
                        continue;
                    } else if (Math.abs(stack.peek()) == Math.abs(right)) {
                        stack.pop();
                        break;
                    } else {
                        break;
                    }
                }
            } else {
                stack.add(right);
            }
        }
        int[] array = new int[stack.size() + result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }
        for (int i = result.size() + stack.size()-1; i >= result.size(); i--) {
            array[i] = stack.pop();
        }
        return array;
    }
}
