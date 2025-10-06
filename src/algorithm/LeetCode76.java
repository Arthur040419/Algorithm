package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//76.最小覆盖字串
public class LeetCode76 {
    //如果目标字符串中各字符数量与source中的各字符数量相同或小于，那么就说明此时滑动窗口中的字符串覆盖了目标字符串
    Map<Character, Integer> target = new HashMap<>();
    Map<Character, Integer> source = new HashMap<>();


    public String minWindow(String s, String t) {
        /**
         * 思路：官解，滑动窗口
         * 如果滑动窗口内的字符串覆盖了目标字符串，就尝试移动左指针缩小滑动窗口的大小。
         * 如果滑动窗口的字符串没有覆盖目标字符串，就移动右指针，直到覆盖成功为止
         * 期间不断更新最短长度的滑动窗口中的字符串
         */

        //初始化目标map
        for (int i = 0; i < t.length(); i++) {
            target.put(t.charAt(i), target.getOrDefault(t.charAt(i), 0) + 1);
        }

        int res = Integer.MAX_VALUE;
        int resL = 0, resR = 0;          //最终结果的字符串索引范围
        int curLen = 0;
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char key = s.charAt(right);
            if (target.containsKey(key)) {
                source.put(key, source.getOrDefault(key, 0) + 1);
            }
            curLen = right - left + 1;
            while (check() && left <= right) {
                curLen = right - left + 1;
                if(curLen<res){
                    resL = left;
                    resR = right;
                    res = curLen;
                }
                //左指针向前移动，缩小滑动窗口
                if (target.containsKey(s.charAt(left))) {
                    source.put(s.charAt(left), source.get(s.charAt(left)) - 1);
                }
                left++;
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? "" : s.substring(resL, resR + 1);

    }

    //校验滑动窗口中的字串是否包含目标字串
    public boolean check() {
        Set<Map.Entry<Character, Integer>> entries = target.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue() > source.getOrDefault(entry.getKey(), 0)) {
                return false;
            }
        }
        return true;
    }
}
