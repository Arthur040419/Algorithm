package algorithm;

import dataStructure.TreeNode;

//669.修剪二叉搜索树
public class LeetCode669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        /**
         * 思路：
         * 遍历左右子树，找到左右子树在修剪完成后的根节点
         * 对于每一个根节点，如果该根节点的值小于low，说明该节点以及该节点的左子树全都要删除，所以返回右子树修剪完成后的根节点
         * 如果该根节点的值大于high，说明该节点以及该节点的右子树全都要删除，所以返回左子树修剪完成后的根节点
         * 如果根节点在low，high范围内，说明该根节点要保留，就去寻找该根节点的左右子树修剪完成后的根节点
         */

        if(root==null) return null;

        if(root.val<low){
            //如果根节点小于low
            return trimBST(root.right,low,high);
        }
        if(root.val>high){
            //如果根节点大于high
            return trimBST(root.left,low,high);
        }

        //如果根节点在low，high范围内，说明该根节点要保留
        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);
        return root;
    }

}
