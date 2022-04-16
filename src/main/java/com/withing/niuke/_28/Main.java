package com.withing.niuke._28;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author huangweixin7
 * @date 2022/4/16 12:04:17
 * description: Main
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //匈牙利算法，先到先得，能让则让
        //分奇偶两个数组，如果能匹配，则优先匹配，当发现有多匹配现象的时候，则递归让先匹配到的那个再去找匹配，如果找到了，则换，没找到就不换。
        // 注意 hasNext 和 hasNextLine 的区别
        ArrayList<Integer> odds = new ArrayList<>();
        ArrayList<Integer> evens = new ArrayList<>();
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            if(n ==0){
                break;
            }
            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                if (num % 2 == 0) {
                    evens.add(num);
                } else {
                    odds.add(num);
                }
            }
        }
        boolean[] used = new boolean[evens.size()];
        int []match = new int[evens.size()];
        int sum = 0;
        for (int i = 0; i < odds.size(); i++) {
            if (find(odds.get(i), evens, used, match)) {
                sum++;
            }
        }
        System.out.println(sum);//剩下6112可以和12737
    }

    private static boolean find(int odd, ArrayList<Integer> evens, boolean[] used,
                                int []match) {
        for (int i = 0; i < evens.size(); i++) {
            if (match[i]!=odd&&isPrime(evens.get(i) + odd)) {
                if (!used[i]) {
                    used[i] = true;
                    match[i] = odd;
                    return true;
                } else {
                    if (find(match[i], evens, used, match)) {
                        match[i] = evens.get(i);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
