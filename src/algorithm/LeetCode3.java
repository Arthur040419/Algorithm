package algorithm;

import java.util.HashSet;
import java.util.Set;

//3.无重复字符的最长字串
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        /**
         * 思路：看的LeetCode官方题解
         * 滑动窗口
         * 对于abcabcbb这个字符串
         * 从a开始，先找到以a开头的最长不重复字串，也就是abc
         * 那么此时，如果起点向前移动一位，也就是起点变成了b，那么b到上一个字串终点（也就是c）的字符串肯定是不重复的
         * 那么此时可以尝试去扩充字符，字符串的终点也向后移动，直到子串中出现重复字符
         * 一直按这个方法遍历所有起点，不断更新最长的字串长度，就可以找到最终结果
         *
         */

        //字串的起点
        int left = 0;
        //字串的终点
        int right = 0;
        int result = 0;

        //用来记录子串中出现过的字符
        Set<Character> set = new HashSet<>();

        for (left = 0; left < s.length(); left++) {
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
            }
            result = Math.max(result, right - left);
            //起点向前移动
            set.remove(s.charAt(left));
        }

        return result;
    }

    //复习
    public int lengthOfLongestSubstring_review(String s) {
        if (s.length() <= 1) return s.length();
        //子串起点
        int left = 0;
        //子串终点
        int right = 1;
        int result = 0;

        Set<Character> set = new HashSet<>();
        set.add(s.charAt(left));
        for (; left < s.length(); left++) {
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                //这个操作不能放这里，放这里非常耗时，放循坏外耗时能从12ms降到6ms
                //result = Math.max(result, right - left);
            }
            result = Math.max(result, right - left);
            set.remove(s.charAt(left));
        }

        return result;
    }
}
