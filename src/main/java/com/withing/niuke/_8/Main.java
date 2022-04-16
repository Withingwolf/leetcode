package com.withing.niuke._8;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author huangweixin7
 * @date 2022/4/15 20:47:55
 * description: Main
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer,Integer> map = new HashMap<>(500);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int num = in.nextInt();
            for(int i=0;i<num;i++){
                int a = in.nextInt();
                int b = in.nextInt();
                Integer exist = map.get(a);
                if(exist!=null){
                    map.put(a,b+exist);
                }else{
                    map.put(a,b);
                }
            }
            map.entrySet().stream()
                    .sorted((x,y)->x.getKey()-y.getKey()).forEach(x->System.out.println(x.getKey()+" "+x.getValue()));
        }
    }

}
