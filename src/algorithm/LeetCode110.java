package algorithm;

import dataStructure.TreeNode;

//110.平衡二叉树
public class LeetCode110 {

    public boolean isBalanced(TreeNode root) {
        /**
         * 思路：
         * 递归获取左右子树的高度，比较左右子树的高度，
         * 如果高度差大于1，则返回-1表示不是平衡二叉树
         * 如果高度差小于等于1，则返回最高的高度，表示根节点的高度
         */
        if (root == null) return true;

        //获取左子树的高度
        int leftHeight = getHeight(root.left);
        //如果子树不是平衡二叉树，直接返回false，表示该树不是平衡二叉树
        if (leftHeight == -1) return false;
        //获取右子树的高度
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) return false;

        return Math.abs(leftHeight - rightHeight) > 1 ? false : true;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;

        //采用后序遍历获取树的高度
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) return -1;

        //如果获取到的子树的高度差大于1，返回-1表示不是平衡二叉树
        return Math.abs(leftHeight - rightHeight) > 1 ? -1 : 1 + Math.max(leftHeight, rightHeight);

    }

}
