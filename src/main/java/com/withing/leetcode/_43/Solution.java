package com.withing.leetcode._43;

/**
 * @author huangweixin7
 * @date 2022/4/17 20:43:42
 * description: Solution
 */
public class Solution {

    public static void main(String[] args) {
        String num1 = "123456789";
        String num2 = "123456789";
        Solution solution = new Solution();
        System.out.println(solution.multiply(num1, num2));
    }

    public String multiply(String num1, String num2) {
        //建一个char num1.length+num2.length 长，num2.length宽的字符串数组
        //第i行的0～num1.length+1位是num1*（num2第i+1位数）的字符串
        //有进位的存在，计算乘积的时候留个temp记录进位的数字
        //遍历完后，复杂度是num2.lengt*乘1个数的复杂度
        //后面把这个字符串数组相加
        //从num1.lenth+num2.length-1开始到0，把同一列的数加起来，留个temp记录进位，给下一计算用。
        //最后把这加起来的字符串输出
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        char[][] broad = new char[num2.length()][num1.length() + num2.length()];
        for (int i = 0; i < num2.length(); i++) {
            for (int j = 0; j < num1.length() + num2.length(); j++) {
                broad[i][j] = '0';
            }
        }
        for (int i = 0; i < num2.length(); i++) {
            int promo = 0;
            int mul = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0; j--) {
                int beMul = num1.charAt(j) - '0';
                broad[i][i + j + 1] = (char) ((mul * beMul + promo) % 10 + '0');
                promo = (mul * beMul + promo) / 10;
            }
            broad[i][i] = (char) (promo + '0');
        }
        char[] resultChar = new char[num1.length() + num2.length()];
        int promo = 0;
        for (int i = num1.length() + num2.length() - 1; i >= 0; i--) {
            int sum = 0;
            for (int j = 0; j < num2.length(); j++) {
                sum += broad[j][i] - '0';
            }
            sum += promo;
            resultChar[i] = (char) (sum % 10 + '0');
            promo = sum / 10;
        }
        String result = new String(resultChar);
        if (result.charAt(0) == '0') {
            result = result.substring(1);
        }
        return result;
    }
}
