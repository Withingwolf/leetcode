package com.withing.leetcode._32;

import org.junit.Test;

/**
 * @author huangweixin7
 * @date 2020/8/11 22:44:04
 * description: Solution
 */
public class Solution {

    static String str = null;

    @Test
    public void testLongestValidParentheses1() {
        String s = "(()";
        System.out.println(longestValidParentheses(s));
    }

    @Test
    public void testLongestValidParentheses2() {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }

    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        str = s;
        calculateLongestLegalSubstring(dp, s.length() - 1);
        return dp[s.length() - 1];
    }

    private int calculateLongestLegalSubstring(int[] dp, int position) {
        if (position < 0) {
            return 0;
        }
        dp[position] = calculateLongestLegalSubstring(dp, position - 1) + calculateLongestLegalSubstring(dp,
                position - calculateLongestLegalSubstring(dp, position - 1) - 2) + 2;
        return dp[position];
    }

}
