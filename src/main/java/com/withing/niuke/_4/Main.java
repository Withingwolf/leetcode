package com.withing.niuke._4;

import java.util.Scanner;

/**
 * @author huangweixin7
 * @date 2022/4/15 09:42:40
 * description: Main
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            for (int i = 0; i < s.length(); i += 8) {
                StringBuilder temp = null;
                if (i + 8 > s.length()) {
                    temp = new StringBuilder(s.substring(i, s.length()));
                    for (int j = 0; j < i + 8 - s.length(); j++) {
                        temp.append("0");
                    }
                } else {
                    temp = new StringBuilder(s.substring(i, i + 8));
                }
                System.out.println(temp);
            }
        }
    }
}
