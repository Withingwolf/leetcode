package com.withing.leetcode._38;

/**
 * @author huangweixin7
 * @date 2022/4/10 13:58:14
 * description: Solution
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(6));
    }

    public String countAndSay(int n) {
        //循环表示言语数字
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = countAndSaysay(s);
        }
        return s;
    }

    private String countAndSaysay(String s) {
        StringBuilder result = new StringBuilder();
        char index = s.charAt(0);
        int count = 0;
        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length()) {
                result.append(count).append(index);
                break;
            }
            char c = s.charAt(i);
            if (index != c) {
                result.append(count).append(index);
                index = c;
                count = 1;
            } else {
                count++;
            }
        }
        return result.toString();
    }


}
