package com.withing.leetcode._37;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huangweixin7
 * @date 2022/4/13 00:16:36
 * description: Solution
 */
public class Solution {

    boolean[][] column = new boolean[9][9];
    boolean[][] line = new boolean[9][9];
    boolean[][][] boards = new boolean[3][3][9];
    boolean valid = false;
    //记录可填的位置
    private List<int[]> space = new ArrayList<>();

    public static void main(String[] args) {
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = '.';
            }
        }
        Solution solution = new Solution();
        solution.solveSudoku(board);
        System.out.println(board);
    }

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1;
                    column[i][num] = true;
                    line[j][num] = true;
                    boards[i / 3][j / 3][num] = true;
                } else {
                    space.add(new int[]{i, j});
                }
            }
        }
        reverse(board, 0);
    }

    public void reverse(char[][] board, int pos) {
        //整个数独校验通过
        if (pos == space.size()) {
            valid = true;
            return;
        }
        int i = space.get(pos)[0];
        int j = space.get(pos)[1];
        AtomicInteger atomicInteger = new AtomicInteger();
        for (int digit = 0; digit < 9; digit++) {
            if (valid) {
                break;
            }
            if (!column[i][digit] && !line[j][digit] && !boards[i / 3][j / 3][digit]) {
                column[i][digit] = true;
                line[j][digit] = true;
                boards[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                reverse(board, pos + 1);
                column[i][digit] = false;
                line[j][digit] = false;
                boards[i / 3][j / 3][digit] = false;
            }
        }
    }

}
