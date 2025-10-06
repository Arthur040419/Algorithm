package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//438.找到字符串中所有字母异位词
public class LeetCode438 {
    public List<Integer> findAnagrams(String s, String p) {
        /**
         * 思路：
         * 由于互为字母异位词的两个字符串它们的长度一定是一样的，所以我们可以维护一个长度与字母异位词长度相同的滑动窗口
         * 统计目标字符串p中每个字符出现的次数pCount，并统计滑动窗口范围内的字符串中每个字符出现的次数sCount
         * 如果pCount与sCount相同，说明它们是字母异位词，就将此时的滑动窗口的开始所以添加到结果集中
         */

        int sLen = s.length();
        int pLen = p.length();

        //如果目标字符的长度比s字符串长，说明在s字符串中肯定找不到p的字母异位词，直接返回空集合
        if(pLen>sLen) return Collections.emptyList();

        //统计目标字符串中所有字母出现的次数
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i)-'a']++;
        }

        //初始化sCount
        int[] sCount = new int[26];
        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i)-'a']++;
        }

        List<Integer> result = new ArrayList<>();

        //如果此时pCount与sCount相同，说明开始索引为0的滑动窗口中的字符串符合要求
        if(Arrays.equals(pCount,sCount)){
            result.add(0);
        }

        //接着开始移动滑动窗口
        for (int i = 0; i < sLen-pLen; i++) {
            //先移出前面的字符
            sCount[s.charAt(i)-'a']--;
            //再添加后面新的字符
            sCount[s.charAt(i+pLen)-'a']++;

            //再判断新的滑动窗口内的字符串是否为字母异位词
            if(Arrays.equals(sCount,pCount)){
                result.add(i+1);
            }

        }

        return result;
    }

    //复习
    public List<Integer> findAnagrams_Review(String s, String p) {
        return null;
    }
}
