package com.withing.leetcode._30;

import org.junit.Test;

import java.util.*;

public class DiscussSolution {

    public List<Integer> findSubstring(String s, String[] words) {
        if (Objects.isNull(words) || s == null || "".equals(s) || words.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        int n = words.length;
        int m = words[0].length();
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (dict.containsKey(words[i])) {
                dict.put(words[i], dict.get(words[i]) + 1);
            } else {
                dict.put(words[i], 1);
            }
        }
        for (int j = 0; j < s.length() - n * m + 1; j++) {
            Map<String, Integer> map = new HashMap<>(dict);
            int k = n;
            int l = j;
            while (k > 0) {
                String str = s.substring(l, l + m);
                int value = 0;
                if (map.get(str) != null) {
                    value = map.get(str);
                }
                if (!map.containsKey(str) || value < 1) {
                    break;
                } else {
                    map.put(str, map.get(str) - 1);
                    k -= 1;
                    l += m;
                }
            }
            if (k == 0) {
                list.add(j);
            }
        }
        return list;
    }

    @Test
    public void testFindSubstring() {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        List<Integer> list = findSubstring(s, words);
        System.out.println(list);
    }

    @Test
    public void test2() {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "word"};
        List<Integer> list = findSubstring(s, words);
        System.out.println(list);
    }


    @Test
    public void test3() {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar", "foo", "the"};
        List<Integer> list = findSubstring(s, words);
        System.out.println(list);
    }

    @Test
    public void test4() {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "good"};
        List<Integer> list = findSubstring(s, words);
        System.out.println(list);
    }

    @Test
    public void test5() {
        String s = "aaaaaaaa";
        String[] words = {"aa", "aa", "aa"};
        List<Integer> list = findSubstring(s, words);
        System.out.println(list);
    }

    @Test
    public void test6() {
        String s = "";
        String[] words = {};
        List<Integer> list = findSubstring(s, words);
        System.out.println(list);
    }

}
