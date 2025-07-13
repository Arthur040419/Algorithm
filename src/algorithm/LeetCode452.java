package algorithm;

import java.util.Arrays;
import java.util.Comparator;

//452.用最少的数量的箭射爆气球
public class LeetCode452 {
    public static void main(String[] args) {
        findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}});
    }

    public static int findMinArrowShots(int[][] points) {
        /**
         * 思路：
         * 贪心策略，贪心点在于对于所有出现重叠气球的区间，都使用一支箭
         * 将points气球按起点排序，去寻找每一个重叠区域，比如有气球[1,6] [2,8] [7,12] [10,16]
         * 第一个重叠区域就是1~6，凡是起点在这个范围内的气球，都可以被一支箭射爆，所以[1,6]和[2,8]就被同一支箭射爆了
         * 接着去找第二个重叠区域：7~12（[2,8]已经被射爆了）,在这个重叠区域内[7,12]和[10,16]会被同一支箭射爆
         * 最终结果就是最少只需要2支箭
         */

        //将所有气球按照起点排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //踩坑点1，这里会溢出，对于这个用例就会排序错误{-2147483646,-2147483645},{2147483646,2147483647}
//                return o1[0]-o2[0];
                //使用Integer内置比较方法，不会溢出
                return Integer.compare(o1[0],o2[0]);
            }
        });

        //最终所消耗的箭
        int result = 0;
        //cover表示重叠范围的右边界,初始化为第一个气球的右边界
        int cover = points[0][1];

        //从前往后遍历
        for (int i = 1; i < points.length; i++) {
            if(points[i][0]>cover){
                cover=points[i][1];
                result++;
            }else {
                //踩坑点2：没有考虑这里的情况
                //如果某一个气球在重叠范围内，需要不断更新cover的范围，让cover范围是所有重叠气球中右边界最小的那一个
                cover=Math.min(cover,points[i][1]);
            }

        }
        //最后再将剩下的气球射爆
        result++;

        return result;
    }
}
