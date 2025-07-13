package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//77.组合
public class LeetCode77 {
    List<List<Integer>> results = new ArrayList<>();
    List<Integer> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        /**
         * 思路：
         * 回溯算法的经典题目。
         * 利用一个for循环从数组范围内依次取一个数num，然后递归从num后面剩下的数中取剩下的值，直到已经取了k个数字。
         * 在递归时，利用begin代表取值范围的开始索引，防止取值重复
         */

        getNums(n, 1, k);
        return results;
    }

    //没有剪枝优化，耗时为20ms
    private void getNums(int n, int begin, int k) {
        if (res.size() == k) {
            //将其中一种组合添加到最终结果集中
            results.add(new ArrayList<>(res));
            return;
        }
        for (int i = begin; i <= n; i++) {
            res.add(i);
            getNums(n, i + 1, k);
            //回溯
            res.remove(res.size() - 1);
        }

    }

    //剪枝优化 耗时18ms
    private void getNums_Optimize(int n, int begin, int k) {
        /**
         * 剪枝优化的思路是，如果发现加上剩下的所有数都无法组合成一个长度为k的组合，就直接返回
         */
        if (res.size() == k) {
            //将其中一种组合添加到最终结果集中
            results.add(new ArrayList<>(res));
            return;
        }
        for (int i = begin; i <= n; i++) {
            res.add(i);
            //剪枝优化
            if (res.size() + n - i >= k) {
                getNums_Optimize(n, i + 1, k);
            }else{
                res.remove(res.size()-1);
                return;
            }
            //回溯
            res.remove(res.size() - 1);
        }

    }
}
