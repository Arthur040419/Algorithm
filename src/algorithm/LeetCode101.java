package algorithm;

import dataStructure.TreeNode;

//101.对称二叉树
public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        //判断是否是对称二叉树其实就是判断左右子树是否对称。
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        /**
         * 思路：
         * 递归比较左右子树是否对称
         * 关键是比较两个子树的外侧和内侧是否相等，即左子树的左半部分是否与右子树的右半部分相等，左子树的右半部分是否与右子树的左半部分相等
         */

        //递归终止条件，两个节点中存在null节点，或者两个节点的值不相等
        if (left == null && right != null) return false;
        else if (left != null && right == null) return false;
        else if (left == null && right == null) return true;
        else if (left.val != right.val) return false;

        //比较外侧子树是否相等
        boolean outside = compare(left.left, right.right);
        //比较内侧子树是否相等
        boolean inside = compare(left.right, right.left);
        //如果外侧和内侧子树都相等，说明树是对称的
        return outside && inside;
    }

    //复习-2025-09-17
    public boolean isSymmetric_Review(TreeNode root) {
        if (root == null) return true;
        return compare_Review(root.left, root.right);
    }

    public boolean compare_Review(TreeNode left, TreeNode right) {

        if (left == null && right != null) return false;
        else if (left != null && right == null) return false;
        else if (left == null && right == null) return true;
        else if (left.val != right.val) return false;

        boolean outside = compare_Review(left.left, right.right);
        boolean inside = compare_Review(left.right, right.left);
        return outside && inside;
    }


}
