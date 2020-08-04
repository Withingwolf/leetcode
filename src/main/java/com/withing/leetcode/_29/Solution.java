package com.withing.leetcode._29;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
 */
public class Solution {

    @Test
    public void init(){
        System.out.println(divide(-2147483648,-1));
    }


    public int divide(int dividend, int divisor) {
        long lDividend = (long) dividend;
        long lDivisor = (long)divisor;

        long answer = lDividend/lDivisor;
        if(answer>Long.valueOf(Integer.MAX_VALUE)||answer<(long)Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }else {
            return (int)answer;
        }
    }


}
