package com.withing.niuke._6;

import java.util.Scanner;

/**
 * @author huangweixin7
 * @date 2022/4/15 20:35:06
 * description: Main
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) {
            int num = in.nextInt();
            for (int i = 2; i <= num; i++) {
                if (num == 0) {
                    break;
                }
                boolean isPrime = isPrime(num);
                if (isPrime) {
                    System.out.print(num + " ");
                    break;
                }
                while (num % i == 0) {
                    num = num / i;
                    System.out.print(i + " ");
                }
            }
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
