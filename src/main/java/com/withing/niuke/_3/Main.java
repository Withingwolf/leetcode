package com.withing.niuke._3;

import java.util.Scanner;

/**
 * @author huangweixin7
 * @date 2022/4/15 01:36:37
 * description: Main
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int N = in.nextInt();
        boolean[] array = new boolean[500];
        for (int i = 0; i < N; i++) {
            int b = in.nextInt();
            array[b - 1] = true;
        }

        for (int i = 0; i < 500; i++) {
            if (array[i]) {
                System.out.println(i);
            }
        }
    }
}
