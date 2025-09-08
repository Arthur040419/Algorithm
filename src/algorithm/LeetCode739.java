package algorithm;

import java.util.Arrays;

//749.每日温度
public class LeetCode739 {

    public int[] dailyTemperatures(int[] temperatures) {
        /**
         * 思路:
         * 方法一：暴力解法
         * 由于题目中说明温度的范围再30-100之间，所以可以用一个数组next表示每一个温度第一次出现的索引位置，用一个ans数组表示最终每一个温度的更高温度需要等待的天数
         * 接着从后往前遍历输入的温度序列，查看所有比当前温度高的温度第一次出现的索引位置，如果该索引位置小于当前的ans[i]，那么就修改ans[i]的值为较小的值
         */

        int[] ans = new int[temperatures.length];
        int[] next = new int[101];
        Arrays.fill(next,Integer.MAX_VALUE);

        for (int i = temperatures.length-1; i >= 0 ; i--) {
            int warmerIndex = Integer.MAX_VALUE;
            for (int j = temperatures[i]+1; j < 101; j++) {
                warmerIndex = Math.min(warmerIndex,next[j]);
            }
            if(warmerIndex<Integer.MAX_VALUE){
                ans[i] = warmerIndex-i;
            }
            next[temperatures[i]] = Math.min(next[temperatures[i]],i);
        }

        return ans;

    }

}
