package com.withing.leetcode._6;

/**
 * @author huangweixin7
 * @date 2022/4/17 19:48:54
 * description: Solution
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "PAYPALISHIRING";
        int rowNum = 4;
        String result = solution.convert(s, rowNum);
        System.out.println(result);
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        //创建一个char[numRows][s.length]
        //向下，heng,shu, shu +1,heng
        //向下到头,斜向上,heng-1,shu +1
        //交替直到string到头
        char[][] board = new char[numRows][s.length()];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                board[i][j] = '-';
            }
        }
        boolean down = true;
        int row = 0;
        int column = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (row == 0) {
                down = true;
            } else if (row == numRows - 1) {
                down = false;
            }
            if (down) {
                board[row][column] = c;
                row++;
            } else {
                board[row][column] = c;
                row--;
                column++;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (board[i][j] != '-') {
                    builder.append(board[i][j]);
                }
            }
        }
        return builder.toString();
    }
}
