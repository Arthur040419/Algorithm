package algorithm;

import dataStructure.TreeNode;

//111.二叉树的最小深度
public class LeetCode111 {

    public int minDepth(TreeNode root) {
        //递归法
        return minDepthSolution1(root);


    }

    /**
     * 递归法
     * @param root
     * @return
     */
    private int minDepthSolution1(TreeNode root) {
        /**
         * 思路与求最大深度差不多，只不过这里取的是左右子树深度的较小值，而不是较大值
         * 但是还有一个细节需要注意，如果存在左子树或右子树为空的时候，就不需要去计算为空的那个子树，
         * 因为二叉树的深度指的是从根节点到叶子节点的深度，如果树为空，那哪来的叶子节点，因此不需要管为空的子树
         */

        //递归终止条件
        if(root==null) return 0;
        //这里采用后序遍历，也就是求当前节点的高度
        //先获取左右子树的高度
        int leftDepth = minDepthSolution1(root.left);
        int rightDepth = minDepthSolution1(root.right);

        //要对存在空树的情况进行特别处理
        if(root.left==null&&root.right!=null){
            return 1+rightDepth;
        }
        if(root.left!=null&&root.right==null){
            return 1+leftDepth;
        }
        //如果不存在空树的情况就取左右子树中高度最小的一个
        return 1+Math.min(leftDepth,rightDepth);
    }

}
