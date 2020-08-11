package com.withing.leetcode._32;

import org.junit.Test;

/**
 * @author huangweixin7
 * @date 2020/8/11 22:44:04
 * description: Solution
 */
public class DynamicSolution {

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
        int max = 0;
        for(int i=1;i<s.length();i++){
            int before = i-dp[i-1];
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='(') {
                    if(i>=2){
                        dp[i] = dp[i-2]+2;
                    }else {
                        dp[i] = 2;
                    }
                }else if (before>0&&s.charAt(before-1)=='('){
                    if(before-2>=0) {
                        dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                    }else {
                        dp[i] = dp[i-1]+2;
                    }
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

}
