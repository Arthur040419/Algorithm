package algorithm;

import java.util.Arrays;

//459.重复的子字符串
public class LeetCode459 {

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("ababac"));
    }
    public static boolean repeatedSubstringPattern(String s) {
        /**
         * 思路：
         * 一个字串如果是由重复字串组成，那么其最长相等前后缀所不包含的字串一定是重复的字串
         * 因此我们就去计算s的最长相等前后缀，此时不被包含的子串l与最长相等前后缀的关系有以下三种情况：
         * 1.不被包含的子串长度大于字符串s的一半，说明s不可能由重复字符串组成
         * 2.不被包含的子串长度刚好能够整除最长相等前后缀的长度，说明s由重复子串组成，且重复子串为不被包含的子串l
         * 3.不被包含的子串长度不能够整除最长相等前后缀的长度，说明s不是由重复子串组成。
         */

        int[] next = new int[s.length()];
        //获取字符串s的next数组
        getNext(next, s);
        //获取字符串s的最长前后缀长度
        //Arrays.sort(next);
        int max = next[s.length()-1];
        if((s.length()-max)>s.length()/2){
            //情况1
            return false;
        }else if(max%(s.length()-max)==0){
            //情况2
            return true;
        }
        //情况3
        return false;

    }

    public static void getNext(int[] next, String s) {
        //求s的next数组
        //初始化
        next[0] = 0;
        //j指向前缀末尾
        int j = 0;
        //i指向后缀末尾
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j=next[j-1];
            }
            if(s.charAt(j)==s.charAt(i)){
                j++;
            }
            next[i]=j;
        }
    }
}
