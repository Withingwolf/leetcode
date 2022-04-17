package com.withing.niuke._25;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author huangweixin7
 * @date 2022/4/16 16:55:12
 * description: Main
 */
public class Main {

    //对R遍历，找满足条件的I
    //I整数对应的数字要联系包含R<i>对应的数字：转成字符串，查indexof
    //R[i] -> 满足的个数
    //输出满足I的索引，最后输出I
    //对R[i]排序
    //没有满足条件的恶不要
    //在最前面输出后面的个数
    static class Pair<K,V>{
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Map<String, List<Pair<Integer, String>>> map = new HashMap<>();
        Scanner in = new Scanner(System.in);
        String IString = in.nextLine();
        String RString = in.nextLine();
        String[] I = IString.split(" ");
        String[] R = RString.split(" ");
//        int iNum = Integer.parseInt(I[0]);
//        int rNum = Integer.parseInt(R[0]);
        List<String> listI = new ArrayList<>();
        List<String> listR = new ArrayList<>();
        for (int i = 1; i < I.length; i++) {
            listI.add(I[i]);
        }
        for (int i = 1; i < R.length; i++) {
            listR.add(R[i]);
        }
        listR = listR.stream().sorted().distinct().collect(Collectors.toList());
        for (String r : listR) {
            for (int i = 0; i < listI.size(); i++) {
                String iString = listI.get(i);
                int index = iString.indexOf(r);
                if (index == -1) {
                    continue;
                } else {
                    List<Pair<Integer, String>> rToI = map.get(r);
                    if (rToI == null) {
                        rToI = new ArrayList<>();
                    }
                    rToI.add(new Pair<>(i, iString));
                    map.put(r,rToI);
                }
            }
        }
        int sum = 0;
        List<Map.Entry<String,List<Pair<Integer,String>>>> list =
                map.entrySet().stream().sorted(Comparator.comparingInt(x -> Integer.parseInt(x.getKey()))).collect(Collectors.toList());
        for (Map.Entry<String, List<Pair<Integer, String>>> entry : list) {
            if(entry.getValue()==null){
                continue;
            }
            sum += 2+ entry.getValue().size()*2;
        }
        System.out.print(sum+" ");
        for (Map.Entry<String, List<Pair<Integer, String>>> entry : list) {
            if(entry.getValue()==null){
                continue;
            }
            System.out.print(entry.getKey()+" ");
            System.out.print(entry.getValue().size()+" ");
            for(Pair<Integer,String> pair:entry.getValue()){
                System.out.print(pair.getKey()+" ");
                System.out.print(pair.getValue()+" ");
            }
        }
    }

}
