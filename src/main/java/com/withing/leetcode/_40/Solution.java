package com.withing.leetcode._40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangweixin7
 * @date 2022/4/12 14:39:01
 * description: Solution
 */
public class Solution {

    //栈，【1,2,2,2,5]，取1，<5;取2，<5; get 2 =5;输出1，2，2
    //取2，相同，退
    //取5，>5,退2，
    //取5，>5,退1;
    //取5，=5 ，输出5，否则结束

    //【1，1，2，5，6，7，10】
    //栈，取1，取1，取2，取5 >8，退2。 取5=7,取6 =8.退5。
    //1，1 取6，满足，输出
    //输出后退1，取2。1，2，5=8。满足，退2
    //取1，5，6，不行，退5
    //取1，6，7不行，退6
    //取1，7 行，退1。
    //取2，5，6 >8，退5
    //取2，6，满足，退2
    //取5，6，不满足，退5。
    //取6，7，不满足



    public static void main(String[] args) {
        int[] candicates = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1};
        int target = 30;
        Solution solution = new Solution();
        System.out.println(solution.combinationSum2(candicates, target));
    }

    public static List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        recurse(candidates, target, 0, new ArrayList<>());
        List<List<Integer>> ans = new ArrayList<>(result);
        result.clear();
        return ans;
    }

    private void recurse(int[] candicate, int target, int index, List<Integer> preList) {
        if (target == 0) {
            result.add(new ArrayList<>(preList));
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candicate.length; i++) {
            if (i > index && candicate[i] == candicate[i - 1]) {
                continue;
            }
            preList.add(candicate[i]);
            recurse(candicate, target - candicate[i], i + 1, preList);
            preList.remove(preList.size() - 1);
        }
    }

}
