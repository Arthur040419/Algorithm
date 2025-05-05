package algorithm;

import dataStructure.TreeNode;

//700.二叉搜索树中的搜索
public class LeetCode700 {

    //递归法
    public TreeNode searchBST(TreeNode root, int val) {
        /**
         * 思路：
         * 这题实际上就是在二叉搜索树中寻找一个节点
         * 采用递归
         * 如果当前节点为空或者当前节点的值为目标值，就返回null或当前节点
         * 如果当前节点的值大于目标值，就去递归搜索左子树
         * 如果当前节点的值小于目标值，就去递归搜索右子树
         */

        if(root==null||root.val==val) return root;

        TreeNode result = null;
        if(root.val>val) result = searchBST(root.left,val);
        if(root.val<val) result = searchBST(root.right,val);
        return result;
    }

    //迭代法
    public TreeNode searchBST2(TreeNode root, int val) {
        /**
         * 迭代法也非常简单
         * 对于普通二叉树的迭代法，我们需要借助一个队列来存储要遍历的节点
         * 而对于搜索二叉树来说，不需要，因为搜索二叉树的有序性，我们在遍历一个节点时，就能够确定下一个应该遍历哪一个节点了
         * 因此不需要额外的队列来存储要遍历的节点，我们知道是那个节点就直接去遍历就行
         */

        while (root!=null){
            if(root.val==val){
                break;
            }
            if(root.val>val){
                root=root.left;
            }else if(root.val<val){
                root=root.right;
            }
        }
        return root;
    }
}
