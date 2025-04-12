package algorithm;

/**
 * 28.找出字符串中第一个匹配项的下标
 */
public class LeetCode28 {
    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
    }


    public static int strStr(String haystack, String needle) {
        /**
         * 正确思路：KMP算法
         * 这个KMP算法挺抽象的，具体的算法讲解见笔记或资料。
         * 首先先构造needle的next数组，next数组就是模式串needle的每个字符对应的最长公共前后缀长度
         * 构造完next数组后就可以让haystack与needle进行比对
         * 定义两个指针，i指向haystack，j指向needle
         * 如果i，j指向的字符相同，i++ j++
         * 如果不同就根据j对应的next数组的值，让j回退到next数组指向的位置
         * 就这样一直比对
         * 直到j指向needle的末尾，说明成功匹配
         * 或者i指向haystack的末尾，但如果此时j没有指向needle的末尾，说明没有找到
         */

        //构造next数组，这是难点，next数组表示的就是当前位置的前面字符串的最长公共前后缀
        int[] next = new int[needle.length()];
        //初始化next数组
        next[0] = 0;          //开头第一个字符的最长公共前后缀长度为0
        int j = 0;            //j表示前缀字符串的末尾
        //i表示后缀字符串的末尾
        for (int i = 1; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                //如果前后缀不匹配就回退
                j = next[j-1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                //如果匹配成功，两个指针同时向前移动
                j++;
            }
            next[i] = j;
        }

        //构造完next数组后就可以使用next数组来匹配文本串haystack和模式串needle了
        //i指向haystack，j指向needle

        j = 0;
        for (int i = 0; i <haystack.length(); i++) {
            while(j>0&&haystack.charAt(i)!=needle.charAt(j)){
                j=next[j-1];
            }
            if(haystack.charAt(i)==needle.charAt(j)){
                j++;
            }
            if(j>=needle.length()){
                return i-needle.length()+1;
            }

        }
        return -1;
    }


    public int strStr_My(String haystack, String needle) {
        /**
         * 我的思路：双指针，该思路无法全部通过
         * 一个指针h指向haystack，另一个指针n指向needle
         * 如果h和n指向的字符相同，则h和n同时移动，否则n重新指向needle的开头
         * 直到h超出haystack的长度或n超出needle的长度
         * 如果h超出haystack的长度的同时n没有超出needle的长度说明haystack中不存在needle，返回-1
         * 如果n超出needle的长度说明haystack中存在needle，返回(h-needle的长度)。
         *
         */

        int h = 0;
        int n = 0;
        while (h < haystack.length() && n < needle.length()) {
            if (haystack.charAt(h) == needle.charAt(n)) {
                h++;
                n++;
            } else {
                h++;
                n = 0;
            }
        }
        if (h >= haystack.length() && n < needle.length()) {
            return -1;
        }

        return h - needle.length();
    }
}
