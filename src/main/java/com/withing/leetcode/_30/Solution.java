package com.withing.leetcode._30;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (Objects.isNull(words) || s == null || "".equals(s) || words.length == 0) {
            return new ArrayList<>();
        }
        int length = words[0].length();
        int totalLength = length * words.length;
        int index = 0;
        List<Integer> answer = new ArrayList<>();
        while (index + totalLength <= s.length()) {
            //这里需要加个判断,如果前面的words[0].length 找不到,就别切割了
            String temp = s.substring(index, index + totalLength);
            String[] tWords = splitStr(temp, length);
            if (compareStrings(tWords, words)) {
                answer.add(index);
            }
            index++;
        }
        return answer;
    }

    private boolean compareStrings(String[] s1, String[] s2) {
        int[] map = new int[s1.length];
        Arrays.fill(map, -1);
        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s2.length; j++) {
                if (!contains(map, j)) {
                    if (s1[i].equals(s2[j])) {
                        map[i] = j;
                    }
                }
            }
        }
        boolean isMap = true;
        for (int i = 0; i < map.length; i++) {
            isMap &= map[i] != -1;
        }
        return isMap;
    }

    private String[] splitStr(String str, int interval) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < str.length(); i += interval) {
            strings.add(str.substring(i, i + interval));
        }
        return strings.toArray(new String[str.length() / interval]);
    }

    private boolean contains(int[] array, int target) {
        boolean contains = false;
        for (int i = 0; i < array.length; i++) {
            contains |= target == array[i];
        }
        return contains;
    }

    @Test
    public void testContains() {
        int[] array = {1, 2, 4, 5, 6};
        int i = 6;
        boolean contains = contains(array, i);
        System.out.println(contains);
    }

    @Test
    public void testCompare() {
        String a = "foobar";
        String l = "barfoo";
        String[] as = splitStr(a, 3);
        String[] ls = splitStr(l, 3);

        boolean isMap = compareStrings(as, ls);
        System.out.println(isMap);

    }

    @Test
    public void testSpiltStr() {
        String s = "asdfasdfasdf";
        String[] strings = splitStr(s, 4);
        System.out.println(Arrays.toString(strings));
        strings = splitStr(s, 3);
        System.out.println(Arrays.toString(strings));
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
    public void test5(){
        String s = "aaaaaaaa";
        String[] words = {"aa", "aa", "aa"};
        List<Integer> list = findSubstring(s, words);
        System.out.println(list);
    }

    @Test
    public void test6(){
        String s = "";
        String[] words = {};
        List<Integer> list = findSubstring(s, words);
        System.out.println(list);
    }

}
