package com.withing.leetcode._30;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangweixin7
 * @date 2022/4/17 22:17:06
 * description: Solution2
 */
public class Solution2 {
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"word", "good", "best", "word"};
        Solution2 solution = new Solution2();
        System.out.println(Arrays.toString(solution.findSubstring(s, words).toArray()));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        //没考虑单词一样的情况
        //边界条件
        // 1. words是空,返回空
        // 2.如果s.length<words[0]*words.length,返回空
        // 3.s是空,返回空
        if (words == null || words.length == 0) {
            return new ArrayList<>();
        }
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        if (s.length() < words[0].length() * words.length) {
            return new ArrayList<>();
        }
        //构建words的顺序表和words的查找表
        //s从0开始遍历到s.length-words[i].length*words.length
        //s i~words+length是否能在words的查找表里找到,找不到下一个
        //找的到, 将s的 i~words[i].length*words.length按每words[i].length切割,然后按顺序查找对应的字母
        //如果有重复的,或者找不到,则下一个。
        //都通过了记录结果,下一个
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            int a = map.get(words[i]) == null ? 0 : map.get(words[i]);
            map.put(words[i], 1 + a);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= s.length() - words[0].length() * words.length; i++) {
            String w = s.substring(i, i + words[0].length());
            if (!map.containsKey(w)) {
                continue;
            }
            String splitWords = s.substring(i, i + words[0].length() * words.length);
            String[] strings = new String[words.length];
            for (int p = 0; p < words.length; p++) {
                strings[p] = splitWords.substring(p * words[0].length(), (p + 1) * words[0].length());
            }
            Map<String, Integer> filter = new HashMap<>();
            boolean validate = true;
            for (String sp : strings) {
                if (map.containsKey(sp)) {
                    int a = filter.get(sp) == null ? 0 : filter.get(sp);
                    if (a+1 > map.get(sp)) {
                        validate = false;
                        break;
                    }
                    filter.put(sp, 1 + a);
                }else {
                    validate = false;
                    break;
                }
            }
            if (validate) {
                result.add(i);
            }
        }
        return result;
    }
}
