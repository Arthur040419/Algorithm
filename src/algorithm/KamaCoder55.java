package algorithm;

import java.util.Scanner;

//右旋字符串
public class KamaCoder55 {

    public static void main(String[] args) {
        /**
         * 学到的新思路：
         * 字符串的”负负得正“的思想，即：翻转的字符再翻转一遍就会恢复原样
         * 在这里，我们根据k的值将字符串分成两部分，后面k个字符为一部分，剩下的字符为另一个部分
         * 此时，这道题的思路就变得和LeetCode151翻转字符串里的单词很像，我们可以把第一个部分看成一个单词，另一个部分也看成一个单词
         * 所以，先将字符串整体翻转，然后对每一个部分的字符串进行翻转
         */
        Scanner sc = new Scanner(System.in);
        int k =sc.nextInt();
        String s = sc.next();
        StringBuilder sb = new StringBuilder(s);
        //先翻转整个字符串
        reverseSinglePart(sb,0,sb.length()-1);
        //再翻转每一个部分
        reverseSinglePart(sb,0,k-1);
        reverseSinglePart(sb,k,sb.length()-1);
        System.out.println(sb);

    }
    public static void reverseSinglePart(StringBuilder sb,int start,int end){
        //翻转部分字符串，范围为[start,end]，包前包后
        while (start<end){
            char tmp = sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,tmp);
            start++;
            end--;
        }

    }


    public static void main_my(String[] args) {
        /**
         * 我的思路：
         * 约瑟夫回环，新建一个索引index指向倒数第k个字符
         * 输出索引指向的字符，然后index=（index+1）%字符串长度，一直循环输出索引指向的字符
         * 直到索引回到最开始的位置
         */
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String s = sc.next();
        int init = s.length()-k;
        int index = init;
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(index));
        index=(index+1)%len;
        while (index!=init){
            sb.append(s.charAt(index));
            index=(index+1)%len;
        }
        System.out.println(sb.toString());
    }
}
