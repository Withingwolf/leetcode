package com.withing.niuke._2;

import java.util.Scanner;

/**
 * @author huangweixin7
 * @date 2022/4/15 01:11:50
 * description: Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String a = scanner.nextLine();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (a.equalsIgnoreCase(s.substring(i, i + 1))) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}
