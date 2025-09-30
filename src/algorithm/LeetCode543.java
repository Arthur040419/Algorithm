package algorithm;

import dataStructure.TreeNode;

//543.二叉树的直径
public class LeetCode543 {

    int res = 0;

    //复习-2025-09-29
    public int diameterOfBinaryTree(TreeNode root) {
        getMaxPath(root);
        return res;
    }

    public int getMaxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int L = getMaxPath(root.left);
        int R = getMaxPath(root.right);

        res = Math.max(res, L + R);
        return Math.max(L, R) + 1;
    }
}
