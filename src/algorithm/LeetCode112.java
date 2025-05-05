package algorithm;

import dataStructure.TreeNode;

//112.路径总和
public class LeetCode112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        //1.递归法
        if(root==null) return false;
        return hasPathSumSolution1(root, targetSum);

    }

    private boolean hasPathSumSolution1(TreeNode root, int targetSum) {
        /**
         * 思路：
         * 递归判断子节点是否存在符合条件的路径
         * 递归时采用递减，每经过一个节点就用目标值减去经过节点的值，然后再从节点的子节点中去寻找有没有路径的和为剩余的值
         * 当遇到叶子节点时就是递归的终止条件
         * 遇到叶子节点时判断目标值减去当前节点的值后是否为0，如果为0返回true，表示找到了符合条件的路径
         * 如果不为0，就返回false
         */

        //终止条件
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) return true;
        if (root.left == null && root.right == null) return false;

        if(root.left!=null) {
            if(hasPathSumSolution1(root.left,targetSum)){
                return true;
            }
        }
        if(root.right!=null) {
            if(hasPathSumSolution1(root.right,targetSum)){
                return true;
            }
        }

        return false;
    }
}
