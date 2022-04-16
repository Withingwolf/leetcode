package com.withing.niuke._1;

import java.util.Scanner;

/**
 * @author huangweixin7
 * @date 2022/4/15 01:09:13
 * description: Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s = in.nextLine();
        System.out.println(s.length() - s.lastIndexOf(" ") - 1);
    }
}
