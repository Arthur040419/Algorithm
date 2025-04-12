package algorithm;


import java.util.Arrays;

//151.反转字符串中的单词
public class LeetCode151 {
    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }

    public static String reverseWords(String s){
        //不许用库函数
        /**
         * 整体思路：
         * 首先移除字符串中多余的空格，多余的空格指的是字符串首尾的空格以及中间多出来的空格，分割单词的单个空格不算
         * 然后将整个字符串反转，此时单词出现的顺序反转了，但同时单词内部字符出现的顺序也反转了
         * 因此再将每个单词内部字符再反转回来，此时字符就仅仅只有单词出现的顺序反转了，而单词内部并没有反转
         */

        //移除多余空格
        StringBuilder sb = removeSpace(s);
        //反转整个字符串
        reverseString(sb,0,sb.length()-1);
        //最后反转每个单词
        reverseSingleWord(sb);
        return  sb.toString();
    }

    public static StringBuilder removeSpace(String s){
        //这个移除多余空格的思路也要好好学一学
        StringBuilder sb = new StringBuilder();
        int left=0;
        int right=s.length()-1;
        //首先移除首尾多余的空格
        while(s.charAt(left)==' ') left++;
        while(s.charAt(right)==' ') right--;
        //接着移除中间多余的空格
        while(left<=right){
            if(s.charAt(left)!=' '||sb.charAt(sb.length()-1)!=' '){
                sb.append(s.charAt(left));
            }
            left++;
        }
        return sb;
    }

    public static void reverseString(StringBuilder sb,int left,int right){
        //反转指定区间的字符串
        //双指针反转
        while(left<right){
            char tmp = sb.charAt(left);
            sb.setCharAt(left,sb.charAt(right));
            sb.setCharAt(right,tmp);
            left++;
            right--;
        }
    }

    public static void reverseSingleWord(StringBuilder sb){
        //反转每个单词
        //start代表每个单词的起始位置
        int start=0;
        //end代表每个单词的结束位置
        int end = start+1;
        //n代表字符串的长度
        int n =sb.length();
        while (start<n){
            //寻找每个单词的结束位置
            while (end<n&&sb.charAt(end)!=' '){
                end++;
            }
            reverseString(sb,start,end-1);
            start=end+1;
            end=start+1;
        }
    }


    public static String reverseWords_My(String s) {
        //用库函数没啥意思
        s=s.trim();
        String[] words = s.split("\\s+");
        System.out.println(Arrays.toString(words));
        //双指针
        int left = 0;
        int right = words.length-1;
        while(left<right){
            String tmp = words[left];
            words[left]=words[right];
            words[right]=tmp;
            left++;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if(i!=words.length-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}
