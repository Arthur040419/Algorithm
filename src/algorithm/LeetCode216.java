package algorithm;

import java.util.ArrayList;
import java.util.List;

//216.组合总和III
public class LeetCode216 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        findPath(k,n,1,0);
        return result;
    }

    //未剪枝优化 耗时1ms
    private void findPath(int k, int n, int begin, int curSum) {
        /**
         * 思路：
         * 同样的回溯，9是树的宽度，而k就是递归的深度。
         * 因此这里的终止条件就是path中的节点个数为k时，此时计算path的总和，如果等于n就存入结果集
         */
        if(path.size()==k){
            if(curSum==n){
                result.add(new ArrayList<>(path));
            }
            //踩坑点1:忘记return了
            return;
        }

        for (int i = begin; i < 10; i++) {
            path.add(i);
            findPath(k,n,i+1,curSum+i);
            //回溯
            path.remove(path.size()-1);
        }

    }

    //剪枝优化  耗时0ms
    private void findPath_Optimize(int k, int n, int begin, int curSum) {
        /**
         * 剪枝优化思路：
         * 如果当前路径总和已经大于n，直接剪枝
         * 循环范围也可以优化，循环索引最大为：9-(k-path.size())+1
         */

        //剪枝
        if(curSum>n){
            return;
        }
        if(path.size()==k){
            if(curSum==n){
                result.add(new ArrayList<>(path));
            }
            return;
        }

        //循环范围剪枝
        for (int i = begin; i <= 9-(k-path.size())+1; i++) {
            path.add(i);
            findPath_Optimize(k,n,i+1,curSum+i);
            //回溯
            path.remove(path.size()-1);
        }

    }
}
