package com.withing.leetcode._39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author huangweixin7
 * @date 2022/4/10 14:42:47
 * description: Solution
 */
public class Solution {


//    public static void main(String[] args) {
//        int[] candicates = {3,12,9,11,6,7,8,5,4};
//        int target = 15;
//        Solution solution = new Solution();
//        System.out.println(solution.combinationSum(candicates, target));
//    }

    //key 是target数字,value是该target对应的结果集
    Map<Integer, List<List<Integer>>> memory = new HashMap<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        recursion(candidates, target, 0);
        List<List<Integer>> result = memory.get(target);
        memory.clear();
        return result;
    }

    private List<List<Integer>> recursion(int[] candidates, int target, int index) {
        if (memory.get(target) != null) {
            return memory.get(target);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] == 0) {
                List<Integer> end = new ArrayList<>();
                end.add(candidates[i]);
                result.add(end);
                memory.put(candidates[i], result);
                return result;
            } else if (target - candidates[i] < 0) {
                continue;
            }
            List<List<Integer>> function_i = recursion(candidates, target - candidates[i], 0);
            if (function_i == null || function_i.isEmpty()) {
                continue;
            }
            List<List<Integer>> copy = new ArrayList<>();
            for (List<Integer> part : function_i) {
                List<Integer> copyPart = new ArrayList<>(part);
                copyPart.add(candidates[i]);
                copyPart = copyPart.stream().sorted().collect(Collectors.toList());
                copy.add(copyPart);
            }
            result.addAll(copy);
            result = result.stream().distinct().collect(Collectors.toList());
        }
        memory.put(target, result);
        return result;
    }

}
