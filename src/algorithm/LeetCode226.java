package algorithm;

import dataStructure.TreeNode;

//226.翻转二叉树
public class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        //递归法
        invertSolution1(root);

        return root;
    }

    /**
     * 递归法
     * @param root
     */
    private void invertSolution1(TreeNode root) {
        /**
         * 思路比较简单
         * 这里采用前序遍历
         * 先交换根节点的左右子节点
         * 再交换左节点的左右子节点
         * 最后再交换右节点的左右子节点
         */

        //递归终止条件
        if(root==null) return;

        //交换根节点的左右子节点
        TreeNode tmp;
        tmp=root.right;
        root.right=root.left;
        root.left=tmp;

        //递归处理左右子节点
        invertSolution1(root.left);
        invertSolution1(root.right);
    }
}
