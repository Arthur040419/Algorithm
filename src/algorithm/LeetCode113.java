package algorithm;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

//113.路径总和II
public class LeetCode113 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if (root == null) return result;
        List<Integer> path = new ArrayList<>();
        pathSumSolution(root, path, targetSum);
        return result;
    }

    private void pathSumSolution(TreeNode root, List<Integer> path, int targetSum) {
        path.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            //这里需要注意，添加路径时一定要重新创建一个新的集合，不然会共享同一个集合，导致最后结果都只有一个根节点
            //result.add(path);
            result.add(new ArrayList<>(path));
        }
        if (root.left == null && root.right == null) return;



        if(root.left!=null){
            pathSumSolution(root.left,path,targetSum);
            //回溯
            path.remove(path.size()-1);
        }
        if(root.right!=null){
            pathSumSolution(root.right,path,targetSum);
            //回溯
            path.remove(path.size()-1);
        }

    }

}
