package com.withing.leetcode._3;

/**
 * @author huangweixin7
 * @date 2022/4/17 21:42:28
 * description: Solution
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("aab"));
    }

    public int lengthOfLongestSubstring(String s) {
        if ("".equals(s)) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i + 1;
            for (; j < s.length(); j++) {
                int index = s.substring(i, j).indexOf(s.charAt(j));
                if (index >= 0) {
                    max = Math.max(max, j - i);
                    i = i + index;
                    break;
                }
            }
            if (j == s.length()) {
                max = Math.max(max, s.length() - i);
                break;
            }
        }
        return max;
    }

}
