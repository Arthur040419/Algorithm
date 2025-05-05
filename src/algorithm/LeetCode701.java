package algorithm;

import dataStructure.TreeNode;

//701.二叉搜索树中的插入操作
public class LeetCode701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        /**
         * 思路：
         * 我一开始以为这是平衡二叉搜索树，需要在插入节点后保持二叉树平衡，所以觉得很难，结果发现就是普通的二叉搜索树。
         * 普通的二叉搜索树插入节点，只需要按顺序遍历，一直遍历到空节点为止，空节点的位置就是插入节点的位置
         */
        if(root==null){
            return new TreeNode(val);
        }

        if(val<root.val) root.left = insertIntoBST(root.left,val);
        if(val>root.val) root.right = insertIntoBST(root.right,val);
        return root;

    }
}
