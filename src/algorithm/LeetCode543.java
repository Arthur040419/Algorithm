package algorithm;

import dataStructure.TreeNode;

//543.二叉树的直径
public class LeetCode543 {

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
        if(root==null){
            return 0;
        }
        int L = getMaxPath(root.left);
        int R = getMaxPath(root.right);

        result = result < L + R ? L + R : result;
        return (L < R ? R : L) + 1;
    }

}
