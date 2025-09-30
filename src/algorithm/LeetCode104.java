package algorithm;

import dataStructure.TreeNode;

//104.二叉树的最大深度
public class LeetCode104 {

    public int maxDepth(TreeNode root) {
        /**
         * 首先要搞清楚的概念
         * 二叉树的深度指的是从根节点到当前节点所经过的最少边数（从0开始）或经过的最少的节点数（从1开始）
         * 二叉树的高度指的是当前节点到叶子节点所经过的最长路径的边数（从0开始）或经过的最多的节点数
         *
         * 如果要求二叉树的最大深度，只需要求出该二叉树左右子树的最大深度，然后取出两个当中的最大值，然后+1就是这颗二叉树的最大深度了。
         * 并且本题中的深度指的是经过的最长路径上的节点数，因此深度从1开始
         */

        return maxDepthSolution(root);

    }


    /**
     * 递归法
     * @param root
     * @return
     */
    private int maxDepthSolution(TreeNode root) {
        //递归终止条件
        if(root==null) return 0;

        int leftDepth = maxDepthSolution(root.left);
        int rightDepth = maxDepthSolution(root.right);

        return Math.max(leftDepth,rightDepth)+1;
    }

    //复习
    public int maxDepth_Review(TreeNode root) {
        return maxDepthSolution_Review(root);
    }

    public int maxDepthSolution_Review(TreeNode root){
        if(root==null){
            return 0;
        }
        int depthLeft = maxDepthSolution_Review(root.left);
        int depthRight = maxDepthSolution_Review(root.right);
        return Math.max(depthLeft,depthRight)+1;
    }

    //复习2-2025-09-29
    public int maxDepth_Review2(TreeNode root) {
        return maxDepthSolution_Review2(root);
    }

    public int maxDepthSolution_Review2(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftDepth = maxDepthSolution_Review2(root.left);
        int rightDepth = maxDepthSolution_Review2(root.right);

        return Math.max(leftDepth,rightDepth)+1;
    }

}
