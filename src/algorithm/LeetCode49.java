package algorithm;

import java.sql.Array;
import java.util.*;

//49.字母异位词分组
public class LeetCode49 {

    //优化,耗时6ms
    public List<List<String>> groupAnagrams_Optimize(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for (String str : strs) {
            //字符串可以直接转换成字符数组
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            //字符数组可以直接转化成字符串
            String key = new String(charArray);

            //学会使用getOrDefault
            List<String> list = map.getOrDefault(key,new ArrayList<String>());

            list.add(str);
            map.put(key,list);
        }

        //直接用map集合中的所有结果来创建集合
        return new ArrayList<>(map.values());
    }

    //耗时36ms
    public List<List<String>> groupAnagrams(String[] strs) {
        /**
         * 思路：
         * 如果两个词的是字母异位词，那么它们的字符排序后的结果一定是一致的
         * 所以可以将字符排序结果一致的词分为一组
         * 使用Map来存储，字符排序后的字符串作为key，value就是一个集合，用来存储同一组中的所有词
         */

        Map<String,List<String>> map = new HashMap<>();

        for (String str : strs) {
            String[] split = str.split("");
            Arrays.sort(split);
            if(map.containsKey(Arrays.toString(split))){
                map.get(Arrays.toString(split)).add(str);
            }else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(Arrays.toString(split),list);
            }
        }

        List<List<String>> res = new ArrayList<>();
        Set<String> keys = map.keySet();
        for (String key : keys) {
            res.add(map.get(key));
        }

        return res;
    }
}
