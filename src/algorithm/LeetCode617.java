package algorithm;

import dataStructure.TreeNode;

//617.合并二叉树
public class LeetCode617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        //递归法
        return mergeTreesSolution1(root1, root2);

    }

    private TreeNode mergeTreesSolution1(TreeNode root1, TreeNode root2) {
        /**
         * 思路：
         * 要合并两个二叉树，其实就是要同时操作两颗树，同时去遍历两颗树
         * 可以采用任何遍历方式，这里使用前序遍历
         * 首先对于传进来的两颗树的根节点
         * 如果其中一个根节点为空，就直接返回不为空的那个根节点
         * 如果都为空，直接返回null
         * 如果都不为空，就合并两个节点
         * 接着去递归合并两个根节点的左右子树
         */

        //这里如果两个根节点都为空，也就直接返回null了
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        //合并两个根节点的左右子树，这里直接修改第一个树上进行修改来作为合并后的树
        root1.val += root2.val;
        root1.left = mergeTreesSolution1(root1.left, root2.left);
        root1.right = mergeTreesSolution1(root1.right, root2.right);

        return root1;
    }

}
