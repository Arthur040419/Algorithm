package algorithm;

import java.util.ArrayList;
import java.util.List;

//93.复原IP地址
public class LeetCode93 {

//    public static void main(String[] args) {
//        restoreIpAddresses("25525511135");
//    }

    private  List<String> result = new ArrayList<>();

    public  List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder(s);
        backtracking(sb, 0, 0);
        return result;
    }

    private  void backtracking(StringBuilder sb, int begin, int pointCount) {
        /**
         * 思路：
         * 其实就是相当于对一个数组进行分割，类似LeetCode131分割回文串
         * 这里pointCount代表已经插入点`.`分隔符的个数，回溯的终止条件就是当插入的点分隔符等于3个时，此时正好就是一个IP地址
         *
         */

        //终止条件
        if (pointCount == 3) {
            //判断IP地址的最后一段是否合法
            String substring = sb.substring(begin, sb.length());
            if (isVaild(substring)) {
                //如果合法，才将其加入到结果集
                result.add(sb.toString());
            }
            return;
        }
        //这个也可以，耗时会更低
//        for (int i = begin; i < begin + 3 &&i < sb.length(); i++) {
        for (int i = begin; i <sb.length(); i++) {
            String substring = sb.substring(begin, i + 1);
            if (isVaild(substring)) {
                sb.insert(i + 1, ".");
                //踩坑点1：不能是pointCount++，因为pointCount++是先使用再自增，比如pointCount原本为1，那么实际传给函数的值还是1而不是2，传给函数后才会变成2
                //backtracking(sb, i + 2, pointCount++);
                backtracking(sb, i + 2, pointCount+1);
                //回溯
                sb.deleteCharAt(i + 1);
            }else {
                break;
            }
        }


    }

    //判断IP的某个部分是否合法
    private  boolean isVaild(String substring) {
        if(substring.isEmpty()) return false;
        //前导为0
        if (substring.charAt(0) == '0' && substring.length() != 1) {
            return false;
        }

        int num = 0;
        for (int i = 0; i < substring.length(); i++) {
            if (substring.charAt(i) < '0' || substring.charAt(i) > '9') {
                //存在非数字字符
                return false;
            }
            num = num * 10 + substring.charAt(i) - '0';
        }
        //范围在0~255之间才合法
        return num >= 0 && num <= 255;
    }
}
