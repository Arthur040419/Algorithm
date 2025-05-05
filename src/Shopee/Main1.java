package Shopee;


import java.util.*;

//2025虾皮笔试，编程题第一题
public class Main1 {

    public static void main(String[] args) {
        System.out.println(canFormSquare(new int[]{1, 1, 2, 2, 2}));
    }

    //最终AC 75%
    public static boolean canFormSquare(int[] planks) {
        /**
         * 思路：
         * 首先判断所有木板的长度和是否为4的倍数，如果不为4的倍数，直接返回false
         * 如果为4的倍数，就去判断每一个木板的长度是否对应的木板与其相加等于正方形的边长
         * 如果所有木板都有与其匹配的木板就说明能够组成正方形(每一边不一定只有两个木板组成，可能有多个木板)
         * 使用栈来判断一个木板是否存在多个木板与其相加等于边长
         * 首先剔除所有长度刚好为边长的木板
         * 将剩余的木板排序后，从小到大遍历，依次存入栈中
         * 存入是判断如果将当前木板存入栈中后，栈中所有木板相加是否大于边长，如果大于边长，就一直弹出栈顶木板，直到和小于边长或者等于边长
         * 如果遍历完所有木板发现始终无法找到和刚好为边长的组合，说明无法组成正方形
         * 否则不能组成正方形
         */

        int length = 0;
        Arrays.sort(planks);
        List<Integer> list = new ArrayList<>();
        for (int plank : planks) {
            list.add(plank);
            length += plank;
        }
        if (length % 4 != 0) return false;
        //获取正方形的边长
        int a = length / 4;
        //剔除所有长度等于边长的木板
        //count 为长度刚好为边长的木板数
        int count = 0;
        while (list.contains(a)) {
            list.remove(a);
            count++;
        }
        Deque<Integer> stack = new LinkedList<>();
        //获取判断次数
        int n = 4 - count;
        for (int i = 0; i < n; i++) {
            if (!find(a, list)) return false;
        }
        return true;
    }

    private static boolean find(int a, List<Integer> list) {
        /**
         * 递归
         */
        if (list.contains(a)) return true;
        for (Integer i : list) {
            if (a - i > 0) {
                list.remove(i);
                return find(a - i,list);
            }else {
                return false;
            }
        }
        return false;
    }


    //备份代码，AC50%
    public boolean canFormSquare_backup(int[] planks) {
        /**
         * 思路：
         * 首先判断所有木板的长度和是否为4的倍数，如果不为4的倍数，直接返回false
         * 如果为4的倍数，就去判断每一个木板的长度是否有一个对应的木板与其相加等于正方形的边长
         * 如果所有木板都有一个与其匹配的木板就说明能够组成正方形
         * 否则不能组成正方形
         */

        int length = 0;
        Arrays.sort(planks);
        List<Integer> list = new ArrayList<>();
        for (int plank : planks) {
            list.add(plank);
            length += plank;
        }
        if (length % 4 != 0) return false;
        //获取正方形的边长
        int a = length / 4;

        for (int i = 0; i < list.size(); i++) {
            //排除长度刚好为边长的木板
            if (list.get(i) == a) {
                continue;
            }
            int l = a - list.get(i);
            if (list.contains(l)) {
                list.remove(i);
                i--;
                list.remove(l);
            } else {
                return false;
            }

        }
        return true;
    }

}
