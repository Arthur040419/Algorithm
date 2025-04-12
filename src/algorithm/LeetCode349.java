package algorithm;

import java.util.*;
import java.util.function.ToIntFunction;

//两个数组的交集
public class LeetCode349 {
    public int[] intersection_My(int[] nums1, int[] nums2) {
        /*我的思路：
         * 采用Map集合，通过键值对的方式来记录每个数字是否出现，以数字作为键，如果出现，那么值就为1
         * 首先遍历nums1，将每个出现的数字记录到map集合中
         * 再遍历nums2，对于nums2中每个出现的数字都到map集合中去寻找，如果找到就说明是交集中的一个数字
         * */

        //新建一个map集合
        Map<Integer, Integer> map = new HashMap<>();
        //新建一个result数组用于记录结果
        int[] result = new int[nums1.length > nums2.length ? nums1.length : nums2.length];
        //遍历nums1
        for (int i : nums1) {
            map.put(i, 1);
        }
        //遍历nums2
        //size用于表示交集的长度
        int size=0;
        for (int i : nums2) {
            if (map.get(i) == 1) {
                result[size++]=map.get(i);
                map.put(i, 0);       //将值修改为0，下次就不会再次记录这个值了，防止结果重复
            }
        }

        return Arrays.copyOfRange(result,0,size);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        /*思路：
         * 学会使用set集合，set集合的特点是无序、不重复、无索引的
         * 利用set集合来存储，这里使用HashSet，由于HashSet不存储重复的元素，因此可以很好地记录nums1中出现了哪些数字
         * 首先遍历nums1，将nums1中出现过的数字放在HashSet集合中
         * 再遍历nums2，在HashSet集合中寻找nums2的数字，如果找到了就说明该数字是两数组的交集的元素。
         * 这题思路上没那么复杂，但是要注意的是数组的转换问题，因为两个数组的交集的结果到底有多少个数字我们是没法明确得知的
         * 所以要使用可变长集合来记录交集结果，而如何把这个可变长集合变成数组就是问题所在，有两种方法来解决这个问题：
         * 1.使用Stream流
         * 2.再创建一个长度等于结果集长度的数组
         * */

        //创建set集合
        Set<Integer> set = new HashSet<>();
        //遍历nums1
        for (int i : nums1) {
            set.add(i);
        }
        //遍历nums2
        //再创建一个结果集，用来存放交集结果
        Set<Integer> result = new HashSet<>();
        for (int i : nums2) {
            //如果在set集合中能够找到nums2中的数字就将其放入结果集
            if(set.contains(i)){
                result.add(i);
            }
        }

        //方法2，创建一个长度与结果集相同的数组
        int[] arr = new int[result.size()];
        int i=0;
        for (Integer value : result) {
            arr[i++]=value;
        }


        //将集合转换成数组
        //方法1，使用Stream流
        return result.stream().mapToInt(new ToIntFunction<Integer>() {
            @Override
            public int applyAsInt(Integer value) {
                return value.intValue();
            }
        }).toArray();

    }
}
