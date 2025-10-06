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

    //复习-2025-09-18
    public TreeNode invertTree_Review(TreeNode root) {
        if(root==null) return root;
        return invertTreeSolution_Review(root);
    }

    public TreeNode invertTreeSolution_Review(TreeNode root){
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if(root.left!=null){
            invertTreeSolution_Review(root.left);
        }
        if(root.right!=null){
            invertTreeSolution_Review(root.right);
        }

        return root;
    }

    //复习2-2025-09-29
    public TreeNode invertTree_Review2(TreeNode root) {
        invertTreeSolution_Review2(root);
        return root;
    }

    public void invertTreeSolution_Review2(TreeNode root){
        if(root==null){
            return;
        }

        //反转左右子树的根节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        //反转左子树
        invertTreeSolution_Review2(root.left);
        //反转右子树
        invertTreeSolution_Review2(root.right);
    }


}
