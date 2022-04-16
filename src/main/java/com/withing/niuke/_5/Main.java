package com.withing.niuke._5;

import java.util.Scanner;

/**
 * @author huangweixin7
 * @date 2022/4/15 20:14:37
 * description: Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) {
            String s = in.nextLine();
            int ten = 0;
            for(int i=2;i<s.length();i++){
                int num = 0;
                if(s.charAt(i)-'A'>0){
                    num = s.charAt(i)-'A'+10;
                }
                ten = ten*16+num;
            }
            System.out.println(ten);
        }
    }
}
