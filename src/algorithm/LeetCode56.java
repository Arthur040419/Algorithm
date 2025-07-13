package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//56.合并区间
public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        /**
         * 思路：
         * 对区间按左边界或右边界进行排序
         * 依次遍历排序后的区间
         * 用一个cover变量记录当前合并后区间的右边界，用start表示当前合并区间的左边界
         * 如果遍历到的区间的左边界小于等于cover，并且当前遍历区间的右边界大于cover，就更新cover
         * 如果遍历到的区间的左边界大于cover，说明当前区间不属于cover这个合并后的区间，此时将合并区间加入到结果集中，并更新cover为当前区间的右边界，寻找新的合并区间
         */

        //将区间按左边界排序
        Arrays.sort(intervals,(o1,o2)->{
            //如果左边界相等，就按右边界从小到大排序
            if(o1[0]==o2[0]) return o1[1]-o2[1];
            return o1[0]-o2[0];
        });

        //初始化合并区间的右边界
        int cover = intervals[0][1];
        //初始化合并区间的左边界
        int start = intervals[0][0];
        List<int[]> result = new ArrayList<>();
        //依次遍历每一个区间
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]<=cover){
                //出现重叠
                cover=Math.max(cover,intervals[i][1]);
            }else {
                //没有出现重叠
                result.add(new int[]{start,cover});
                start=intervals[i][0];
                cover=intervals[i][1];
            }
        }
        //特殊处理最后一个区间
        result.add(new int[]{start,cover});


        return result.toArray(new int[result.size()][]);
    }
}
