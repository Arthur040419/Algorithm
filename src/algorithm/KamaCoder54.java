package algorithm;

import java.util.Scanner;

//替换数字
public class KamaCoder54 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(replaceNumber(s));
    }

    public static String replaceNumber_My(String s){
        //使用正则表达式很简单，但是学不到啥东西
        String result = s.replaceAll("\\d", "number");
        return result;
    }

    public static String replaceNumber(String s){
        //不使用正则表达式
        /**
         * 思路：
         * 首先根据原字符串中数字的个数来扩容字符数组，每有一个数字，字符数组长度就扩容5个
         * 接着采用双指针法，left指向原数组的最后一个字符，right指向扩容后的数组的最后一个位置
         * 两指针同时从后往前遍历，如果left所指的元素为字母，就将该字母复制到right所指向的位置
         * 如果left所指的元素为数字，就将right-5到right这块区域的内容改为number
         * 然后更新right指针为right-6，left指针也向前移动一位
         *
         */

        int count=0;
        //判断原字符串中数字的个数
        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))){
                count++;
            }
        }
        //扩容字符数组
        char[] newChars = new char[s.length()+count*5];
        //将原数组的内容复制到新数组中
        System.arraycopy(s.toCharArray(),0,newChars,0,s.length());
        //采用双指针从后往前遍历
        int left = s.length()-1;
        int right = newChars.length-1;
        while(left<right){
            if(!Character.isDigit(newChars[left])){
                //如果left所指的字符不是数字，直接将该字符复制到right位置上
                newChars[right]=newChars[left];
                right--;
                left--;
            }else{
                //如果left所指的字符是数字，就将right-5到right这块区域的内容改为number
                newChars[right--]='r';
                newChars[right--]='e';
                newChars[right--]='b';
                newChars[right--]='m';
                newChars[right--]='u';
                newChars[right--]='n';
                left--;
            }
        }
        return String.valueOf(newChars);
    }

}
