package algorithm;

import java.util.ArrayList;
import java.util.List;

//763.划分字母区间
public class LeetCode763 {

    //优化代码,优化后耗时4ms
    public List<Integer> partitionLabels_Optimize(String s) {
        /**
         * 下面的代码每次遍历字母时都要调用字符串的lastIndexOf方法，这会非常耗时
         * 因此可以提前统计出所有字母的最远边界
         */

        //Edge[0]表示a的最远边界
        int[] Edge = new int[26];
        //统计字母的最远边界
        for (int i = 0; i < s.length(); i++) {
            Edge[s.charAt(i)-'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        //这个last表示上一个区间的右边界
        int last = -1;
        //cur代表当前区间所有字母的最远边界
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            cur = Math.max(cur,Edge[s.charAt(i)-'a']);
            if(cur==i){
                //到达区间分界点
                result.add(i-last);
                last = cur;
            }
        }

        return result;
    }

    //优化前耗时10ms
    public List<Integer> partitionLabels(String s) {
        /**
         * 思路：
         * 要保证一个区间内的所有字母都只会出现在这个区间内，只需要区间内所有字母的最远边界不会超过当前区间的最远边界
         * 比如这个区间[abab],a字母的最远边界为3，b字母的最远边界为4，此时a、b两个字母的边界都没有超过这个区间的边界
         * 因此对于字符串s中的字母，我们先统计每一个字母的最远边界
         * 然后依次遍历每一个字符，如果到达的位置是前面字母的最远边界，则这个位置就是一个区间的右边界
         * 比如对于ababcc这个字符串，依次统计字母的最远边界为：a为3，b为4，c为6
         * 那么从左往右遍历的流程为，先遍历a，此时前面所有字母的最远边界为3，然后遍历到b，发现b的最远边界为4，于是更新前面所有字母的最远边界为4
         * 接着往后遍历，直到到达4这个位置，前面所有字母的最远边界为4，说明这个位置就是前面字母组成区间的右边界。
         * 找到一个区间后接着遍历后面的字母，采用同样的方式去获取后面的区间
         */

        List<Integer> result = new ArrayList<>();

        //当前区间的最远边界
        int curBorder = s.lastIndexOf(s.charAt(0));
        //len表示区间的长度
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            len++;
            //更新前面字母的最远边界
            curBorder = Math.max(curBorder,s.lastIndexOf(s.charAt(i)));
            if(curBorder==i){
                //如果当前位置到达了区间的最远边界，说明当前位置就是一个分割点
                result.add(len);
                //踩坑点：忘记将len置0了
                len = 0;
            }
        }
        return result;
    }
}
