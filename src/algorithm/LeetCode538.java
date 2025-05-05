package algorithm;

import dataStructure.TreeNode;

//538.把二叉搜索树转换为累加树
public class LeetCode538 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        /**
         * 思路：
         * 首先要清除什么是累加树，累加树是使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
         * 而对于二叉搜索树，它的值是有序的，所以要得到二叉搜索树的累加树，只需要从后往前累加即可
         * 通过中序遍历可以得到一个递增的数组，而通过反中序遍历（右中左），就可以实现从后往前累加
         */
        if(root==null) return root;
        convertBSTSolution(root);
        return root;
    }

    private void convertBSTSolution(TreeNode root) {
        if(root.left==null&&root.right==null){
            root.val+=sum;
            sum = root.val;
            //踩坑点1：忘记返回了
            return;
        }

        if(root.right!=null) convertBSTSolution(root.right);
        root.val+=sum;
        sum=root.val;
        if(root.left!=null) convertBSTSolution(root.left);
    }

}
