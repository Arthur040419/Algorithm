package algorithm;

import java.util.Arrays;

//435.无重叠区间
public class LeetCode435 {


    public int eraseOverlapIntervals(int[][] intervals) {
        /**
         * 思路：
         * 这道题说实话，我觉得非常难以理解
         * 这道题的贪心策略在于如果出现重叠，就优先移除区间范围更大的区间
         * 因为区间越大，就代表越有可能与其他区间发生重叠
         * 想法是这么想的，但是实现起来就显得有点抽象
         * 1.首先将区间按左边界或者右边界进行排序，这里选择右边界
         * 比如[1,2] [2,3] [3,4] [1,3]
         * 排序后就是 [1,2] [1,3] [2,3] [3,4]
         * 2.接着从左往右依次获取区间范围最小的区间，比如这里是[1,2]，与这个区间重叠的所有区间都要移除，比如这里需要移除[1,3]
         * 3.当遍历到第一个不与上面区间重叠的区间时，就记录最终剩余的区间数加1（[1,2]区间一定会被保留），比如这里第一个不与[1,2]重叠的区间就是[2,3]
         * 4.此时就用这个新的[2,3]区间去判断后面的区间，凡是与这个区间重叠的都要移除，与上面的步骤一样，直到遍历完所有区间
         * 最后得到的剩余区间数就是能够剩余的最大区间数maxCount，用原本的区间数减去这个值就是最终的结果
         */

        //根据右边界排序
        Arrays.sort(intervals,(o1,o2)->{
            //如果右边界相同，就按左边界从小到大排序
            if(o1[1]==o2[1]) return o1[0]-o2[0];
            return o1[1]-o2[1];
        });

        //初始化最小右边界,代表的就是每次获取的范围最小的区间的右边界
        int minRight = Integer.MIN_VALUE;
        //最终剩余的最大区间数
        int maxCount = 0;
        //从左遍历区间
        for (int i = 0; i < intervals.length; i++) {
            //如果区间的左边界小于minRight，说明重叠了，该区间需要去除
            if(intervals[i][0]>=minRight){
                //如果区间左边界大于等于minRight，就更新区间
                minRight = intervals[i][1];
                maxCount++;
            }
        }

        return intervals.length-maxCount;

    }
}
