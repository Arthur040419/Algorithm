package algorithm;

import java.util.*;

//347.前k个高频元素
public class LeetCode347 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }


    public static int[] topKFrequent(int[] nums, int k) {
        /**
         * 思路：
         * 1.统计每个元素出现的次数
         * 2.对每个元素出现的次数排序
         * 3.依次取出前k个高频元素
         *
         * 具体实现如下：
         * 1.使用一个Map集合来记录每个元素出现的次数，元素的值作为key，出现的次数作为value
         * 2.使用优先队列来根据元素出现的次数排序元素
         * 3.从优先队列中依次取出前k个元素
         *
         */

        Map<Integer,Integer> map = new HashMap<>();
        //统计每个元素出现的次数
        for (int num : nums) {
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }

        //优先队列，存储类型为一个数组，数组第一个元素为nums的中出现过的元素，第二个元素为该元素出现的次数
        Queue<int[]> queue = new PriorityQueue<>((o1,o2)-> o2[1]-o1[1]);
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            int[] o = new int[2];
            o[0]=entry.getKey();
            o[1]=entry.getValue();
            queue.add(o);
        }

        //从优先队列中取出前k个元素
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i]=queue.poll()[0];
        }
        return result;
    }

}
