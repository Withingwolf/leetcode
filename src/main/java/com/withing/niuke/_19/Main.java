package com.withing.niuke._19;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author huangweixin7
 * @date 2022/4/16 09:45:39
 * description: Main
 */
public class Main {
    public static void main(String[] args) {
        //TODO 要记录的东西包括，后16位，出现的顺序，最后八个出现的，记录最多8条,还得记录出现次数
        //用数组记录，加个指针，标示最后的位置，然后循环一次，跑8步确认是否存在。不存在插入，存在跳过
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        HashMap<String, Integer> map = new HashMap<>();
        String[] records = new String[8];
        int index = 0;
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String path = in.nextLine();
            if(path.equals("z")){
                break;
            }
            String[] split = path.split("\\\\");
            String fileName = split[split.length - 1];
            String file = fileName.split(" ")[0];
            int prefix = file.length() - 16 > 0 ? file.length() - 16 : 0;
            String subString = fileName.substring(prefix, file.length());
            if (map.containsKey(subString)) {
                map.put(subString, map.get(subString) + 1);
                continue;
            }
            map.put(subString, 1);
            records[index] = fileName;
            index = (index + 1) % 8;
        }
        for (int i = 0; i < 8; i++) {
            int point = (index + i) % 8;
            if(records[point]==null){
                continue;
            }
            String file = records[point].split(" ")[0];
            String line = records[point].split(" ")[1];
            int prefix = file.length() - 16 > 0 ? file.length() - 16 : 0;
            String subString = records[point].substring(prefix, file.length());
            System.out.println(subString + " " + line + " " + map.get(subString));
        }
    }
}
