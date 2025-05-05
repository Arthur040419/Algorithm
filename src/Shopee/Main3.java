package Shopee;

import java.util.ArrayList;
import java.util.List;

//2025虾皮笔试，编程题第3题
public class Main3 {

    //AC 100%
    public int[][] rerankItems(int[][] items) {
        /**
         * 思路：
         * 使用两个集合来分别存放库存大于0、库存等于0的商品
         * 依次遍历所有商品，商品库存大于0的放入第一个集合，商品库存等于0的放入第二个集合
         * 最后将两个集合合并输出
         */
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();

        for (int[] item : items) {
            if (item[1] > 0) {
                list1.add(item);
            } else {
                list2.add(item);
            }
        }
        //合并两个集合
        int size = list1.size() + list2.size();
        int[][] result = new int[size][];
        for (int i = 0; i < list1.size(); i++) {
            result[i] = list1.get(i);
        }
        int len1 = list1.size();
        for (int i = 0; i < list2.size(); i++) {
            result[len1 + i] = list2.get(i);
        }
        return result;
    }

}
