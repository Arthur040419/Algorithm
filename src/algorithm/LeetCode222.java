package algorithm;

import dataStructure.TreeNode;

//222.完全二叉树的节点个数
public class LeetCode222 {
    public int countNodes(TreeNode root) {
        /**
         * 思路：
         * 这里当然可以直接用遍历普通二叉树的方法来统计节点个数，使用前中后序遍历啥的都行
         * 但是这里既然是完全二叉树，那我们就多利用一下完全二叉树的特性
         * 完全二叉树除了底层外，其他层的节点一定是满的。
         * 而要计算一个完全二叉树的节点个数，可以直接使用公式：2^n-1，n为树的深度，从1开始
         * 我们又直到，满二叉树是一个特殊的完全二叉树，因此如果题目给的二叉树是满二叉树我们就可以直接使用公式
         * 那我们要做的就是来判断这颗完全二叉树是不是满二叉树，而判断完全二叉树树是不是满二叉树可以使用如下思路：
         * 一直遍历左节点，获取左树的深度；一直遍历右节点，获取右树的深度。最后比较两树的深度是否一致，如果一致就说明是满二叉树
         * 以上的思路只有在给的树是完全二叉树时才有效。
         *
         * 所以我们接下来的步骤就变成了，先判断这棵树是不是满二叉树，如果是直接用公式计算，然后返回结果，如果不是，就分别进入左右子树去判断左右子树是不是满二叉树
         * 就这样一直递归。
         */

        if(root==null) return 0;
        //首先判断当前的完全二叉树是不是满二叉树
        int countLeft = 0;
        int countRight = 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        //一直遍历左节点
        while (left!=null){
            countLeft++;
            left=left.left;
        }
        //一直遍历右节点
        while (right!=null){
            countRight++;
            right=right.right;
        }
        //如果是满二叉树直接用公式计算结果返回
        if(countLeft==countRight){
            //注意，位运算的优先级比加减要小
            return (2<<countLeft)-1;
        }

        //如果不是满二叉树进入子树
        return countNodes(root.left)+countNodes(root.right)+1;

    }
}
