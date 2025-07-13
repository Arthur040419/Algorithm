package algorithm;

import java.util.*;

//406.根据身高重建队列
public class LeetCode406 {
    public int[][] reconstructQueue(int[][] people) {
        /**
         * 思路：
         * 对于这种存在两个维度的题，最好先将一个维度确定下来，再接着去确定另一个维度
         * 这题就可以先根据身高这个维度，将身高从大到小排列
         * 然后再依次处理每一个元素的k，而在处理k的时候，就可以放心把元素随便地往前插入，因为前面的身高总是大于当前元素的，k为多少，就将元素插到索引为k的位置
         * 这样一来，当前元素往前插入，前面的元素的k也能符合结果（因为后面插入进来的身高始终小于前面元素的身高）
         */

        //先将数组根据身高这一维度排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //当身高相同时，根据k升序排序
                if(o1[0]==o2[0]) return o1[1]-o2[1];
                //身高不同时，根据身高降序排序
                return o2[0]-o1[0];
            }
        });

        LinkedList<int[]> result = new LinkedList<>();

        //接着遍历每一个元素，根据k重新插入新的位置
        for (int i = 0; i < people.length; i++) {
            result.add(people[i][1],people[i]);
        }

        return result.toArray(new int[people.length][]);
    }
}
