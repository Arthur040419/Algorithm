package algorithm;

import dataStructure.TreeNode;

//543.二叉树的直径
public class LeetCode543 {


    int res = 0;

    //复习-2025-09-29
    public int diameterOfBinaryTree_Review2(TreeNode root) {
        getMaxPath_Review2(root);
        return res;
    }

    public int getMaxPath_Review2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int L = getMaxPath_Review2(root.left);
        int R = getMaxPath_Review2(root.right);

        res = Math.max(res, L + R);
        return Math.max(L, R) + 1;
    }

    //最长直径
    int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        /**
         * 思路：
         * 一个二叉树中有多个节点，每一个节点都有左右两边通向最深节点的路径L、R，L+R就是经过这个节点的最长路径，
         * 因此整个二叉树的直径就是所有节点中的最长路径中最长的那个，
         */

        getMaxPath(root);
        return result;

    }

    public int getMaxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = getMaxPath(root.left);
        int R = getMaxPath(root.right);

        result = result < L + R ? L + R : result;
        return (L < R ? R : L) + 1;
    }

    //复习-2025-09-19
    public int diameterOfBinaryTree_Review(TreeNode root) {
        getMaxPath_Review(root);
        return result;
    }

    public int getMaxPath_Review(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = getMaxPath_Review(root.left);
        int R = getMaxPath_Review(root.right);

//        result = Math.max(result, L + R + 1);     //这里不需要加1，因为定义的直径是两个节点之间的边数而不是节点数
        result = Math.max(result,L+R);
        return L > R ? L + 1 : R + 1;
    }
}
